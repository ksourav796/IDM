package com.hyva.idm.config;
import com.hyva.idm.sass.sassentities.EmailReader;
import com.hyva.idm.sass.sasspojo.EmailReaderPojo;
import com.hyva.idm.sass.sassrespositories.EmailReaderRepository;
import com.hyva.idm.sass.sassrespositories.EmailStoreRepository;
import com.hyva.idm.sass.sassservice.EmailStore;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.mail.Mail;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.AndTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromTerm;
import javax.mail.search.SearchTerm;

/**
 * This program demonstrates how to download e-mail messages and save
 * attachments into files on disk.
 *
 * @author www.codejava.net
 *
 */



@Component
public class Imapemail  extends TimerTask implements Runnable{
    private final Logger log = Logger.getLogger(getClass());
    @Autowired
    Imapemail Imapemail;
    @Autowired
    EmailReaderRepository emailReaderRepository;

    public EmailStore getEmailStore() {
        return emailStore;
    }

    public void setEmailStore(EmailStore emailStore) {
        this.emailStore = emailStore;
    }

    @Autowired
    EmailStore emailStore;
    @Autowired
    EmailStoreRepository emailStoreRepository;

//    @Autowired
//    EmailReaderPojo emailReaderPojo;

    private String saveDirectory;


    long delay = 1000 * 60*1; // delay in milliseconds
    Timer timer = new Timer("emailAttachmentReceiver");
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        timer.cancel();
        timer = new Timer("emailAttachmentReceiver");
        Date executionDate = new Date(); // no params = now
        timer.scheduleAtFixedRate(Imapemail, executionDate, delay);
    }


    @Override
    public void run() { List<EmailReader> emailReader= (List<EmailReader>) emailReaderRepository.findAll();
        if(!emailReader.isEmpty()){

            triggerEmailReaderTasks(emailReader);}
    }


    public void triggerEmailReaderTasks(List<EmailReader> emailReader) {
        try {

            for (EmailReader emailRead : emailReader) {
                triggerEmailReader(emailRead);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void triggerEmailReader(EmailReader email) throws JSONException, ParseException, IOException {
        String saveDirectory = "/home/hyva/Desktop/Attachment";
        Imapemail receiver = new Imapemail();
        receiver.setEmailStore(this.emailStore);
        receiver.setSaveDirectory(saveDirectory);
        receiver.downloadEmailAttachments(email.getHost(),email.getPort(),email.getUsername(), email.getPassword());

    }



    /**
     * Sets the directory where attached files will be stored.
     * @param dir absolute path of the directory
     */
    public void setSaveDirectory(String dir) {
        this.saveDirectory = dir;
    }

    /**
     * Downloads new messages and saves attachments to disk if any.
     * @param host
     * @param port
     * @param userName
     * @param password
     */




    public void downloadEmailAttachments(String host, String port,
                                         String userName, String password) {
        Properties properties = new Properties();
        // server setting
        properties.put("mail.host", host);
        properties.put("mail.port", port);
//
//        // SSL setting
//        properties.setProperty("mail.pop3.socketFactory.class",
//                "javax.net.ssl.SSLSocketFactory");
//        properties.setProperty("mail.pop3.socketFactory.fallback", "false");
//        properties.setProperty("mail.pop3.socketFactory.port",
//                String.valueOf(port));
//        properties.setProperty("mail.host", "imap.gmail.com");
//        properties.setProperty("mail.port", "995");
        properties.setProperty("mail.transport.protocol", "imaps");

        Session sessionEmail = Session.getDefaultInstance(properties);

        try {
            // connects to the message store
            Store store = sessionEmail.getStore("imaps");
            store.connect(userName, password);


            // opens the inbox folder
            Folder folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_WRITE);

            // fetches new messages from server
            FromTerm fromTerm = new FromTerm(new InternetAddress("hinexthyva1@gmail.com"));
            SearchTerm searchTerm = new AndTerm(fromTerm, new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            Message[] arrayMessages = folderInbox.search(searchTerm);

            for (int i = 0; i < arrayMessages.length; i++) {
                Message message = arrayMessages[i];
                Address[] fromAddress = message.getFrom();
                String from = fromAddress[0].toString();
                String subject = message.getSubject();
                String sentDate = message.getSentDate().toString();
                String contentType = message.getContentType();
                String messageContent = "";
//                System.out.println("UNREAD MESSAGES : " + folderInbox.getUnreadMessageCount());
                // store attachment file name, separated by comma
                String attachFiles = "";

                if (contentType.contains("multipart")) {
                    // content may contain attachments
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                            // this part is attachment
                            String fileName = part.getFileName();
                            attachFiles += fileName + ", ";
                            part.saveFile(saveDirectory + File.separator + fileName);

                        } else {
                            // this part may be the message content
                            messageContent = part.getContent().toString();

                        }
                    }

                    if (attachFiles.length() > 1) {
                        attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
                    }
                } else if (contentType.contains("text/plain")
                        || contentType.contains("text/html")) {
                    Object content = message.getContent();
                    if (content != null) {
                        messageContent = content.toString();
                    }
                }

                // print out details of each message
                System.out.println("Message #" + (i + 1) + ":");
                System.out.println("\t From: " + from);
                System.out.println("\t Subject: " + subject);
                System.out.println("\t Sent Date: " + sentDate);
                System.out.println("\t Message: " + messageContent);
                System.out.println("\t Attachments: " + attachFiles);
                arrayMessages[i].setFlag(Flags.Flag.SEEN, true);
                emailStore.retrivemaildetails(from,subject,sentDate,messageContent);

            }

            // disconnect
            folderInbox.close(false);
            store.close();

        } catch (NoSuchProviderException ex) {
            System.out.println("No provider for pop3.");
            ex.printStackTrace();
        } catch (MessagingException ex) {
            System.out.println("Could not connect to the message store");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Runs this program with Gmail POP3 server
     */
//    public static void main(String[] args) {
//
////        String protocol="imap";
////        String host = "imap.gmail.com";
////        String port = "995";
////        String userName = "hinexthyva@gmail.com";
////        String password = "hinexthiaccountshyvaproject";
//////
//        String saveDirectory = "/home/hyva/Desktop/Attachment";
//        EmailAttachmentReceiver receiver = new EmailAttachmentReceiver();
//        receiver.setSaveDirectory(saveDirectory);
////        receiver.downloadEmailAttachments(host, port, userName, password);
//     List<EmailReader> emailReader= (List<EmailReader>) emailReaderRepository.findAll();
//         for(EmailReader email:emailReader){
//           receiver.downloadEmailAttachments(email.getHost(),email.getUsername(), email.getPassword(),email.getPort());
//       }
//    }


}

