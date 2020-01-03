package com.space.spacetourist.service;

import com.space.spacetourist.entity.FlightEntity;
import com.space.spacetourist.shared.FlightDto;

import java.util.List;

public interface FlightService {

    List<FlightDto> getAllTouristFlights(String touristId);
    FlightDto getFlights(String flightId);

}
