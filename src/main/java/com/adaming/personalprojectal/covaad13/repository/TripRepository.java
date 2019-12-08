package com.adaming.personalprojectal.covaad13.repository;

import com.adaming.personalprojectal.covaad13.entity.Trip;
import com.adaming.personalprojectal.covaad13.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TripRepository extends CrudRepository<Trip,Long> {

    @Query("SELECT t FROM Trip AS t WHERE t.owner=:owner AND t.departureS=:departureS AND t.arrivalS=:arrivalS AND t.departureT=:departureT")
    Trip getTripByOwnerAndDepartureSAAndArrivalSAndDepartureT(User owner, String departureS, String arrivalS, LocalDateTime departureT);
}
