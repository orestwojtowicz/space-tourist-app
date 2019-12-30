package com.space.spacetourist.controller;

import com.space.spacetourist.entities.TouristEntity;
import com.space.spacetourist.responses.AppResponse;
import com.space.spacetourist.services.TouristService;
import com.space.spacetourist.view.tourist.TouristEntityDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by damiass on Dec, 2019
 */
@RestController
@Slf4j
@RequestMapping(TouristController.TOURIST_URL)
public class TouristController {


    public static final String TOURIST_URL = "/api";


    @Autowired
    private TouristService touristService;





@PostMapping("/add/tourist")
@ResponseStatus(HttpStatus.CREATED)
public TouristEntity saveNewTourist(@Valid @RequestBody TouristEntityDTO touristEntityDTO) {

    return touristService.createNewTourist(touristEntityDTO);

}


}
