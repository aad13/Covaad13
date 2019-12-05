package com.adaming.personalprojectal.covaad13.repository;

import com.adaming.personalprojectal.covaad13.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
