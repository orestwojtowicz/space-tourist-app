package com.space.spacetourist.entities;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.exception.DataException;

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

    private DataException departureDate;

    private Date arrivalDate;

    private int numberSeats;

    private double ticketPrice;


    @ManyToMany(mappedBy = "flightEntities",
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    List<TouristEntity> touristEntities = new ArrayList<>();


    @Builder
    public FlightEntity(DataException departureDate,
                        Date arrivalDate, int numberSeats,
                        double ticketPrice,
                        List<TouristEntity> touristEntities) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.numberSeats = numberSeats;
        this.ticketPrice = ticketPrice;
        this.touristEntities = touristEntities;
    }
}