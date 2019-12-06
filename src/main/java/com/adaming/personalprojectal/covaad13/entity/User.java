package com.adaming.personalprojectal.covaad13.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;
    private String vehicle;
    private int nbPlaces;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Trip> tripsAsOwner;
    @ManyToMany(mappedBy = "passengers", cascade = CascadeType.ALL)
    /*@ManyToMany
    @JoinTable(name = "user_trip",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="course_id", referencedColumnName = "id"))*/
    private List<Trip> tripsAsPassenger;

    public User() {
    }

    public User(String firstName, String lastName, String email, String phoneNumber, String vehicle, int nbPlaces) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public List<Trip> getTripsAsOwner() {
        return tripsAsOwner;
    }

    public void setTripsAsOwner(List<Trip> tripsAsOwner) {
        this.tripsAsOwner = tripsAsOwner;
    }

    public List<Trip> getTripsAsPassenger() {
        return tripsAsPassenger;
    }

    public void setTripsAsPassenger(List<Trip> tripsAsPassenger) {
        this.tripsAsPassenger = tripsAsPassenger;
    }
}
