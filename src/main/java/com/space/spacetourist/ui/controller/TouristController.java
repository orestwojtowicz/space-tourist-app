package com.space.spacetourist.ui.controller;

import com.space.spacetourist.entity.FlightEntity;
import com.space.spacetourist.entity.TouristEntity;
import com.space.spacetourist.mapper.DtoMapper;
import com.space.spacetourist.service.impl.TouristServiceImpl;
import com.space.spacetourist.shared.TouristDto;
import com.space.spacetourist.ui.model.request.TouristRequestModel;
import com.space.spacetourist.ui.model.response.OperationStatusModel;
import com.space.spacetourist.ui.model.response.RequestOperationStatus;
import com.space.spacetourist.ui.model.response.TouristRest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by damiass on Dec, 2019
 */
@RestController
@Slf4j
@RequestMapping(TouristController.TOURIST_URL)
public class TouristController extends DtoMapper {


    /**
     * @return model/response/TouristRest.class
     */

    public static final String TOURIST_URL = "/api";

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


    @GetMapping("/all/{id}")
    public List<TouristEntity> getAll(@PathVariable String id) {
        TouristDto entity = touristService.getSingleTourist(id);
        return touristService.findAllByFlightEntities(convertToEntity(entity))
    }

}

















