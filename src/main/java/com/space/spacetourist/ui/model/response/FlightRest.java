package com.space.spacetourist.ui.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.space.spacetourist.shared.TouristDto;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
public class FlightRest {

    private String flightId;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date departureDate;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date arrivalDate;
    private int numberSeats;
    private double ticketPrice;

    @ToString.Exclude
    List<TouristDto> touristEntities;

}
