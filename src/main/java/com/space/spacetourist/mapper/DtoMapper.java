package com.space.spacetourist.mapper;

import com.space.spacetourist.entity.UserEntity;
import com.space.spacetourist.shared.FlightDto;
import com.space.spacetourist.shared.TouristDto;
import com.space.spacetourist.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;


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


    /*
    *  USER MAPPER
    * **/

    public UserDto convertToDtoUser(Object object, UserDto userDto) {
        return new ModelMapper().map(object, userDto.getClass());
    }
    public UserEntity convertToEntityUser(Object object, UserEntity userEntity) {
        return new ModelMapper().map(object, userEntity.getClass());
    }



}













