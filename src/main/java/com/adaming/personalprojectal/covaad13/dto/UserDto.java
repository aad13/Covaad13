package com.adaming.personalprojectal.covaad13.dto;

import java.util.List;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String vehicle;
    private int nbPlaces;
    private List<TripDto> tripsAsOwner;
    private List<TripDto> tripsAsPassenger;

    public UserDto(Long id, String firstName, String lastName, String email, String phoneNumber, String vehicle, int nbPlaces, List<TripDto> tripsAsOwner, List<TripDto> tripsAsPassenger) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.vehicle = vehicle;
        this.nbPlaces = nbPlaces;
        this.tripsAsOwner = tripsAsOwner;
        this.tripsAsPassenger = tripsAsPassenger;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public List<TripDto> getTripsAsOwner() {
        return tripsAsOwner;
    }

    public void setTripsAsOwner(List<TripDto> tripsAsOwner) {
        this.tripsAsOwner = tripsAsOwner;
    }

    public List<TripDto> getTripsAsPassenger() {
        return tripsAsPassenger;
    }

    public void setTripsAsPassenger(List<TripDto> tripsAsPassenger) {
        this.tripsAsPassenger = tripsAsPassenger;
    }
}
