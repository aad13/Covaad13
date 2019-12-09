package com.adaming.personalprojectal.covaad13.restcontroller;

import com.adaming.personalprojectal.covaad13.dto.NewUserDto;
import com.adaming.personalprojectal.covaad13.dto.ProposeTripDto;
import com.adaming.personalprojectal.covaad13.dto.UserDto;
import com.adaming.personalprojectal.covaad13.entity.Trip;
import com.adaming.personalprojectal.covaad13.entity.User;
import com.adaming.personalprojectal.covaad13.exception.*;
import com.adaming.personalprojectal.covaad13.service.TripService;
import com.adaming.personalprojectal.covaad13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/covaad13/webapi")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private TripService tripService;

    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void subscribe(@RequestBody @Valid NewUserDto uDto){
        if(uDto.getVehicle()==null) {
            try {
                this.userService.register(new User(uDto.getFirstName(), uDto.getLastName(), uDto.getEmail(), uDto.getPhoneNumber()));
            } catch (NullUserException | UserAlreadyExistException e) {
                e.printStackTrace();
            }
        }else{
            try {
                this.userService.register(new User(uDto.getFirstName(), uDto.getLastName(), uDto.getEmail(), uDto.getPhoneNumber(),uDto.getVehicle(),uDto.getNbPlaces()));
            } catch (NullUserException | UserAlreadyExistException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getUser(@PathVariable("id") Long id){
        return userService.fetchById(id).toDto();
    }

    @PostMapping(value = "/users/{id}/propose",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void proposeTrip(@RequestBody @Valid ProposeTripDto tDto, @PathVariable("id") Long id){
        try {
            this.tripService.registerNew(new Trip(tDto.getPrice(),tDto.getDepartureS(),tDto.getArrivalS(),tDto.getDepartureT(),this.userService.fetchById(id)));
        } catch (NullTripException | TripAlreadyExistException | TooEarlyTripException e) {
            e.printStackTrace();
        }
    }

    @PatchMapping("/users/{uId}/book/{tId}")
    public void bookForTrip(@PathVariable("uId") Long uId, @PathVariable("tId") Long tId){
        Trip t=this.tripService.fetchById(tId);
        if(t.getPassengers().size()<t.getOwner().getNbPlaces()) {
            t.getPassengers().add(this.userService.fetchById(uId));
            this.tripService.persist(t);
        }
    }

    @PatchMapping("/users/{uId}/unbook/{tId}")
    public void unbookForTrip(@PathVariable("uId") Long uId, @PathVariable("tId") Long tId){
        Trip t=this.tripService.fetchById(tId);
        if(t.getPassengers().contains(this.userService.fetchById(uId))) {
            t.getPassengers().remove(this.userService.fetchById(uId));
            this.tripService.persist(t);
        }
    }

    @DeleteMapping(value = "/users/{uId}/cancel/{tId}")
    public void cancelTrip(@PathVariable("uId") Long uId, @PathVariable("tId") Long tId){
        User u=this.userService.fetchById(uId);
        if (u.getTripsAsOwner().contains(this.tripService.fetchById(tId))) {
            this.tripService.removeById(tId);
        }
    }
}
