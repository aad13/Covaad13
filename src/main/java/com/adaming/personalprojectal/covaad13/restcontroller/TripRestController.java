package com.adaming.personalprojectal.covaad13.restcontroller;

import com.adaming.personalprojectal.covaad13.dto.TripDto;
import com.adaming.personalprojectal.covaad13.entity.Trip;
import com.adaming.personalprojectal.covaad13.service.TripService;
import com.adaming.personalprojectal.covaad13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/covaad13/webapi")
public class TripRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private TripService tripService;

    @GetMapping(value = "/trips", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TripDto> getUnfinishedTrips(){
        List<TripDto> tripsDto=new ArrayList<>();
        for (Trip t:this.tripService.fetchAll()) {
            if(t.getDepartureT().isAfter(LocalDateTime.now())){
                tripsDto.add(t.toDto());
            }
        }
        return tripsDto;
    }

    @GetMapping(value = "/trips/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TripDto getTrip(@PathVariable("id") Long id){
        return this.tripService.fetchById(id).toDto();
    }

    @GetMapping(value = "/users/{id}/trips", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TripDto> getTripsForUser(@PathVariable("id") Long id){
        List<TripDto> tripsDto=new ArrayList<>();
        for (Trip t:this.userService.fetchById(id).getTripsAsOwner()) {
            tripsDto.add(t.toDto());
        }
        for (Trip t:this.userService.fetchById(id).getTripsAsPassenger()) {
            tripsDto.add(t.toDto());
        }
        return tripsDto;
    }
}
