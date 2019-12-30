package com.space.spacetourist.controller;

import com.space.spacetourist.entities.FlightEntity;
import com.space.spacetourist.repository.FlightRepository;
import com.space.spacetourist.repository.TouristRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@Slf4j
@RequestMapping("/api")
public class FlightController {


    private final FlightRepository flightRepository;
    private final TouristRepository touristRepository;


    public FlightController(FlightRepository flightRepository,
                            TouristRepository touristRepository
                           ) {
        this.flightRepository = flightRepository;
        this.touristRepository = touristRepository;

    }


    /*
    *  GET ALL TOURISTS FROM SINGLE FLIGHT MOVE IT TO OTHER CONTROLLER
    *
    * */
/*    @RequestMapping(value = "/flight/tourist/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<FlightEntityDTO>> getAllTouristsFromSingleFlight(@PathVariable Long id) {
     //   List<FlightEntityDTO> returnValue = flightEntityMapper.getAllFlightsWithTourists(id);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }*/


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


























