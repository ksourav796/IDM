package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.Application;
import com.hyva.idm.sass.sassentities.PktUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PktUserRepository extends JpaRepository<PktUser, Long> {


    PktUser findAllByUserName(String username);
    PktUser findAllByUserNameAndIdNotIn(String username,Long id);
    PktUser findAllByUserNameAndPasswordAndEmail(String username,String password,String email);
 }
