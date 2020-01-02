package com.space.spacetourist.ui.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.space.spacetourist.entity.TouristEntity;
import com.space.spacetourist.shared.FlightDto;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
public class TouristRequestModel {


    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String remarsk;
    @JsonFormat(pattern = "d-M-yyyy H:m")
    private Date birthDate;

    @ToString.Exclude
    List<FlightDto> flightEntities;


}
