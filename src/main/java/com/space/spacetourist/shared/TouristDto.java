package com.space.spacetourist.shared;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String gender;
    private String country;
    private String remarsk;
    @JsonFormat(pattern = "d-M-yyyy HH:mm")
    private Date birthDate;

    @ToString.Exclude
    private List<FlightDto> flightEntities;


}
