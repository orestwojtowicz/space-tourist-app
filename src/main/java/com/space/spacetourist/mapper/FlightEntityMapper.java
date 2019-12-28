package com.space.spacetourist.mapper;

import com.space.spacetourist.repository.FlightRepository;
import com.space.spacetourist.view.flight.FlightEntityDTO;
import com.space.spacetourist.view.tourist.TouristEntityDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FlightEntityMapper {

    private final FlightRepository flightRepository;

    public FlightEntityMapper(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public List<FlightEntityDTO> getAllFlightsWithTourists(Long id) {

        List<FlightEntityDTO> returnValue = flightRepository.findAllById(id)
                .stream()
                .map(FlightEntityDTO::new)
                .collect(Collectors.toList());

        log.info("RETURN VALUE -- " + returnValue);

        return returnValue;
    }

// flight -- tourist zmienic



}
