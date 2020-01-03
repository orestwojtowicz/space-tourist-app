package com.space.spacetourist.ui.controller;


import com.space.spacetourist.entity.TouristEntity;
import com.space.spacetourist.mapper.DtoMapper;
import com.space.spacetourist.service.impl.TouristServiceImpl;
import com.space.spacetourist.shared.FlightDto;
import com.space.spacetourist.shared.TouristDto;
import com.space.spacetourist.ui.model.request.TouristRequestModel;
import com.space.spacetourist.ui.model.response.OperationStatusModel;
import com.space.spacetourist.ui.model.response.RequestOperationStatus;
import com.space.spacetourist.ui.model.response.TouristRest;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by damiass on Dec, 2019
 */
@RestController
@Slf4j
@RequestMapping(TouristController.TOURIST_URL)
public class TouristController extends DtoMapper {

    public static final String TOURIST_URL = "/api";

    /**
     * @return model/response/TouristRest.class
     */


    private final TouristServiceImpl touristService;

    public TouristController(TouristServiceImpl touristService) {
        this.touristService = touristService;
    }


    @PostMapping("/add/tourist")
    @ResponseStatus(HttpStatus.CREATED)
    public TouristEntity saveNewTourist(@Valid @RequestBody TouristRequestModel touristEntityDTO) {

        return touristService.createNewTourist(touristEntityDTO);

    }

    @GetMapping(value = "/get/tourist/{touristId}")
    public TouristRest getSingleTourist(@PathVariable String touristId) {
        TouristRest returnValue = new TouristRest();
        TouristDto touristDto = touristService.getSingleTourist(touristId);

        returnValue = convertToRest(touristDto, returnValue);
        log.info("RETURNING TOURIST -- " + returnValue);
        return returnValue;
    }

    @DeleteMapping("/{id}")
    public OperationStatusModel deleteUser(@PathVariable String id) {
        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name());

        touristService.deleteTourist(id);
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        return returnValue;
    }


    // http://localhost:8080/api?page=1&limit=1

    @GetMapping
    public List<TouristRest> getTourists(@RequestParam(value = "page", defaultValue = "0") int page,
                                         @RequestParam(value = "limit", defaultValue = "2") int limit) {

        List<TouristRest> returnValue = new ArrayList<>();
        List<TouristDto> tourists = touristService.getAllTourists(page, limit);

        Type listType = new TypeToken<List<TouristRest>>() {}.getType();
        returnValue = convertToTypeToken(tourists, listType);

        return returnValue;
    }




    @GetMapping("/v2/{touristId}")
    public List<FlightDto> getAllTouristFlights(@PathVariable String touristId) {


        return touristService.getAllTouristFlights(touristId);


    }





}

















