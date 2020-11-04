package com.hyva.idm.service;

import com.hyva.idm.entity.CompanyEntity;
import com.hyva.idm.entity.UserEntity;
import com.hyva.idm.exceptions.BadRequestException;
import com.hyva.idm.exceptions.UnAuthorizedException;
import com.hyva.idm.mapper.UserMapper;
import com.hyva.idm.messages.SuccessMessages;
import com.hyva.idm.pojo.IDMResponse;
import com.hyva.idm.pojo.UserPojo;
import com.hyva.idm.respositories.CompanyRepository;
import com.hyva.idm.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tnataraj on 1/6/18.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ScryptPasswordManager scryptPasswordManager;

    @Transactional
    public IDMResponse createUser(UserPojo userPojo) {
        validateCompany(userPojo.getCompanyName());
        userRepository.save(userMapper.pojoToEntity.apply(userPojo));
        IDMResponse idmResponse = new IDMResponse(HttpStatus.OK.value(), SuccessMessages.USER_CREATED);
        return idmResponse;
    }


    @Transactional
    public IDMResponse changepassword(String userName, String oldPassword,
                                      String newPassword) {
        UserEntity userEntity = validateUser(userName);
        if (!scryptPasswordManager.matches(oldPassword, userEntity.getPassword())) {
            throw new UnAuthorizedException("Verificcation failed", HttpStatus.UNAUTHORIZED.value());

        }
        userEntity.setPassword(scryptPasswordManager.encrypt(newPassword));
        IDMResponse idmResponse = new IDMResponse(HttpStatus.OK.value(), SuccessMessages.PASSWORD_CHANGED);
        return idmResponse;
    }


    @Transactional
    public IDMResponse deleteUser(String userName) {
        UserEntity userEntity = validateUser(userName);
        userEntity.setActive(Boolean.FALSE);
        IDMResponse idmResponse = new IDMResponse(HttpStatus.OK.value(), SuccessMessages.USER_DELETED);
        return idmResponse;
    }


    void validateCompany(String companyName) {
        CompanyEntity companyEntity = companyRepository.findByCompanyName(companyName);
        if (companyEntity == null) {

            throw new BadRequestException("company not found", HttpStatus.BAD_REQUEST.value());
        }

    }


    UserEntity validateUser(String userName) {
        UserEntity userEntity = userRepository.findByUserName(userName);
        if (userEntity == null) {

            throw new BadRequestException("user not found", HttpStatus.BAD_REQUEST.value());
        }

        return userEntity;

    }

    public List findAll() {
        List list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public UserDetails loadUserByUsername(String uName) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(uName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority());
    }
    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }


}
