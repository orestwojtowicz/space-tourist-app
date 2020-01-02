package com.space.spacetourist.ui.model.request;

import com.space.spacetourist.entity.FlightEntity;
import com.space.spacetourist.entity.TouristEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class FlightRequestModel {

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date departureDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date arrivalDateTime;
    private int numberSeats;
    private double tickerPrice;

    List<TouristEntity> touristEntities;

    public FlightRequestModel(FlightEntity flightEntity) {

        departureDate = flightEntity.getDepartureDate();
        arrivalDateTime = flightEntity.getArrivalDate();
        numberSeats = flightEntity.getNumberSeats();
        tickerPrice = flightEntity.getTicketPrice();
        touristEntities = new ArrayList<>();
        touristEntities.addAll(flightEntity.getTouristEntities());

    }



}














