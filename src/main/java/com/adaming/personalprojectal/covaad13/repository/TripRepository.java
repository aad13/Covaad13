package com.adaming.personalprojectal.covaad13.repository;

import com.adaming.personalprojectal.covaad13.entity.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip,Long> {
}
