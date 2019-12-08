package com.adaming.personalprojectal.covaad13.dto;

import java.time.LocalDateTime;

public class ProposeTripDto {

    private float price;
    private String departureS;
    private String arrivalS;
    private LocalDateTime departureT;

    public ProposeTripDto() {
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
}
