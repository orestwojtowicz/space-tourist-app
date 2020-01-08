package com.space.spacetourist.shared;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
public class FlightDto {


    private Long id;
    private String flightId;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date departureDate;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date arrivalDate;

    private int numberSeats;

    private double ticketPrice;


    @ToString.Exclude
    @JsonIgnore
    List<TouristDto> touristEntities;


}
