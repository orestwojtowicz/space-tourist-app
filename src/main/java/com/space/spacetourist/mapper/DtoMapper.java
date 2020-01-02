package com.space.spacetourist.mapper;

import com.space.spacetourist.shared.TouristDto;
import com.space.spacetourist.ui.model.response.TouristRest;
import org.modelmapper.ModelMapper;


import java.lang.reflect.Type;


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


    public TouristRest convertToTypeToken(Object object, Type listType) {
        return new ModelMapper().map(object, listType);
    }


}
