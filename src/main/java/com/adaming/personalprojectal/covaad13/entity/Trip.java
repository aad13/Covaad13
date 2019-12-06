package com.adaming.personalprojectal.covaad13.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float price;
    private String departureS;
    private String arrivalS;
    private LocalDateTime departureT;
    private int nbPlacesLeft;
    private boolean over;
    @ManyToMany(mappedBy = "trips")
    private List<User> passengers;

    public Trip() {
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

    public int getNbPlacesLeft() {
        return nbPlacesLeft;
    }

    public void setNbPlacesLeft(int nbPlacesLeft) {
        this.nbPlacesLeft = nbPlacesLeft;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public List<User> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<User> passengers) {
        this.passengers = passengers;
    }
}
