package com.adaming.personalprojectal.covaad13.dto;

public class UserForTripDto {

    private Long id;
    private String firstName;
    private String vehicle;
    private int nbPlaces;

    public UserForTripDto(Long id, String firstName, String vehicle, int nbPlaces) {
        this.id = id;
        this.firstName = firstName;
        this.vehicle = vehicle;
        this.nbPlaces = nbPlaces;
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
}
