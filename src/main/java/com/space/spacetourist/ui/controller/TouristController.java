package com.space.spacetourist.ui.controller;

import com.space.spacetourist.entity.TouristEntity;
import com.space.spacetourist.mapper.DtoMapper;
import com.space.spacetourist.service.impl.TouristServiceImpl;
import com.space.spacetourist.shared.TouristDto;
import com.space.spacetourist.ui.model.request.TouristRequestModel;
import com.space.spacetourist.ui.model.response.TouristRest;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by damiass on Dec, 2019
 */
@RestController
@Slf4j
@RequestMapping(TouristController.TOURIST_URL)
public class TouristController extends DtoMapper {


    /**
     * @return model/response/TouristRest.class
     * */

    public static final String TOURIST_URL = "/api";

    private final TouristServiceImpl touristServiceImpl;

    public TouristController(TouristServiceImpl touristServiceImpl) {
        this.touristServiceImpl = touristServiceImpl;
    }


    @PostMapping("/add/tourist")
    @ResponseStatus(HttpStatus.CREATED)
    public TouristEntity saveNewTourist(@Valid @RequestBody TouristRequestModel touristEntityDTO) {

        return touristServiceImpl.createNewTourist(touristEntityDTO);

    }

    @GetMapping(value = "/get/tourist/{touristId}")
    public TouristRest getSingleTourist(@PathVariable String touristId) {
        TouristRest returnValue = new TouristRest();
        TouristDto touristDto = touristServiceImpl.getSingleTourist(touristId);

        log.info("KONTROLLER " + touristDto);


        returnValue = convertToRest(touristDto,returnValue);

        log.info("RETURNING TOURIST -- " + returnValue);

        return returnValue;
    }


}
