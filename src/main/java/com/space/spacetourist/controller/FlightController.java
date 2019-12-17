package com.space.spacetourist.controller;

import com.space.spacetourist.entities.FlightEntity;
import com.space.spacetourist.entities.TouristEntity;
import com.space.spacetourist.mapper.FlightEntityMapper;
import com.space.spacetourist.repository.FlightRepository;
import com.space.spacetourist.repository.TouristRepository;
import com.space.spacetourist.view.flight.FlightEntityDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class FlightController {


    private final FlightRepository flightRepository;
    private final TouristRepository touristRepository;
    private final FlightEntityMapper flightEntityMapper;

    public FlightController(FlightRepository flightRepository,
                            TouristRepository touristRepository,
                            FlightEntityMapper flightEntityMapper) {
        this.flightRepository = flightRepository;
        this.touristRepository = touristRepository;
        this.flightEntityMapper = flightEntityMapper;
    }


    /*
    *  GET ALL TOURISTS FROM SINGLE FLIGHT MOVE IT TO OTHER CONTROLLER
    * */
    @RequestMapping("/flight/tourist/{id}")
    public ResponseEntity<List<FlightEntityDTO>> getAllTouristsFromSingleFlight(@PathVariable Long id) {
        List<FlightEntityDTO> returnValue = flightEntityMapper.getAllFlightsWithTourists(id);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }


    /*
    * GET ALL FLIGHTS
    * */

    @RequestMapping("/all/flights")
    public List<TouristEntity> getFlights() {

        List<TouristEntity> touristEntities = new ArrayList<>();

        for (FlightEntity flightEntity : flightRepository.findAll()) {
            touristEntities = flightEntity.getTouristEntities();
        }
        return touristEntities;

    }


}




















