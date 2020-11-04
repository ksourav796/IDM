//package com.hyva.idm.service;
//
//import com.hyva.idm.entity.CompanyEntity;
//import com.hyva.idm.entity.UserEntity;
//import com.hyva.idm.exceptions.BadRequestException;
//import com.hyva.idm.exceptions.UnAuthorizedException;
//import com.hyva.idm.mapper.UserMapper;
//import com.hyva.idm.messages.SuccessMessages;
//import com.hyva.idm.pojo.IDMResponse;
//import com.hyva.idm.pojo.UserPojo;
//import com.hyva.idm.respositories.CompanyRepository;
//import com.hyva.idm.respositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * Created by tnataraj on 1/6/18.
// */
//@Service
//public class UserService {
//
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    CompanyRepository companyRepository;
//
//    @Autowired
//    UserMapper userMapper;
//
//    @Autowired
//    ScryptPasswordManager scryptPasswordManager;
//
//    @Transactional
//    public IDMResponse createUser(UserPojo userPojo) {
//        validateCompany(userPojo.getCompanyName());
//        userRepository.save(userMapper.pojoToEntity.apply(userPojo));
//        IDMResponse idmResponse = new IDMResponse(HttpStatus.OK.value(), SuccessMessages.USER_CREATED);
//        return idmResponse;
//    }
//
//
//    @Transactional
//    public IDMResponse changepassword(String userName, String oldPassword,
//                                      String newPassword) {
//        UserEntity userEntity= validateUser(userName);
//        if(!scryptPasswordManager.matches(oldPassword,userEntity.getPassword())){
//            throw new UnAuthorizedException("Verificcation failed", HttpStatus.UNAUTHORIZED.value());
//
//        }
//        userEntity.setPassword(scryptPasswordManager.encrypt(newPassword));
//        IDMResponse idmResponse = new IDMResponse(HttpStatus.OK.value(), SuccessMessages.PASSWORD_CHANGED);
//        return idmResponse;
//    }
//
//
//    @Transactional
//    public IDMResponse deleteUser(String userName) {
//       UserEntity userEntity= validateUser(userName);
//        userEntity.setActive(Boolean.FALSE);
//        IDMResponse idmResponse = new IDMResponse(HttpStatus.OK.value(), SuccessMessages.USER_DELETED);
//        return idmResponse;
//    }
//
//
//   void validateCompany(String companyName){
//        CompanyEntity companyEntity= companyRepository.findByCompanyName(companyName);
//        if(companyEntity==null){
//
//             throw new BadRequestException("company not found", HttpStatus.BAD_REQUEST.value());
//        }
//
//    }
//
//
//    UserEntity validateUser(String userName){
//        UserEntity userEntity= userRepository.findByUserName(userName);
//        if(userEntity==null){
//
//            throw new BadRequestException("user not found", HttpStatus.BAD_REQUEST.value());
//        }
//
//        return userEntity;
//
//    }
//}
