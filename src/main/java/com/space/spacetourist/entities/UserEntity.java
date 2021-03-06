package com.space.spacetourist.entities;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String userEmail;


    @Builder
    public UserEntity(String username,
                      String password,
                      String userEmail) {
        this.username = username;
        this.password = password;
        this.userEmail = userEmail;
    }
}
