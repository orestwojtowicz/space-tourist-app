package com.space.spacetourist.security.auth_model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AuthenticationResponse {

    private final String jwt;



}
