package com.adaming.personalprojectal.covaad13.service;

import com.adaming.personalprojectal.covaad13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;
}
