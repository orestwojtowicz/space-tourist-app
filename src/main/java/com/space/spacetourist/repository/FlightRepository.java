package com.space.spacetourist.repository;


import com.space.spacetourist.entity.FlightEntity;
import com.space.spacetourist.entity.TouristEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    List<FlightEntity> findAllByTouristEntities(TouristEntity touristEntity);
    FlightEntity findByFlightId(String flightId);


}
