package com.space.spacetourist.ui.model.request;


import com.space.spacetourist.entity.Gender;
import com.space.spacetourist.shared.FlightDto;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class TouristRequestModel {


    private String firstName;
    private String lastName;
    private Gender gender;
    private String country;
    private String remarsk;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date birthDate;

    @ToString.Exclude
    List<FlightDto> flightEntities;


}
