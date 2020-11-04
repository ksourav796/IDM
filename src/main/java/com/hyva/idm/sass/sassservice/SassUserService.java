package com.hyva.idm.sass.sassservice;
import com.hyva.idm.sass.sassentities.*;
import com.hyva.idm.sass.sassmapper.IdmPermissionMapper;
import com.hyva.idm.sass.sassmapper.SassUserMapper;
import com.hyva.idm.sass.sasspojo.IdmPermissionPojo;
import com.hyva.idm.sass.sasspojo.PktUserPojo;
import com.hyva.idm.sass.sasspojo.PositionTablePojo;
import com.hyva.idm.sass.sasspojo.SassOrdersPojo;
import com.hyva.idm.sass.sasspojo.SassUserPojo;
import com.hyva.idm.sass.sassrespositories.*;
import com.hyva.idm.sass.sassrespositories.IdmPermissionRepository;
import com.hyva.idm.sass.sassrespositories.SassOrdersRepository;
import com.hyva.idm.sass.sassrespositories.SassSubscriptionRepository;
import com.hyva.idm.sass.sassrespositories.SassUserRepository;
import com.hyva.idm.sass.sassrespositories.PositionTableRepository;
import com.hyva.idm.sass.sassutil.ObjectMapperUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class SassUserService {

    @Autowired
    SassUserRepository sassUserRepository;
    @Autowired
    SassOrdersRepository sassOrdersRepository;
    @Autowired
    IdmPermissionRepository idmPermissionRepository;
    @Autowired
    SassSubscriptionRepository sassSubscriptionRepository;
    @Autowired
    PositionTableRepository postionTableRepository;
    @Autowired
    PktUserRepository pktUserRepository;

    public SassUserPojo     userValidate(SassUserPojo sassUserPojo) {
        SassUserPojo sassUserPojo1 = new SassUserPojo();
        SassUser sassUser = sassUserRepository.findByEmailAndAndUserNameAndAndPasswordUser( sassUserPojo.getEmail(), sassUserPojo.getUserName(), sassUserPojo.getPasswordUser());
        if (sassUser != null) {
            sassUserPojo1.setUserName( sassUser.getUserName());
            sassUserPojo1.setFull_name(sassUser.getUserName() );
            sassUserPojo1.setPasswordUser(sassUser.getPasswordUser());
            sassUserPojo1.setEmail(sassUser.getEmail());
            sassUserPojo1.setUseraccount_id(sassUser.getUseraccountid());
            sassUserPojo1.setUserStatus( "user" );
            return sassUserPojo1;
        }else if (sassUser == null) {
            SassOrders sassOrders = sassOrdersRepository.findByCompanyEmailAndUsernameAndPasswordAndPostingStatus( sassUserPojo.getEmail(), sassUserPojo.getUserName(), sassUserPojo.getPasswordUser(),"Approved" );
            if (sassOrders != null) {
                sassUserPojo1.setUserName( sassOrders.getUsername());
                sassUserPojo1.setFull_name( sassOrders.getUsername());
                sassUserPojo1.setPasswordUser( sassOrders.getPassword());
                sassUserPojo1.setEmail( sassOrders.getCompanyEmail());
                if(sassOrders.getSassCustomer()!=null)
                sassUserPojo1.setCustomer( sassOrders.getSassCustomer().toString() );
//                sassUserPojo1.setSubscriptionFor( sassOrders.getSassSubscriptionsId().getSubscriptionFor());
                if(StringUtils.equalsIgnoreCase( sassOrders.getSassSubscriptionsId().getSubscriptionFor(),"Application")&&StringUtils.equalsIgnoreCase(sassOrders.getSassSubscriptionsId().getType(),"fordeveloper")){
                    sassUserPojo1.setUserStatus("Application");
                    sassUserPojo1.setDeveloperId(sassOrders.getDeveloperId());
                    if(sassOrders.getExpiryDate().before(new Date())){
                        sassUserPojo1.setValidityStatus("Expired");
                    }
                    if(StringUtils.equalsIgnoreCase(sassUserPojo1.getValidityStatus(),"Expired")){
                        sassUserPojo1.setUserStatus("order");
                    }
                }else {
                    sassUserPojo1.setUserStatus( "order" );
                }
                if(StringUtils.equalsIgnoreCase(sassOrders.getSassSubscriptionsId().getSubscriptionFor(),"Application")){
                    sassUserPojo1.setApplication(sassOrders.getSassSubscriptionsId().getApplication());
                }
                return sassUserPojo1;
            } else {
                return null;
            }
        }
        return sassUserPojo1;
    }

    public PktUser pktUserValidate(PktUserPojo pktUserPojo){
        PktUser pktUser = new PktUser();
        pktUser = pktUserRepository.findAllByUserNameAndPasswordAndEmail(pktUserPojo.getUserName(),pktUserPojo.getPassword(),pktUserPojo.getEmail());
        if(pktUser!=null){
            return pktUser;
        }else {
            return null;
        }
    }

    public SassUser saveUserDetails(SassUserPojo sassUserPojo) {
        SassUser sassUser = null;
        sassUser = sassUserRepository.findByEmail(sassUserPojo.getEmail());
        if (sassUser != null) {
            sassUser = null;
        } else {
            sassUser = SassUserMapper.mapPojoToEntity(sassUserPojo);
            sassUserRepository.save(sassUser);
        }
        return sassUser;
    }


    public List<SassUserPojo> sassUserList() {
        List<SassUser> sassUsers = new ArrayList<>();
        sassUsers= (List<SassUser>) sassUserRepository.findAll();
        List<SassUserPojo>list=new ArrayList<>();
        for(SassUser user:sassUsers){
            SassUserPojo pojo=new SassUserPojo();
            pojo.setUseraccount_id(user.getUseraccountid());
            pojo.setUserName(user.getUserName());
            pojo.setFull_name(user.getFull_name());
            pojo.setEmail(user.getEmail());
            pojo.setPhone(user.getPhone());
            pojo.setPasswordUser(user.getPasswordUser());
            pojo.setSecurityAnswer(user.getSecurityAnswer());
            pojo.setSecurityQuestion(user.getSecurityQuestion());
            pojo.setStatus(user.getStatus());

        list.add(pojo);}

        List<SassUserPojo> sassUserPojoList = ObjectMapperUtils.mapAll(list, SassUserPojo.class);
        return sassUserPojoList;
    }


    public SassUser saveeditUserDetails(SassUserPojo sassUserPojo) {
        SassUser sassUser = new SassUser();
        sassUser=sassUserRepository.findByUseraccountid(sassUserPojo.getUseraccount_id());

            if(sassUser.getUseraccountid()!=0){
                sassUser.setUseraccountid(sassUserPojo.getUseraccount_id());
                sassUser.setPasswordUser(sassUserPojo.getPasswordUser());
                sassUser.setUserName(sassUserPojo.getUserName());

            }
            sassUserRepository.save(sassUser);

        return sassUser;
    }

    public IdmPermission savepermission(IdmPermissionPojo idmPermissionPojo) {
        IdmPermission idmPermission = new IdmPermission();
        idmPermission = idmPermissionRepository.findByUserId( idmPermissionPojo.getUserId() );
        if (idmPermission != null) {
            idmPermissionPojo.setIdmpermissionId( idmPermission.getIdmpermissionId() );
            idmPermission = IdmPermissionMapper.mapPojoToEntity( idmPermissionPojo );

        } else {
            idmPermission = IdmPermissionMapper.mapPojoToEntity( idmPermissionPojo );
        }
        idmPermissionRepository.save( idmPermission );

        return idmPermission;
    }


    public IdmPermissionPojo editUserAccountSetUpWithPermission(Long id) {
        IdmPermission idmPermission = new IdmPermission();
        idmPermission = idmPermissionRepository.findByUserId( id );
        IdmPermissionPojo idmPermissionPojo = new IdmPermissionPojo();
        if (idmPermission != null) {
            List<IdmPermission> idmPermissions = new ArrayList<>();
            idmPermissions.add( idmPermission );
            idmPermissionPojo = IdmPermissionMapper.mapEntityToPojo( idmPermissions ).get( 0 );
        }

        return idmPermissionPojo;
    }
    
    public SassUserPojo getLoggedInByUser(String email){
        SassUser sassUser = sassUserRepository.findByEmail(email);
        SassUserPojo sassUserPojo = new SassUserPojo();
        if (sassUser != null) {
            sassUserPojo.setUserName( sassUser.getUserName() );
            sassUserPojo.setFull_name( sassUser.getUserName() );
            sassUserPojo.setEmail( sassUser.getEmail() );
             sassUserPojo.setUserStatus( "user");

            return sassUserPojo;
        }else if (sassUser == null) {
            SassOrders sassOrders = sassOrdersRepository.findAllByCompanyEmailAndPostingStatus(email,"Approved");
            if (sassOrders != null) {
                sassUserPojo.setUserName( sassOrders.getUsername() );
                sassUserPojo.setFull_name( sassOrders.getUsername() );
                sassUserPojo.setEmail( sassOrders.getCompanyEmail() );
                sassUserPojo.setPasswordUser(sassOrders.getPassword());
                if(sassOrders.getSassCustomer()!=null)
                    sassUserPojo.setCustomer( sassOrders.getSassCustomer().toString() );
                if(StringUtils.equalsIgnoreCase( sassOrders.getSassSubscriptionsId().getSubscriptionFor(),"Application")&&StringUtils.equalsIgnoreCase(sassOrders.getSassSubscriptionsId().getType(),"fordeveloper")){
                    sassUserPojo.setUserStatus("Application");
                    sassUserPojo.setDeveloperId( sassOrders.getDeveloperId());
                    if(sassOrders.getExpiryDate().before(new Date())){
                        sassUserPojo.setValidityStatus("Expired");
                    }
                    if(StringUtils.equalsIgnoreCase(sassUserPojo.getValidityStatus(),"Expired")){
                        sassUserPojo.setUserStatus("order");
                    }
                }else {
                    sassUserPojo.setUserStatus( "order" );
                }
                return sassUserPojo;
            } else {
                return null;
            }
        }
        return sassUserPojo;
    }

    public IdmPermissionPojo getAllPermission(String email){
        IdmPermissionPojo idmPermissionPojo = new IdmPermissionPojo();
        SassUser sassUser = sassUserRepository.findByEmail( email);
        if(sassUser!=null) {
            IdmPermission idmPermission = idmPermissionRepository.findByUserId( Long.valueOf( sassUser.getUseraccountid() ) );
            if (idmPermission != null) {
                List<IdmPermission> idmPermissions = new ArrayList<>();
                idmPermissions.add( idmPermission );
                idmPermissionPojo = IdmPermissionMapper.mapEntityToPojo( idmPermissions ).get( 0 );
            }
        }
        return idmPermissionPojo;
    }



    public PositionTable saveAppPos(PositionTable positionTable){
        return postionTableRepository.save(positionTable);
    }
}
