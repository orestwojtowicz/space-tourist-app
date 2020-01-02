package com.space.spacetourist.ui.controller;

import com.space.spacetourist.entity.FlightEntity;
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

    }






















