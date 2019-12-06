package com.adaming.personalprojectal.covaad13.exception;

public class TooEarlyTripException extends Exception {

    public TooEarlyTripException(){
        System.out.println("!!!La date que vous avez indiquée pour votre trajet est déjà passée!!!");
    }
}
