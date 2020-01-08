package com.space.spacetourist.mapper;

import com.space.spacetourist.shared.FlightDto;
import com.space.spacetourist.shared.UserDto;
import com.space.spacetourist.ui.model.response.FlightRest;
import com.space.spacetourist.ui.model.response.TouristRest;
import com.space.spacetourist.ui.model.response.UserRest;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.List;

public class RestMapper {

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


    public List<FlightRest> convertFlightsToRest(List<FlightDto> objects, List<FlightRest> flightRests) {
        return new ModelMapper().map(objects, flightRests.getClass());
    }

    /*
    *  USER MAPPER
    * **/


    public UserRest convertToRestUser(Object object, UserRest userRest) {
        return new ModelMapper().map(object, userRest.getClass());
    }

    public UserDto convertToDtoUser(Object object, UserDto userDto) {
        return new ModelMapper().map(object, userDto.getClass());
    }







}
