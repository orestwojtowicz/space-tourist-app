package com.space.spacetourist.view.tourist;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class TouristEntityDTO {


    private String id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String gender;

    @NotNull
    private String country;

    @NotNull
    private String remarsk;

    @NotNull
    @DateTimeFormat
    private Date birthDate;


    public TouristEntityDTO(String id, @NotNull String firstName,
                            @NotNull String lastName, @NotNull String gender,
                            @NotNull String country, @NotNull String remarsk,
                            @NotNull Date birthDate) {
        this.id = UUID.randomUUID().toString();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.remarsk = remarsk;
        this.birthDate = birthDate;
    }

}
