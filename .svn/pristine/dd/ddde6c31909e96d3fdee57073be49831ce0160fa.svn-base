package com.hyva.idm.sass.sassservice;
import com.hyva.idm.sass.sassentities.EmailServer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.integration.dsl.mail.Mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class MailService {
    public static String  sendMailWithAttachment(final EmailServer fromMailProps, String toEmail,
                                                String subject, String message, String contentType,
                                                byte[] attachment, String fileName) throws Exception {

        MimeMessage mimeMessage = getMimeMessage(fromMailProps);

        mimeMessage.setFrom(new InternetAddress(fromMailProps.getUserName(), ""));

        mimeMessage.setReplyTo(InternetAddress.parse(fromMailProps.getUserName(), false));

        mimeMessage.setSubject(subject, "UTF-8");

        mimeMessage.setSentDate(new Date());

        BodyPart messageBody = new MimeBodyPart();
        messageBody.setText(message);
        //4) create new MimeBodyPart object and set DataHandler object to this object
        MimeBodyPart attachmentBody = new MimeBodyPart();

        DataSource source = new ByteArrayDataSource(attachment,contentType);
        attachmentBody.setDataHandler(new DataHandler(source));
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBody);
        if(StringUtils.isNotEmpty(fileName)) {
            attachmentBody.setFileName(fileName);
            multipart.addBodyPart(attachmentBody);
        }

        mimeMessage.addRecipients(Message.RecipientType.CC, InternetAddress.parse(toEmail, false));
        mimeMessage.setContent(multipart);

        Transport.send(mimeMessage);

        return null;
    }


    private static MimeMessage getMimeMessage(final EmailServer fromMailProps){
        Properties props = new Properties();
        props.put("mail.smtp.host", fromMailProps.getSmtpHost()); //SMTP Host
        props.put("mail.smtp.port", fromMailProps.getPort()); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        props.put("mail.smtp.ssl.trust", "*");

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromMailProps.getUserName(), fromMailProps.getPassword());
            }
        };
        Session session = Session.getInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        return msg;
    }
}


