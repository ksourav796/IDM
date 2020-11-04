package com.hyva.idm.sass.sassservice;

import com.hyva.idm.icitem.IcItem;
import com.hyva.idm.icitem.IcItemRepository;
import com.hyva.idm.icitem.IcItempojo;
import com.hyva.idm.sass.sassentities.*;
import com.hyva.idm.sass.sassmapper.CustomerNotificationMapper;
import com.hyva.idm.sass.sassmapper.SassOrdersMapper;
import com.hyva.idm.sass.sasspojo.*;
import com.hyva.idm.sass.sassrespositories.*;
import com.hyva.idm.sass.sassutil.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.util.*;

import static com.hyva.idm.sass.sassutil.AccessTokenGenerator.randomAlphaNumeric;


@Component
public class SassOrdersService {
    @Autowired
    SassOrdersRepository sassOrdersRepository;
    @Autowired
    SassSubscriptionRepository sassSubscriptionRepository;
    @Autowired
    SassCustomerRepository sassCustomerRepository;
    @Autowired
    PosPaymentTypesRepository posPaymentTypesRepository;
    @Autowired
    SassTransactionRepository sassTransactionRepository;
    @Autowired
    SassCountryRepository SassCountryRepository;
    @Autowired
    SassCurrencyRepository SassCurrencyRepository;
    @Autowired
    SaasStateRepository SaasStateRepository;
    @Autowired
    SassUserRepository sassUserRepository;

    @Autowired
    IcItemRepository icItemRepository;
    @Autowired
    SassCompanyRepository sassCompanyRepository;
    @Autowired
    EmailServerRepository emailServerRepository;
    @Autowired
    RenewRepository renewRepository;


int paginatedConstants=15;

    public SassCustomer getCustomerObj(SassCustomer credentials)
    {
        SassCustomer sassCustomer=sassCustomerRepository.findByEmailAndLoginNameAndLoginPassword(credentials.getEmail(),credentials.getLoginName(),credentials.getLoginPassword());
        return sassCustomer;
    }
    @Value("${server.port}")
    private String url;

    @Transactional
    public SassOrders createbuynowOrderSave(SassOrdersPojo sassOrdersPojo) throws Exception {
        SassSubscriptions orders = sassSubscriptionRepository.findBySubscriptionNameAndVersion( sassOrdersPojo.getSubscriptionId(), sassOrdersPojo.getVersion() );
        List<SassOrders> sassOrdersList = sassOrdersRepository.findBySassSubscriptionsId( orders );
        if (sassOrdersList.size() < orders.getCompanies()) {
            Properties properties = new Properties();
            try {
                ClassPathResource cpr = new ClassPathResource( "idmwithsass.properties" );
                properties.load( cpr.getInputStream() );
            } catch (Exception je) {
                je.printStackTrace();
            }
            SassOrders sassOrders = null;
//        List<SassOrders> list = sassOrdersRepository.findByCompanyEmail(sassOrdersPojo.getCompanyEmail());
//        if (list.size() > 0) {
//            sassOrders = null;
//
//        } else {
            sassOrders = SassOrdersMapper.mapPojoToEntity( sassOrdersPojo );
            SassCountry country = SassCountryRepository.findByCountryName( sassOrdersPojo.getCountryId() );
            if (country != null)
                sassOrders.setCountryId( country );
            SassCurrency currency = SassCurrencyRepository.findByCurrencyName( sassOrdersPojo.getCurrencyId() );
            if (currency != null)
                sassOrders.setCurrencyId( currency );
            SaasState state = SaasStateRepository.findByStateName( sassOrdersPojo.getStateId() );
            if (state != null)
                sassOrders.setStateId( state );

            if (orders != null) {
                sassOrders.setSassSubscriptionsId( orders );
                if (orders.getSubscriptionId() != null && orders.getSubscriptionFor().equalsIgnoreCase( "Application" ) && StringUtils.pathEquals( orders.getType(), "fordeveloper" )) {
                    String numbers = "0123456789";
                    String sentance = "";
                    while (sentance.isEmpty()) {
                        Random rndm_method = new Random();
                        char[] otp = new char[6];
                        for (int i = 0; i < 6; i++) {
                            otp[i] = numbers.charAt( rndm_method.nextInt( numbers.length() ) );
                        }
                        sentance = String.valueOf( otp );
                        SassOrders sassOrders1 = sassOrdersRepository.findByDeveloperId( sentance );
                        if (sassOrders1 == null)
                            sassOrders.setDeveloperId( sentance );
                        else
                            sentance = "";
                    }
                } else if (orders.getSubscriptionId() != null && orders.getSubscriptionFor().equalsIgnoreCase( "Application" ) && StringUtils.pathEquals( orders.getType(), "forcustomer" )) {
                    sassOrders.setDeveloperId( sassOrdersPojo.getDeveloperId() );
                }
            }
            SassCustomer sassCustomer = null;
            if (StringUtils.isEmpty( sassOrdersPojo.getCustomerId() )) {
                sassCustomer = sassCustomerRepository.findByEmail(sassOrdersPojo.getCompanyEmail());
                if(sassCustomer==null){
                    sassCustomer = new SassCustomer();
                }
            } else {
                sassCustomer = sassCustomerRepository.findByCustomerId( Long.parseLong( sassOrdersPojo.getCustomerId() ) );
            }

            sassCustomer.setCustomerName( sassOrdersPojo.getCompanyName() );
            sassCustomer.setCompanyNumber(sassOrdersPojo.getCompanyPhone());
            sassCustomer.setEmail( sassOrdersPojo.getCompanyEmail() );
            sassCustomer.setOrderId( sassOrders );
            sassCustomer = sassCustomerRepository.save( sassCustomer );
            SassCompany sassCompany = new SassCompany();
            if (sassCustomer != null) {
                sassCompany.setSassCustomerId( sassCustomer );
            }
            sassCompany.setCustomerName( sassOrdersPojo.getCustomerName() );
            sassCompany.setCompanyName( sassOrdersPojo.getCompanyName() );
            sassCompany.setCompanyAddress( sassOrdersPojo.getCompanyAddress() );
            sassCompany.setDeliveryType( sassOrdersPojo.getDeliveryType() );
            sassCompany.setCompanyEmail( sassOrdersPojo.getCompanyEmail() );
            sassCompany.setNewsletter( sassOrdersPojo.getNewsletter() );
            sassCompany.setCompanyPhone( sassOrdersPojo.getCompanyPhone() );
            sassCompany.setUsername( sassOrdersPojo.getUsername() );
            sassCompany.setPassword( sassOrdersPojo.getPassword() );
            sassCompany.setPackagesSASSId( sassOrdersPojo.getPackagesSASSId() );
            sassCompany.setCompanyNo( sassOrdersPojo.getCompanyNo() );
            sassCompany.setFaxno( sassOrdersPojo.getFaxno() );
            sassCompany.setLanguage( sassOrdersPojo.getLanguage() );
            sassCompany.setGstRegistered( sassOrdersPojo.getGstRegistered() );
            sassCompany.setGstRegisteredDate( sassOrdersPojo.getGstRegisteredDate() );
            sassCompany.setIncorpDate( sassOrdersPojo.getIncorpDate() );
            sassCompany.setPan( sassOrdersPojo.getPan() );
            sassCompany.setWebsite( sassOrdersPojo.getWebsite() );
            sassCompany.setCountryId( country );
            sassCompany.setStateId( state );
            sassCompany.setCurrencyId( currency );
            sassCompany.setSassSubscriptionsId( orders );
            sassCompany.setSassOrdersId( sassOrders );
            sassCompany = sassCompanyRepository.save( sassCompany );
            sassOrders.setSassCustomer( sassCustomer.getCustomerId() );
            sassOrders = sassOrdersRepository.save( sassOrders );
            sassOrders.setCreatedDate(new Date());
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            int validity =Integer.parseInt(sassOrders.getSassSubscriptionsId().getValidity());
            c.add(Calendar.DAY_OF_MONTH,+validity);
            Date newDate =c.getTime();
            sassOrders.setExpiryDate(newDate);
            Renew renew = new Renew();
            renew.setExpiryDate(sassOrders.getExpiryDate());
            renew.setCreatedDate(sassOrders.getCreatedDate());
            renew.setSubscriptionName(sassOrders.getSassSubscriptionsId().getSubscriptionName());
            renew.setValidity(sassOrders.getSassSubscriptionsId().getValidity());
            sassOrders.setRenew(renew);
            renewRepository.save(renew);
            url = properties.getProperty( "server.port" );
            EmailServer emailServer = emailServerRepository.findByUserName( sassOrders.getSassSubscriptionsId().getEmailServer());
            if (emailServer != null) {
                String toemail = sassOrders.getCompanyEmail();
                String subject = sassOrders.getSassSubscriptionsId().getEmailcontent1subject();
                if(sassOrders.getSassSubscriptionsId().getUrl()!=null) {
                    String body = sassOrders.getSassSubscriptionsId().getEmailcontent1body() +"\n" +
                            sassOrders.getSassSubscriptionsId().getUrl() +"/emailDirectLink?"+ sassOrders.getOrderValue() + "&" + sassOrders.getSassOrdersId() + "\n" +
                            "--------------------------------------------------" + "\n";
                    String filename = null;
                    MailService.sendMailWithAttachment(emailServer, toemail, subject, body.toString(), "", null, filename);
                }
                else{
                    String body = sassOrders.getSassSubscriptionsId().getEmailcontent1body();
                    String filename = null;
                    MailService.sendMailWithAttachment(emailServer, toemail, subject, body.toString(), "", null, filename);
                }
            }

//        }
            return sassOrders;
        } else {
            SassOrders sassOrders = new SassOrders();
            sassOrders.setStatus( "Limit Exceeded" );
        return  sassOrders;
        }
    }
    public SassCompanyPojo companyDetails(Long id) {
        SassOrders sassOrders=sassOrdersRepository.findOne(id);
        SassCompany sassCompany = sassCompanyRepository.findBySassOrdersId(sassOrders);
        List<SassCompany> sassCompanies = new ArrayList<>();
        sassCompanies.add(sassCompany);
        SassCompanyPojo sassCompanyPojo = SassOrdersMapper.mapCompanyDetailsEntityToPojo(sassCompanies).get(0);
        List<SassUser> sassUser=sassUserRepository.findByCompanyName(sassCompany.getHiConnectCompnyRegNo());
        int noofusers=sassUser.size()+1;
        sassCompanyPojo.setNoOfUsers(noofusers);
        int remainingusers=Integer.parseInt(sassCompany.getSassSubscriptionsId().getUsers())-1;
        sassCompanyPojo.setRemainingusers(remainingusers);
        return sassCompanyPojo;
    }
    public SassSubscriptionsPojo subscriptionDetails(Long id) {
        SassOrders sassOrders=sassOrdersRepository.findOne(id);
        SassSubscriptions sassSubscriptions=sassSubscriptionRepository.findBySubscriptionId(sassOrders.getSassSubscriptionsId().getSubscriptionId());
        List<SassSubscriptions> sassSubscriptionsList = new ArrayList<>();
        sassSubscriptionsList.add(sassSubscriptions);
        SassSubscriptionsPojo sassSubscriptionsPojo = SassOrdersMapper.mapSubcriptionDetailsEntityToPojo(sassSubscriptionsList).get(0);
        sassSubscriptionsPojo.setIncorpDate(sassOrders.getIncorpDate());
        sassSubscriptionsPojo.setCreatedDate(sassOrders.getCreatedDate());
        sassSubscriptionsPojo.setExpiryDate(sassOrders.getExpiryDate());
        if(sassOrders.getExpiryDate().before(new Date())){
            sassSubscriptionsPojo.setValidityStatus("Expired");
        }else {
            sassSubscriptionsPojo.setValidityStatus("Active");
        }
        List<Renew> renewList = renewRepository.findAll();
        for(Renew renew:renewList){
            SassSubscriptionsPojo sassSubscriptionsPojo1= new SassSubscriptionsPojo();
            sassSubscriptionsPojo1.setValidityStatus(renew.getStatus());
        }
        return sassSubscriptionsPojo;
    }

    public List<SassPaymentMethodPojo> paymentDetails(Long id) throws Exception {
        SassOrders sassOrders = sassOrdersRepository.findOne(id);
        List<PosPaymentTypes> posPaymentTypes = posPaymentTypesRepository.findBySassOrders(sassOrders);
        List<SassPaymentMethodPojo> sassPaymentMethodPojos = SassOrdersMapper.mapPaymentDetailsEntityToPojo(posPaymentTypes, sassOrders);
        return sassPaymentMethodPojos;
    }

    public List<SassCustomer>  getCompanyNamesListFromCustomers(String CompanyName){
        List<SassCustomer> order =sassCustomerRepository.findByCustomerNameIsStartingWith(CompanyName);
        return order;
    }

    public List<SassOrders>  searchCompanyNames(String CompanyName){
        List<SassOrders> order =sassOrdersRepository.findByCompanyNameIsStartingWith(CompanyName);
        return order;
    }
    public List<SassOrders>  getOrderListByEmail(String email){
        List<SassOrders> order =sassOrdersRepository.findByCompanyEmail(email);
        return order;
    }
    public List<SassOrdersPojo> OrderList() {
        List<SassOrders> sassOrders = (List<SassOrders>) sassOrdersRepository.findAll();
        List<SassOrdersPojo> sassOrdersPojos = SassOrdersMapper.mapEntityToPojo(sassOrders);
        return sassOrdersPojos;
    }
   public List<PosPaymentTypes> getPaymentsList(){
    Iterable<PosPaymentTypes> posPaymentTypes=posPaymentTypesRepository.findAll();
    List<PosPaymentTypes> posPaymentTypes1 = new ArrayList<>();
    posPaymentTypes.forEach(PosPaymentTypes -> {
        posPaymentTypes1.add(PosPaymentTypes);

    });
    return posPaymentTypes1;

    }

    public List<SassCompany> getSaasCustomerRegNo(String fromRegno){
        List<SassCompany> sassCompanyList =sassCompanyRepository.findByHiConnectCompnyRegNo(fromRegno);
        return sassCompanyList;
    }
    public List<SassCompany> getSaasCustomerReg(String fromRegno){
        List<SassCompany> sassCompanyList =sassCompanyRepository.findByHiConnectCompnyRegNo(fromRegno);
        return sassCompanyList;
    }
    public List<SassCompany> getfindByCompanyNameIsLike(String customerName){
        List<SassCompany> sassCompanyList =sassCompanyRepository.findByCompanyNameStartingWith(customerName);
        return sassCompanyList;
    }


    public SassCompany getSaasCustomerRegNoObj(String fromRegno){
        SassCompany sassCompanyObj =sassCompanyRepository.getByHiConnectCompnyRegNo(fromRegno);
        return sassCompanyObj;
    }

    public List<TransactionsData> getTransactionList(){
        List<TransactionsData> transactionsDataList =sassTransactionRepository.findAllByStatus("pending");
        return transactionsDataList;
    }

    public TransactionsData getTransactionObject(Long transactionId){
        TransactionsData transactionsData =sassTransactionRepository.findAllByTransactionId(transactionId);
        return transactionsData;
    }

    public String UpdatePermissionGpandPm(){

//        List<PermissionGroup> masterPermissionGroupList = multiCompanyDao.listMasterPermissionGroup();
//        if (masterPermissionGroupList.isEmpty()) {
//            HSSFSheet sheet = readingXlsFile.getXlsSheet("accounts/Permission_Group.xls");
//            HSSFRow hssfRow;
//            Iterator iterable = sheet.rowIterator();
//            while (iterable.hasNext()) {
//                PermissionGroup groupObj = new PermissionGroup();
//                hssfRow = (HSSFRow) iterable.next();
//                String description = hssfRow.getCell(0).toString();
//                String featureName = hssfRow.getCell(1).toString();
//                String pgKey = hssfRow.getCell(2).toString();
//                String saasStatus = hssfRow.getCell(3).toString();
//                PermissionGroup permissionGroup = new PermissionGroup();
//                permissionGroup.setDescription(description);
//                permissionGroup.setFeatureName(featureName);
//                permissionGroup.setPgkey(pgKey);
//                permissionGroup.setSaasStatus(saasStatus);
//                multiCompanyDao.save(permissionGroup);
//            }
//        }42
//        List<PermissionMaster> permissionMasterList = multiCompanyDao.listMasterPermissionMaster();
//        if(permissionMasterList.isEmpty()) {
//            HSSFSheet sheet = readingXlsFile.getXlsSheet("accounts/Invetorylevel3.xls");
//            HSSFRow hssfRow;
//            Iterator iterable = sheet.rowIterator();
//            while (iterable.hasNext()) {
//                addNewItemDTO itemDTO = null;
//                hssfRow = (HSSFRow) iterable.next();
//                Cell accountgroup = hssfRow.getCell(0);
//                Cell level1 = hssfRow.getCell(1);
//                Cell level2 = hssfRow.getCell(2);
//                Cell description = hssfRow.getCell(3);
//                Cell status = hssfRow.getCell(4);
//                Cell permissionkey = hssfRow.getCell(5);
//                PermissionMasterDTO permissionMasterDTO = new PermissionMasterDTO();
//                if (accountgroup != null) {
//                    com.hyva.master.entities.PermissionGroup permissionGroup = hiposService.getpermissionMasterGroupMaster(accountgroup.toString());
//                    if (permissionGroup != null) {
//                        permissionMasterDTO.setPgId(permissionGroup.getPgId());
//                    }
//                    com.hyva.master.entities.PermissionMaster permissionMaster = null;
//                    if (level1 != null) {
//                        permissionMaster = hiposService.getpermissionMasterMaster(level1.toString());
//                        if (permissionMaster != null) {
//                            permissionMasterDTO.setPmId(Long.parseLong(permissionMaster.getPmId().toString()));
//                        } else {
//                            permissionMasterDTO.setPmId(null);
//                        }
//                    } else {
//                        permissionMasterDTO.setPmId(null);
//                    }
//                    if (level2 != null) {
//                        permissionMaster = hiposService.getpermissionMasterMaster(level2.toString());
//                        if (permissionMaster != null) {
//                            permissionMasterDTO.setPmId(Long.parseLong(permissionMaster.getPmId().toString()));
//                        } else {
//                            permissionMasterDTO.setPmId(null);
//                        }
//                    } else {
//                        permissionMasterDTO.setPmId(null);
//                    }
//                    permissionMasterDTO.setDescription(description.toString());
//                    permissionMasterDTO.setSaasStatus(status.toString());
//                    permissionMasterDTO.setPermissionMasterkey(permissionkey.toString());
//                    hiposService.NewpermissionMaster(permissionMasterDTO);
//
//                }}}
        return null;

    }

    public String getLicenceKey(SassOrdersPojo sassOrdersPojo) {
        String requestUrl = "http://cloud.hiaccounts.com:8890/licenser/getlicense";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> uriParams= new LinkedMultiValueMap<String, String>();
        uriParams.add("companyName", sassOrdersPojo.getCompanyName());
        uriParams.add("emailId", sassOrdersPojo.getCompanyEmail());
        uriParams.add("customerName", "Azgar Idm Test");
        uriParams.add("EditionName", "professional");
        uriParams.add("validity", "50");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(uriParams, headers);
        System.out.println("SSS"+uriParams);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(requestUrl, request, String.class);
//      JSONObject jsonObj = new JSONObject();
//      String balance = jsonObj.get("data").toString();
        return response;
    }





    public String  getLicenceKeyManual(SassOrdersPojo sassOrdersPojo) {
        String requestUrl = "http://cloud.hiaccounts.com:8890/licenser/getlicense";
      //  License license= LicenceController.getManualActivationRequestString();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> uriParams= new LinkedMultiValueMap<String, String>();
        uriParams.add("companyName", sassOrdersPojo.getCompanyName());
        uriParams.add("emailId", sassOrdersPojo.getCompanyEmail());
        uriParams.add("customerName", "Azgar Idm Test");
        uriParams.add("EditionName", "professional");
        uriParams.add("validity", "50");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(uriParams, headers);
        System.out.println("SSS"+uriParams);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(requestUrl, request, String.class);
//      JSONObject jsonObj = new JSONObject();
//      String balance = jsonObj.get("data").toString();
        return response;
    }

   public SassOrders validateParent_Token(String parent_Token,String email){
       SassCustomer sassCustomer=sassCustomerRepository.findByEmailAndLoginUniqueId(parent_Token,email);
    if(sassCustomer!=null){
        String token=randomAlphaNumeric();
    }
       SassOrders sassOrders=new SassOrders();
        return sassOrders;
   }

    public void getSaveNewItemData(IcItem icItem) {
        icItemRepository.save(icItem);
    }
    public void getSaveSalesInvoiceData(IcItem icItem) {
        icItemRepository.save(icItem);
    }



    public BasePojo getPaginatedOrderList(BasePojo basePojo, String searchText) {
        List<SassOrders> list = new ArrayList<>();
        basePojo.setPageSize(paginatedConstants);
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "sassOrdersId"));
        if (basePojo.isLastPage() == true) {
            List<SassOrders> list1 = new ArrayList<>();
            if (!StringUtils.isEmpty(searchText)) {
                list1 = sassOrdersRepository.findAllByCompanyNameContainingOrCompanyEmailContainingOrCustomerNameContainingOrCompanyPhoneContainingOrPostingStatusContaining(searchText,searchText,searchText,searchText,searchText);
            } else {
                list1 = sassOrdersRepository.findAll();
            }
            int size = list1.size() % paginatedConstants;
            int pageNo = list1.size() / paginatedConstants;
            if (size != 0) {
                basePojo.setPageNo(pageNo);
            } else {
                basePojo.setPageNo(pageNo - 1);
            }
        }
        SassOrders medicine = new SassOrders();
        Pageable pageable = new PageRequest(basePojo.getPageNo(), basePojo.getPageSize(), sort);
        if (basePojo.isNextPage() == true || basePojo.isFirstPage() == true) {
            sort = new Sort(new Sort.Order(Sort.Direction.ASC, "sassOrdersId"));
        }
        if (!StringUtils.isEmpty(searchText)) {
            medicine = sassOrdersRepository.findFirstByCompanyNameContainingOrCompanyEmailContainingOrCustomerNameContainingOrCompanyPhoneContainingOrPostingStatusContaining(searchText,searchText,searchText,searchText,searchText,sort);
            list = sassOrdersRepository.findByCompanyNameContainingOrCompanyEmailContainingOrCustomerNameContainingOrCompanyPhoneContainingOrPostingStatusContaining(searchText,searchText,searchText,searchText,searchText,pageable);
        } else {
            medicine = sassOrdersRepository.findFirstBy(sort);
            list = sassOrdersRepository.findAllBy(pageable);
        }
        if (list.contains(medicine)) {
            basePojo.setStatus(true);
        } else {
            basePojo.setStatus(false);
        }
        List<SassOrdersPojo> pojo = SassOrdersMapper.mapEntityToPojo(list);
        basePojo = calculatePagination(basePojo, pojo.size());
        basePojo.setList(pojo);
        return basePojo;
    }



    public BasePojo calculatePagination(BasePojo basePojo, int size) {
        if (basePojo.isLastPage() == true) {
            basePojo.setFirstPage(false);
            basePojo.setNextPage(true);
            basePojo.setPrevPage(false);
        } else if (basePojo.isFirstPage() == true) {
            basePojo.setLastPage(false);
            basePojo.setNextPage(false);
            basePojo.setPrevPage(true);
            if (basePojo.isStatus() == true) {
                basePojo.setLastPage(true);
                basePojo.setNextPage(true);
            }
        } else if (basePojo.isNextPage() == true) {
            basePojo.setLastPage(false);
            basePojo.setFirstPage(false);
            basePojo.setPrevPage(false);
            basePojo.setNextPage(false);
            if (basePojo.isStatus() == true) {
                basePojo.setLastPage(true);
                basePojo.setNextPage(true);
            }
        } else if (basePojo.isPrevPage() == true) {
            basePojo.setLastPage(false);
            basePojo.setFirstPage(false);
            basePojo.setNextPage(false);
            basePojo.setPrevPage(false);
            if (basePojo.isStatus() == true) {
                basePojo.setPrevPage(true);
                basePojo.setFirstPage(true);
            }
        }
        if (size == 0) {
            basePojo.setLastPage(true);
            basePojo.setFirstPage(true);
            basePojo.setNextPage(true);
            basePojo.setPrevPage(true);
        }
        return basePojo;
    }
}