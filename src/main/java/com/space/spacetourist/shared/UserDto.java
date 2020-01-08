package com.space.spacetourist.shared;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String userId;
    private String username;
    private String password;
    private String userEmail;


}
