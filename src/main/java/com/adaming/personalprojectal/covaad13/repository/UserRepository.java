package com.adaming.personalprojectal.covaad13.repository;

import com.adaming.personalprojectal.covaad13.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    @Query("SELECT u FROM User AS u WHERE u.email=:email OR u.phoneNumber=:phoneNumber")
    User getUserByEmailPOrPhoneNumber(String email, String phoneNumber);
}
