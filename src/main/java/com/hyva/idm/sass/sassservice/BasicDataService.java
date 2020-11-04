package com.hyva.idm.sass.sassservice;

import com.hyva.idm.sass.sassentities.SaasState;
import com.hyva.idm.sass.sassentities.SassCountry;
import com.hyva.idm.sass.sassentities.SassCurrency;
import com.hyva.idm.sass.sassentities.SassUser;
import com.hyva.idm.sass.sasspojo.SaasStatePojo;
import com.hyva.idm.sass.sasspojo.SassCountryPojo;
import com.hyva.idm.sass.sasspojo.SassCurrencyPojo;
import com.hyva.idm.sass.sassrespositories.SaasStateRepository;
import com.hyva.idm.sass.sassrespositories.SassCountryRepository;
import com.hyva.idm.sass.sassrespositories.SassCurrencyRepository;
import com.hyva.idm.sass.sassrespositories.SassUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BasicDataService {
    @Autowired
    SassControlPanelService sassControlPanelService;
    @Autowired
    SassCountryRepository sassCountryRepository;
    @Autowired
    SassCurrencyRepository sassCurrencyRepository;
    @Autowired
    SaasStateRepository saasStateRepository;
    @Autowired
    SassUserRepository sassUserRepository;


    public void insertBasicData() throws Exception {
        //============================================= User ======================================================================
        List<SassUser> userList = (List<SassUser>) sassUserRepository.findAll();
        if (userList.isEmpty()) {
            SassUser userObj = new SassUser();
            userObj.setEmail("admin@idm.com");
            userObj.setFull_name("admin");
            userObj.setPasswordUser("admin");
            userObj.setUserName("admin");
            userObj.setPhone("");
            userObj.setSecurityAnswer("");
            userObj.setSecurityQuestion("");
            userObj.setStatus("Active");
            userObj.setUserToken("");
            sassUserRepository.save(userObj);

        }

        //============================================= Country ======================================================================
        List<SassCountryPojo> countryList = sassControlPanelService.getCountryList();
        if (countryList.isEmpty()) {
            sassCountryRepository.save(new SassCountry("India", "true", "Active"));
            sassCountryRepository.save(new SassCountry("Malaysia", "true", "Active"));
            sassCountryRepository.save(new SassCountry("Brunei", "true", "Active"));
            sassCountryRepository.save(new SassCountry("Indonesia", "true", "Active"));
            sassCountryRepository.save(new SassCountry("Singapore", "true", "Active"));
            sassCountryRepository.save(new SassCountry("Thailand", "true", "Active"));
            sassCountryRepository.save(new SassCountry("USA", "true", "Active"));
            sassCountryRepository.save(new SassCountry("Europe", "true", "Active"));

        }
     List<SassCurrencyPojo> currencyList = sassControlPanelService.CurrencyList();
        if (currencyList.isEmpty()) {
            sassCurrencyRepository.save(new SassCurrency("INR", "Rupee", "India Rupee", "Rs", "Before Number" ));
            sassCurrencyRepository.save(new SassCurrency("MYR", "Ringgit", "Malaysian ringgit", "RM", "Before Number"));
            sassCurrencyRepository.save(new SassCurrency("BND", "Brunei Dollar", "Brunei Dollar", "B$", "Before Number"));
            sassCurrencyRepository.save(new SassCurrency("IDR", "Ruphiah", "Indonesia Ruphiah", "Rp", "Before Number"));
            sassCurrencyRepository.save(new SassCurrency("SGD", "Singapore Dollar", "Singapore Dollar", "S$", "Before Number"));
            sassCurrencyRepository.save(new SassCurrency("THB", "Thai Baht", "Thai Baht", "B", "Before Number"));
            sassCurrencyRepository.save(new SassCurrency("USD", "US Dollar", "US Dollar", "$", "Before Number"));
            sassCurrencyRepository.save(new SassCurrency("EUR", "Euro", "Euro", "€", "Before Number"));
            sassCurrencyRepository.save(new SassCurrency("GBP", "Pound", "Pound Sterling", "£", "Before Number"));
        }
         SassCountry countryobjIndia = sassCountryRepository.findByCountryName("India");
        SassCountry countryobjMalaysia = sassCountryRepository.findByCountryName("Malaysia");
        List<SaasStatePojo> stateList = sassControlPanelService.stateList();

        if (stateList.isEmpty()) {

            saasStateRepository.save(new SaasState("AN", "35", "Active", "Andaman and Nicobar Islands ", countryobjIndia));
            saasStateRepository.save(new SaasState("AP", "28", "Active", "Andhra Pradesh", countryobjIndia));
            saasStateRepository.save(new SaasState("AR", "12", "Active", "Arunachal Pradesh ", countryobjIndia));
            saasStateRepository.save(new SaasState("AS", "18", "Active", "Assam ", countryobjIndia));
            saasStateRepository.save(new SaasState("BH", "10", "Active", "Bihar", countryobjIndia));
            saasStateRepository.save(new SaasState("CH", "04", "Active", "Chandigarh", countryobjIndia));
            saasStateRepository.save(new SaasState("CT", "22", "Active", "Chattisgarh", countryobjIndia));
            saasStateRepository.save(new SaasState("DN", "26", "Active", "Dadra and Nagar Haveli ", countryobjIndia));
            saasStateRepository.save(new SaasState("DD", "25", "Active", "Daman and Diu ", countryobjIndia));
            saasStateRepository.save(new SaasState("DL", "07", "Active", "Delhi", countryobjIndia));
            saasStateRepository.save(new SaasState("GA", "30", "Active", "Goa", countryobjIndia));
            saasStateRepository.save(new SaasState("GJ", "24", "Active", "Gujarat", countryobjIndia));
            saasStateRepository.save(new SaasState("HR", "06", "Active", "Haryana", countryobjIndia));
            saasStateRepository.save(new SaasState("HP", "02", "Active", "Himachal Pradesh", countryobjIndia));
            saasStateRepository.save(new SaasState("JK", "01", "Active", "Jammu and Kashmir", countryobjIndia));
            saasStateRepository.save(new SaasState("JH", "20", "Active", "Jharkhand", countryobjIndia));
            saasStateRepository.save(new SaasState("KA", "29", "Active", "Karnataka", countryobjIndia));
            saasStateRepository.save(new SaasState("KL", "32", "Active", "Kerala", countryobjIndia));
            saasStateRepository.save(new SaasState("LD", "31", "Active", "Lakshadweep Islands", countryobjIndia));
            saasStateRepository.save(new SaasState("MP", "23", "Active", "Madhya Pradesh ", countryobjIndia));
            saasStateRepository.save(new SaasState("MP", "27", "Active", "Maharastra ", countryobjIndia));
            saasStateRepository.save(new SaasState("MN", "14", "Active", "Manipur", countryobjIndia));
            saasStateRepository.save(new SaasState("ME", "17", "Active", "Meghalaya", countryobjIndia));
            saasStateRepository.save(new SaasState("MI", "15", "Active", "Mizoram", countryobjIndia));
            saasStateRepository.save(new SaasState("NL", "13", "Active", "Nagaland", countryobjIndia));
            saasStateRepository.save(new SaasState("OR", "21", "Active", "Odisha", countryobjIndia));
            saasStateRepository.save(new SaasState("PY", "34", "Active", "Pondicherry", countryobjIndia));
            saasStateRepository.save(new SaasState("PB", "03", "Active", "Punjab", countryobjIndia));
            saasStateRepository.save(new SaasState("RJ", "08", "Active", "Rajasthan", countryobjIndia));
            saasStateRepository.save(new SaasState("SK", "11", "Active", "Sikkim", countryobjIndia));
            saasStateRepository.save(new SaasState("TN", "33", "Active", "Tamil Nadu ", countryobjIndia));
            saasStateRepository.save(new SaasState("TS", "36", "Active", "Telangana", countryobjIndia));
            saasStateRepository.save(new SaasState("TR", "16", "Active", "Tripura", countryobjIndia));
            saasStateRepository.save(new SaasState("UP", "09", "Active", "Uttar Pradesh", countryobjIndia));
            saasStateRepository.save(new SaasState("UT", "05", "Active", "Uttarakhand", countryobjIndia));
            saasStateRepository.save(new SaasState("WB", "19", "Active", "West Bengal", countryobjIndia));
             // Malaysia states
            saasStateRepository.save(new SaasState("SLmyr", "35", "Active", "Selangor ", countryobjMalaysia));
            saasStateRepository.save(new SaasState("KLmyr", "28", "Active", "Kuala Lumpur", countryobjMalaysia));
            saasStateRepository.save(new SaasState("SKmyr", "37", "Active", "Sarawak", countryobjMalaysia));
            saasStateRepository.save(new SaasState("JRmyr", "12", "Active", "Johor ", countryobjMalaysia));
            saasStateRepository.save(new SaasState("PPmyr", "35", "Active", "Pulau Pinang ", countryobjMalaysia));
            saasStateRepository.save(new SaasState("SHmyr", "28", "Active", "Sabah", countryobjMalaysia));
            saasStateRepository.save(new SaasState("PKmyr", "37", "Active", "Perak", countryobjMalaysia));
            saasStateRepository.save(new SaasState("PGmyr", "12", "Active", "Pahang ", countryobjMalaysia));
            saasStateRepository.save(new SaasState("NSmyr", "35", "Active", "Negeri Sembilan", countryobjMalaysia));
            saasStateRepository.save(new SaasState("KHmyr", "28", "Active", "Kedah", countryobjMalaysia));
            saasStateRepository.save(new SaasState("MAmyr", "37", "Active", "Melaka", countryobjMalaysia));
            saasStateRepository.save(new SaasState("TUmyr", "12", "Active", "Terengganu ", countryobjMalaysia));
            saasStateRepository.save(new SaasState("KNmyr", "12", "Active", "Kelantan ", countryobjMalaysia));
            saasStateRepository.save(new SaasState("LNmyr", "12", "Active", "Labuan ", countryobjMalaysia));
            saasStateRepository.save(new SaasState("Psmyr", "12", "Active", "Perlis ", countryobjMalaysia));
            saasStateRepository.save(new SaasState("MYmyr", "12", "Active", "Malaysia ", countryobjMalaysia));
            saasStateRepository.save(new SaasState("Other", "00", "Active", "Other State ", null));


        }
    }
}


















