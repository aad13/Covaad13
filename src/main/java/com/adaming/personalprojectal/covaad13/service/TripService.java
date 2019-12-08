package com.adaming.personalprojectal.covaad13.service;

import com.adaming.personalprojectal.covaad13.entity.Trip;
import com.adaming.personalprojectal.covaad13.exception.NullTripException;
import com.adaming.personalprojectal.covaad13.exception.TooEarlyTripException;
import com.adaming.personalprojectal.covaad13.exception.TripAlreadyExistException;
import com.adaming.personalprojectal.covaad13.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Transactional
    public void register(Trip t) throws NullTripException, TripAlreadyExistException, TooEarlyTripException {
        if (t==null){
            throw new NullTripException();
        }else{
            if (t.getDepartureT().isBefore(LocalDateTime.now())){
                throw new TooEarlyTripException();
            }else {
                if (this.tripRepository.getTripByOwnerAndDepartureSAAndArrivalSAndDepartureT(t.getOwner(),t.getDepartureS(), t.getArrivalS(), t.getDepartureT()) == null) {
                    this.tripRepository.save(t);
                } else {
                    throw new TripAlreadyExistException();
                }
            }
        }
    }

    public Trip fetchById(Long id){
        return this.tripRepository.findById(id).orElse(null);
    }

    public Iterable<Trip> fetchAll(){
        return this.tripRepository.findAll();
    }
}
