package com.space.spacetourist.view.tourist;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TouristEntityDTO {


    private String id;


    private String firstName;


    private String lastName;


    private String gender;


    private String country;


    private String remarsk;


    @JsonFormat(pattern = "yyyy-M-d H:m")
    private Date birthDate;


    public TouristEntityDTO() {};

}
