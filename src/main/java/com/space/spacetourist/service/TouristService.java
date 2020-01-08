package com.space.spacetourist.service;



import com.space.spacetourist.shared.FlightDto;
import com.space.spacetourist.shared.TouristDto;

import java.util.List;


public interface TouristService {

    TouristDto getSingleTourist(String touristId);
    void deleteTourist(String touristId);

    List<TouristDto> getAllTourists(int page, int limit);


    List<FlightDto> getAllTouristFlights(String touristId);


}
