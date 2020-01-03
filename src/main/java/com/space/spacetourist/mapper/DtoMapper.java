package com.space.spacetourist.mapper;

import com.space.spacetourist.shared.FlightDto;
import com.space.spacetourist.shared.TouristDto;
import org.modelmapper.ModelMapper;


public class DtoMapper {




    public TouristDto convertToDto(Object obj, TouristDto mapper) {
        return new ModelMapper().map(obj,mapper.getClass());
    }

    public Object convertToEntity(Object obj, TouristDto mapper) {
        return new ModelMapper().map(mapper,obj.getClass());
    }

    /*
     * FLIGHT MAPPER
     * */

    public FlightDto convertToDto(Object object, FlightDto flightDto) {
        return new ModelMapper().map(object, flightDto.getClass());
    }



}













