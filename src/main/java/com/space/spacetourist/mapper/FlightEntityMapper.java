package com.space.spacetourist.mapper;

import com.space.spacetourist.repository.FlightRepository;
import com.space.spacetourist.view.flight.FlightEntityDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightEntityMapper {

    private final FlightRepository flightRepository;

    public FlightEntityMapper(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public List<FlightEntityDTO> getAllFlightsWithTourists(Long id) {
        return flightRepository.findAllById(id)
                .stream()
                .map(FlightEntityDTO::new)
                .collect(Collectors.toList());
    }





}
