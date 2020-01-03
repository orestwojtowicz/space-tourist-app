package com.space.spacetourist.mapper;

import com.space.spacetourist.shared.FlightDto;
import com.space.spacetourist.shared.TouristDto;
import com.space.spacetourist.ui.model.response.FlightRest;
import com.space.spacetourist.ui.model.response.TouristRest;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;


import java.lang.reflect.Type;
import java.util.List;


public class DtoMapper {




    public TouristDto convertToDto(Object obj, TouristDto mapper) {
        return new ModelMapper().map(obj,mapper.getClass());
    }

    public Object convertToEntity(Object obj, TouristDto mapper) {
        return new ModelMapper().map(mapper,obj.getClass());
    }

    public TouristRest convertToRest(Object object, TouristRest mapper) {
        return new ModelMapper().map(object,mapper.getClass());
    }


    public List<TouristRest> convertToTypeToken(Object object, Type listType) {
        return new ModelMapper().map(object, listType);
    }


    /*
     * FLIGHT MAPPER
     * */

    public FlightDto convertToDto(Object object, FlightDto flightDto) {
        return new ModelMapper().map(object, flightDto.getClass());
    }

    public FlightRest convertToRest(Object object, FlightRest flightRest) {
        return new ModelMapper().map(object,flightRest.getClass());
    }







}













