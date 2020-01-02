package com.space.spacetourist.shared;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
public class FlightDto {


    private Long id;

    private Date departureDate;

    private Date arrivalDate;

    private int numberSeats;

    private double ticketPrice;


    @ToString.Exclude
    List<TouristDto> touristEntities;


}
