package com.space.spacetourist.service.impl;

import com.space.spacetourist.entity.FlightEntity;
import com.space.spacetourist.entity.TouristEntity;
import com.space.spacetourist.mapper.DtoMapper;
import com.space.spacetourist.repository.FlightRepository;
import com.space.spacetourist.repository.TouristRepository;
import com.space.spacetourist.service.FlightService;
import com.space.spacetourist.shared.FlightDto;
import com.space.spacetourist.shared.TouristDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class FlightServiceImpl extends DtoMapper implements FlightService {

    private final FlightRepository flightRepository;
    private final TouristRepository touristRepository;


    @Override
    public List<FlightDto> getAllTouristFlights(String touristId) {

        List<FlightDto> returnValue = new ArrayList<>();
        TouristEntity touristEntity = touristRepository.findByTouristId(touristId);

        if (touristEntity == null) return returnValue;

        log.info("SERWIS " + touristEntity);

        List<FlightEntity> touristFlights = flightRepository.findAllByTouristEntities(touristEntity);

        ModelMapper mapper = new ModelMapper();


        for (FlightEntity flightEntity : touristFlights) {
            returnValue.add(mapper.map(flightEntity,FlightDto.class));
        }

        log.info("RETURNING --> " + returnValue);

        return returnValue;
    }

    @Override
    public List<TouristDto> getAllTouristFromOneFlight(String flightId) {

        List<TouristDto> returnValue = new ArrayList<>();
        FlightEntity flightEntity = flightRepository.findByFlightId(flightId);

        if (flightEntity == null) return returnValue;

        // List<TouristEntity> touristEntities =


        return null;
    }

    @Override
    public FlightDto getFlights(String flightId) {
        return null;
    }
}

































