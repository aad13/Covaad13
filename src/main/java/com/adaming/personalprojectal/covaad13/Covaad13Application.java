package com.adaming.personalprojectal.covaad13;

import com.adaming.personalprojectal.covaad13.entity.Trip;
import com.adaming.personalprojectal.covaad13.entity.User;
import com.adaming.personalprojectal.covaad13.exception.*;
import com.adaming.personalprojectal.covaad13.service.TripService;
import com.adaming.personalprojectal.covaad13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class Covaad13Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Covaad13Application.class, args);
	}

	@Autowired
	private UserService userService;
	@Autowired
	private TripService tripService;

	@Override
	public void run(String... args) {
		User u1 = new User("Adel","ABARE","adel.abare@gmail.com","0654328990","Peugeot",3);
		User u2 = new User("Boris","BARRINO","boris.barrino@gmail.com","0654328991","Renault",4);
		User u3 = new User("Céline","CAZONA","celine.cazona@gmail.com","0654328992","Ford",4);
		User u4 = new User("Damien","DEMURET","damien.demuret@gmail.com","0654328993");

		for (User u:new ArrayList<>(Arrays.asList(u1,u2,u3,u4))){
			try {
				this.userService.register(u);
			} catch (NullUserException | UserAlreadyExistException e) {
				e.printStackTrace();
			}
		}

		Trip t11 = new Trip(15,"Nice","Aix",LocalDateTime.of(2019,12,17,13,50),false,u1,new ArrayList<>(Arrays.asList(u2,u3,u4)));
		Trip t12 = new Trip(25,"Toulon","Lyon",LocalDateTime.of(2019,9,2,9,15),true,u1,new ArrayList<>(Arrays.asList(u2,u4)));
		Trip t13 = new Trip(27.50f,"Montpellier","Toulouse",LocalDateTime.of(2019,12,13,21,10),false,u1,new ArrayList<>(Arrays.asList(u2,u3)));
		Trip t21 = new Trip(10,"Antibes","Aix",LocalDateTime.of(2019,8,23,18,0),true,u2,new ArrayList<>(Arrays.asList(u3,u4)));
		Trip t22 = new Trip(20,"Antibes","Béziers",LocalDateTime.of(2019,12,15,10,30),false,u2,new ArrayList<>(Arrays.asList(u1,u3,u4)));
		Trip t31 = new Trip(7.50f,"Aix","Marseille",LocalDateTime.of(2019,12,10,13,30),false,u3,new ArrayList<>(Arrays.asList(u2,u4)));

		for (Trip t:new ArrayList<>(Arrays.asList(t11,t12,t13,t21,t22,t31))){
			try {
				this.tripService.register(t);
			} catch (NullTripException | TripAlreadyExistException e) {
				e.printStackTrace();
			}
		}
	}
}
