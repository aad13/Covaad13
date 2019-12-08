package com.adaming.personalprojectal.covaad13.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TripDto {

    private Long id;
    private float price;
    private String departureS;
    private String arrivalS;
    private LocalDateTime departureT;
    private UserForTripDto owner;
    private List<UserForTripDto> passengers;

    public TripDto(Long id, float price, String departureS, String arrivalS, LocalDateTime departureT, UserForTripDto owner, List<UserForTripDto> passengers) {
        this.id = id;
        this.price = price;
        this.departureS = departureS;
        this.arrivalS = arrivalS;
        this.departureT = departureT;
        this.owner = owner;
        this.passengers = passengers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDepartureS() {
        return departureS;
    }

    public void setDepartureS(String departureS) {
        this.departureS = departureS;
    }

    public String getArrivalS() {
        return arrivalS;
    }

    public void setArrivalS(String arrivalS) {
        this.arrivalS = arrivalS;
    }

    public LocalDateTime getDepartureT() {
        return departureT;
    }

    public void setDepartureT(LocalDateTime departureT) {
        this.departureT = departureT;
    }

    public UserForTripDto getOwner() {
        return owner;
    }

    public void setOwner(UserForTripDto owner) {
        this.owner = owner;
    }

    public List<UserForTripDto> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<UserForTripDto> passengers) {
        this.passengers = passengers;
    }
}
