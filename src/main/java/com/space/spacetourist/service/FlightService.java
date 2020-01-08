package com.space.spacetourist.service;


import com.space.spacetourist.shared.FlightDto;
import com.space.spacetourist.shared.TouristDto;

import java.util.List;

public interface FlightService {

    List<FlightDto> getAllTouristFlights(String touristId);
    FlightDto getFlights(String flightId);


    List<TouristDto> getAllTouristFromOneFlight(String flightId);




}
