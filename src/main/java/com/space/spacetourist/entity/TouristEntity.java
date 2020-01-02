package com.space.spacetourist.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class TouristEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String touristId;

    private String firstName;

    private String lastName;

    private String gender;

    private String country;

    private String remarsk;
    @JsonFormat(pattern = "d-M-yyyy HH:mm")
    private Date birthDate;







    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tourists_flights",
            joinColumns = {
                    @JoinColumn(name = "tourist_entity_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "flight_entity_id", referencedColumnName = "id")})
    @ToString.Exclude
    private List<FlightEntity> flightEntities;


    public void addFlight(FlightEntity flightEntity) {
        flightEntities = new ArrayList<>();
        flightEntities.add(flightEntity);
    }




    @Builder
    public TouristEntity(String firstName,
                         String lastName, String gender,
                         String country, String remarsk,
                         Date birthDate, String touristId) {

        this.touristId = touristId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.remarsk = remarsk;
        this.birthDate = birthDate;

    }


}


















