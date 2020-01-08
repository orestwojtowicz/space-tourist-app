package com.space.spacetourist.ui.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.space.spacetourist.entity.Gender;
import com.space.spacetourist.shared.FlightDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TouristRest {

    private String touristId;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String country;
    private String remarsk;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date birthDate;

    @ToString.Exclude
    @JsonIgnore
    private List<FlightDto> flightEntities;


}
