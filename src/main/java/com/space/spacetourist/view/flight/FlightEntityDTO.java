package com.space.spacetourist.view.flight;

import com.space.spacetourist.entities.FlightEntity;
import com.space.spacetourist.entities.TouristEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class FlightEntityDTO {

    private String id;

    @NotNull
    @DateTimeFormat
    private Date departureDate;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date arrivalDateTime;

    @NotNull
    @NumberFormat
    private int numberSeats;

    @NotNull
    @NumberFormat
    private double tickerPrice;

    List<TouristEntity> touristEntities;

    public FlightEntityDTO(FlightEntity flightEntity) {

        id = UUID.randomUUID().toString();
        departureDate = flightEntity.getDepartureDate();
        arrivalDateTime = flightEntity.getArrivalDate();
        numberSeats = flightEntity.getNumberSeats();
        tickerPrice = flightEntity.getTicketPrice();
        touristEntities = new ArrayList<>();
        touristEntities.addAll(flightEntity.getTouristEntities());

    }



}














