package com.space.spacetourist.service.impl;

import com.space.spacetourist.entity.TouristEntity;
import com.space.spacetourist.mapper.DtoMapper;
import com.space.spacetourist.repository.TouristRepository;
import com.space.spacetourist.service.TouristService;
import com.space.spacetourist.shared.TouristDto;
import com.space.spacetourist.ui.model.request.TouristRequestModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by damiass on Dec, 2019
 */
@Service
@Slf4j
@RequiredArgsConstructor // constructor injection
public class TouristServiceImpl extends DtoMapper implements TouristService {

    private final TouristRepository touristRepository;






    // create new tourist ADD STRING UUID
    public TouristEntity createNewTourist(TouristRequestModel touristEntityDTO) {

        ModelMapper mapper = new ModelMapper();
        TouristEntity returnTourist = mapper.map(touristEntityDTO, TouristEntity.class);
        log.info("SAVING TOURIST " + returnTourist);
        touristRepository.save(returnTourist);

        return returnTourist;

    }

    // get single tourist


    @Override
    public TouristDto getSingleTourist(String touristId) {

        TouristDto returnValue = new TouristDto();

        log.info("PRZED find");

        TouristEntity touristEntity = touristRepository.findByTouristId(touristId);

        log.info("FOUND ENTITY " + touristEntity);

        if (touristEntity == null) {
            throw new UsernameNotFoundException("User with id " + touristId + " not found");
        }

        log.info("PO NULL NIE DZIALA CONVERT DTO");

        returnValue = convertToDto(touristEntity, returnValue);

        log.info("RETURN " + returnValue);

        return returnValue;


    }
}

















