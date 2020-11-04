package com.hyva.idm.mapper;

import com.hyva.idm.entity.CompanyEntity;
import com.hyva.idm.entity.UserEntity;
import com.hyva.idm.pojo.UserPojo;
import com.hyva.idm.respositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Created by tnataraj on 1/15/18.
 */
@Component
public class UserMapper {
@Autowired
CompanyRepository companyRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public  Function<UserPojo, UserEntity> pojoToEntity
            = new Function<UserPojo, UserEntity>() {
        public UserEntity apply(UserPojo pojo) {
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(pojo.getEmail());
            userEntity.setActive(Boolean.TRUE);
            CompanyEntity companyEntity= companyRepository.findByCompanyName(pojo.getCompanyName());
            userEntity.setCompanyId(companyEntity);
            userEntity.setPassword(bCryptPasswordEncoder.encode(pojo.getPassword()));
            userEntity.setUserName(pojo.getUserName());
            return userEntity;
        }
    };
}
