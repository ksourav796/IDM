package com.hyva.idm.respositories;

import com.hyva.idm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tnataraj on 1/6/18.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


   UserEntity findByUserName(String userName);

//   List<UserEntity> findByEmailAndUserNameAndPassword(String email, String userName,String password);
}
