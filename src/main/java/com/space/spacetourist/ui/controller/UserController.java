package com.space.spacetourist.ui.controller;


import com.space.spacetourist.mapper.RestMapper;
import com.space.spacetourist.security.auth_model.AuthenticationRequest;
import com.space.spacetourist.security.auth_model.AuthenticationResponse;
import com.space.spacetourist.security.jwt.JwtUtil;
import com.space.spacetourist.service.UserService;
import com.space.spacetourist.service.impl.MyUserDetailsService;
import com.space.spacetourist.shared.UserDto;
import com.space.spacetourist.ui.model.request.UserRequestModel;
import com.space.spacetourist.ui.model.response.UserRest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController extends RestMapper {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService myUserDetailsService;
    private final JwtUtil jwtUtil;
    private final UserService userService;





    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {


        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Wrong username or password", e);
        }


        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }




    @PostMapping("/create/user")
    public UserRest createUser(@RequestBody UserRequestModel userRequestModel) {

        UserRest returnValue = new UserRest();



        UserDto createUser = new UserDto();

       createUser = userService.createNewUser(convertToDtoUser(userRequestModel, createUser));

        returnValue = convertToRestUser(createUser, returnValue);

        log.info("CONTROLLER " + returnValue);


        return returnValue;
    }






}

























