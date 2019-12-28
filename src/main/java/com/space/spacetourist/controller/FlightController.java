package com.space.spacetourist.controller;

import com.space.spacetourist.entities.FlightEntity;
import com.space.spacetourist.entities.TouristEntity;
import com.space.spacetourist.mapper.FlightEntityMapper;
import com.space.spacetourist.repository.FlightRepository;
import com.space.spacetourist.repository.TouristRepository;
import com.space.spacetourist.view.flight.FlightEntityDTO;
import com.sun.xml.bind.v2.schemagen.xmlschema.Appinfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
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
    *
    * */
    @RequestMapping(value = "/flight/tourist/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<FlightEntityDTO>> getAllTouristsFromSingleFlight(@PathVariable Long id) {
        List<FlightEntityDTO> returnValue = flightEntityMapper.getAllFlightsWithTourists(id);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }


    /*
    * GET ALL FLIGHTS

     */
/*    List<FlightEntityDTO> returnValue = flightRepository.findAllById(id)
            .stream()
            .map(FlightEntityDTO::new)
            .collect(Collectors.toList());*/

    @GetMapping("/all/flights")
    public List<FlightEntity> getFlights() {
      /*  List<FlightEntity> flightEntities = flightRepository.findAll();
        log.info("ALL FLIGHTS -- " + flightEntities);*/
        return flightRepository.findAll();
    }


/*
        for (FlightEntity flightEntity : flightRepository.findAll()) {
            log.info(flightEntity + " Single Entity ");
            touristEntities = flightEntity.getTouristEntities();
        }
        log.info("RETURN VALUE " + touristEntities);*/


    }

    /*
    * DELETE SINGLE FLIGHT
    * */


























