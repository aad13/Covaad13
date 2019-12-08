package com.adaming.personalprojectal.covaad13.service;

import com.adaming.personalprojectal.covaad13.entity.User;
import com.adaming.personalprojectal.covaad13.exception.NullUserException;
import com.adaming.personalprojectal.covaad13.exception.UserAlreadyExistException;
import com.adaming.personalprojectal.covaad13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void register(User u) throws NullUserException, UserAlreadyExistException {
        if (u==null){
            throw new NullUserException();
        }else{
            if(this.userRepository.getUserByEmailPOrPhoneNumber(u.getEmail(),u.getPhoneNumber())==null){
                this.userRepository.save(u);
            }else{
                throw new UserAlreadyExistException();
            }
        }
    }

    public User fetchById(Long id){
        return this.userRepository.findById(id).orElse(null);
    }

    public Iterable<User> fetchAll(){
        return this.userRepository.findAll();
    }
}
