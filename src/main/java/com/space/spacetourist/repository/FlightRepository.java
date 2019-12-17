package com.space.spacetourist.repository;

import com.space.spacetourist.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    List<FlightEntity> findAllById(Long id);

}
