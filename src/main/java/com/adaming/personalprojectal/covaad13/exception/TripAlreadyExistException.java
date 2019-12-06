package com.adaming.personalprojectal.covaad13.exception;

public class TripAlreadyExistException extends Exception {

    public TripAlreadyExistException(){
        System.out.println("!!!Le trajet que vous voulez proposer existe déjà.!!!");
    }
}
