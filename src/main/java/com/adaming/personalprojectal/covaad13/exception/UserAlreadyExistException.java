package com.adaming.personalprojectal.covaad13.exception;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(){
        System.out.println("!!!L'e-mail que vous avez renseigné existe déjà.!!!");
    }
}
