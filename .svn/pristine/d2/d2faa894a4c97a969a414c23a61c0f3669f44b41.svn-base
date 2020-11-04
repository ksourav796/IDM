package com.hyva.idm.security;

import com.hyva.idm.entity.UserEntity;
import com.hyva.idm.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by tnataraj on 1/15/18.
 */
@Component
public class UserNamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

      UserEntity userEntity= userRepository.findByUserName(name);

        if(userEntity!=null){
            if(bCryptPasswordEncoder.matches(password,userEntity.getPassword())){

                return new UsernamePasswordAuthenticationToken(
                        name, password, new ArrayList<>());

            }


        }else{
        throw new
                BadCredentialsException("External system authentication failed");
    }

    return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
