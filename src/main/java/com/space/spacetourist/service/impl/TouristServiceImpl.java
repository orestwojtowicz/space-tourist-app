package com.space.spacetourist.service.impl;

import com.space.spacetourist.entity.FlightEntity;
import com.space.spacetourist.entity.TouristEntity;
import com.space.spacetourist.mapper.DtoMapper;
import com.space.spacetourist.repository.TouristRepository;
import com.space.spacetourist.service.TouristService;
import com.space.spacetourist.shared.TouristDto;
import com.space.spacetourist.ui.controller.exceptions.UserServiceException;
import com.space.spacetourist.ui.model.request.TouristRequestModel;
import com.space.spacetourist.ui.model.response.ErrorMessage;
import com.space.spacetourist.ui.model.response.ErrorMessages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by damiass on Dec, 2019
 */
@Service
@Slf4j
@RequiredArgsConstructor // constructor injection
public class TouristServiceImpl extends DtoMapper implements TouristService {

    private final TouristRepository touristRepository;


    /**
     * @param touristEntityDTO create new TouristEntity and set random touristId
     * */
    public TouristEntity createNewTourist(TouristRequestModel touristEntityDTO) {

        ModelMapper mapper = new ModelMapper();
        TouristEntity returnTourist = mapper.map(touristEntityDTO, TouristEntity.class);
        returnTourist.setTouristId(UUID.randomUUID().toString());
        log.info("SAVING TOURIST " + returnTourist);
        touristRepository.save(returnTourist);

        return returnTourist;

    }

   /**
    * @param touristId get tourist by public id
    * */
    @Override
    public TouristDto getSingleTourist(String touristId) {

        TouristDto returnValue = new TouristDto();
        TouristEntity touristEntity = touristRepository.findByTouristId(touristId);

        if (touristEntity == null) {
            throw new UsernameNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()
                    + " with id " + touristId);
        }

        returnValue = convertToDto(touristEntity, returnValue);
        log.info("Tourist found, returning -> " + returnValue);

        return returnValue;
    }


    @Override
    public void deleteTourist(String touristId) {

        TouristEntity touristEntity = touristRepository.findByTouristId(touristId);

        if (touristEntity == null) {
            throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
        touristRepository.delete(touristEntity);

    }

    @Override
    public List<TouristDto> findAllByFlightEntities(String touristId) {


        List<TouristEntity> all = touristRepository.findAllByTouristId(touristId);


        log.info("ALL " + all);
        return new List<TouristDto>();

    }
}

















