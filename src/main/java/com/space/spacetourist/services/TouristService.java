package com.space.spacetourist.services;

import com.space.spacetourist.entities.TouristEntity;

import com.space.spacetourist.repository.TouristRepository;
import com.space.spacetourist.view.tourist.TouristEntityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * Created by damiass on Dec, 2019
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TouristService {

    private final TouristRepository touristRepository;





    // convert DTO - entity
    public TouristEntity createNewTourist(TouristEntityDTO touristEntityDTO) {


        ModelMapper mapper = new ModelMapper();
        TouristEntity returnTourist = mapper.map(touristEntityDTO,TouristEntity.class);
        log.info("SAVING TOURIST " + returnTourist);
        touristRepository.save(returnTourist);

        return returnTourist;

    }



}
