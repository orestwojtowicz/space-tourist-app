package com.space.spacetourist.ui.model.response;

import com.space.spacetourist.shared.TouristDto;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
public class FlightRest {

    private String flightId;

    private Date departureDate;

    private Date arrivalDate;

    private int numberSeats;

    private double ticketPrice;


    @ToString.Exclude
    List<TouristDto> touristEntities;

}
