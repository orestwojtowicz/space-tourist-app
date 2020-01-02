package com.space.spacetourist.ui.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.space.spacetourist.shared.FlightDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TouristRest {

    private String touristId;
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String remarsk;
    @JsonFormat(pattern = "d-M-yyyy HH:mm")
    private Date birthDate;

    @ToString.Exclude
    @JsonIgnore
    private List<FlightDto> flightEntities;


}
