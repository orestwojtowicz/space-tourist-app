package com.space.spacetourist.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class FlightEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightId;

    private Date departureDate;

    private Date arrivalDate;

    private int numberSeats;

    private double ticketPrice;


    @ManyToMany(mappedBy = "flightEntities",
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    List<TouristEntity> touristEntities = new ArrayList<>();


    public void addTouristToFlight(TouristEntity touristEntity) {
        touristEntities.add(touristEntity);
    }



    @Builder
    public FlightEntity(Date departureDate,
                        Date arrivalDate, int numberSeats,
                        double ticketPrice,
                        List<TouristEntity> touristEntities, String flightId) {
        this.flightId = flightId;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.numberSeats = numberSeats;
        this.ticketPrice = ticketPrice;
        this.touristEntities = touristEntities;
    }
}