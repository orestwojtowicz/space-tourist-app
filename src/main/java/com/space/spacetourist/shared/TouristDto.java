package com.space.spacetourist.shared;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.space.spacetourist.entity.Gender;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
public class TouristDto {



    private Long id;
    private String touristId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String country;
    private String remarsk;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date birthDate;

    @ToString.Exclude
    @JsonIgnore
    private List<FlightDto> flightEntities;


}
