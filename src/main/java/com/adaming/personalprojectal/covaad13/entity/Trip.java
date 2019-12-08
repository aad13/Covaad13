package com.adaming.personalprojectal.covaad13.entity;

import com.adaming.personalprojectal.covaad13.dto.TripDto;
import com.adaming.personalprojectal.covaad13.dto.UserDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private boolean finished;
    @ManyToOne
    private User owner;
    @ManyToMany
    @JoinTable(name = "user_trip",
            joinColumns = @JoinColumn(name="trip_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"))
    private List<User> passengers;

    public Trip() {
    }

    public Trip(float price, String departureS, String arrivalS, LocalDateTime departureT, boolean finished, User owner, List<User> passengers) {
        this.price = price;
        this.departureS = departureS;
        this.arrivalS = arrivalS;
        this.departureT = departureT;
        this.finished = finished;
        this.owner=owner;
        this.passengers=passengers;
    }

    public TripDto toDto(){
        /*List<UserDto> passengersDto=new ArrayList<>();
        for (User p:this.passengers) {
            passengersDto.add(p.toDto());
        }*/
        return new TripDto(this.id,this.price,this.departureS,this.arrivalS,this.departureT/*,this.owner.toDto(),passengersDto*/,this.finished);
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

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<User> passengers) {
        this.passengers = passengers;
    }
}
