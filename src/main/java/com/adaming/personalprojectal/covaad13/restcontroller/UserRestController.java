package com.adaming.personalprojectal.covaad13.restcontroller;

import com.adaming.personalprojectal.covaad13.dto.UserDto;
import com.adaming.personalprojectal.covaad13.service.TripService;
import com.adaming.personalprojectal.covaad13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covaad13/webapi")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private TripService tripService;

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getUser(@PathVariable("id") Long id){
        return userService.fetchById(id).toDto();
    }
}
