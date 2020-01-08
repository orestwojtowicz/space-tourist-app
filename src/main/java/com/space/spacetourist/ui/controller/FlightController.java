package com.space.spacetourist.ui.controller;


import com.space.spacetourist.entity.FlightEntity;
import com.space.spacetourist.entity.TouristEntity;
import com.space.spacetourist.repository.FlightRepository;
import com.space.spacetourist.repository.TouristRepository;
import com.space.spacetourist.service.FlightService;
import com.space.spacetourist.service.TouristService;
import com.space.spacetourist.shared.FlightDto;
import com.space.spacetourist.ui.model.response.FlightRest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;






@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api")
public class FlightController {


    private final FlightService flightService;
    private final TouristRepository touristRepository;
    private final TouristService touristService;
    private final FlightRepository flightRepository;

    @PostMapping("/add/{id}")
    public void addTouristToFlight(@RequestBody FlightEntity flightEntity, @PathVariable String id) {

        TouristEntity touristEntity1 = touristRepository.findByTouristId(id);
        flightEntity = new FlightEntity();

        flightRepository.save(flightEntity);
        log.info("SAVED FLIGHT");

        touristEntity1.addFlight(flightEntity);
        log.info("FLIGHT ADDED ");


        touristRepository.save(touristEntity1);
        log.info("TOURIST SAVED ");




    }



    @GetMapping("/flight/{flightId}")
   public FlightRest getAllFlights(@PathVariable String flightId) {


        log.info("KONTROLER ");

       FlightDto flightDto = new FlightDto();

       // PRZEZ TURYSTE JA TO ROBIE

       log.info("FLIGHTS " + flightDto.toString());

       ModelMapper modelMapper = new ModelMapper();

       FlightRest returnValue = new FlightRest();


       returnValue = modelMapper.map(flightDto,FlightRest.class);


       return returnValue;


   }



    }






















