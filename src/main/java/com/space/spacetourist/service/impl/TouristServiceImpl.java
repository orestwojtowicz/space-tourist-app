package com.space.spacetourist.service.impl;

import com.space.spacetourist.entity.FlightEntity;
import com.space.spacetourist.entity.TouristEntity;
import com.space.spacetourist.mapper.DtoMapper;
import com.space.spacetourist.repository.TouristRepository;
import com.space.spacetourist.service.TouristService;
import com.space.spacetourist.shared.FlightDto;
import com.space.spacetourist.shared.TouristDto;
import com.space.spacetourist.ui.controller.exceptions.UserServiceException;
import com.space.spacetourist.ui.model.request.TouristRequestModel;
import com.space.spacetourist.ui.model.response.ErrorMessage;
import com.space.spacetourist.ui.model.response.ErrorMessages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
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
    public List<TouristDto> getAllTourists(int page, int limit) {

        List<TouristDto> returnValue = new ArrayList<>();

        if (page > 0) page = page - 1;

        Pageable pageable = PageRequest.of(page, limit);

        Page<TouristEntity> usersPage = touristRepository.findAll(pageable);
        log.info("USERS PAGE " + usersPage.getContent());

        List<TouristEntity> tourists = usersPage.getContent();

        for (TouristEntity touristEntity : tourists) {
            TouristDto touristDto = new TouristDto();

            BeanUtils.copyProperties(touristEntity, touristDto);
            returnValue.add(touristDto);
        }


        log.info("RETURN VALUE SERVICE " + returnValue);

        return returnValue;

    }

    @Override
    public List<FlightDto> getAllTouristFlights(String touristId) {


        FlightDto flightDto = new FlightDto();

        TouristEntity touristEntity = touristRepository.findByTouristId(touristId);

        if (touristEntity == null)
            throw new UsernameNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());


        List<FlightDto> returnValue = new ArrayList<>();
        List<FlightEntity>  flightEntities = touristEntity.getFlightEntities();

        ModelMapper modelMapper = new ModelMapper();

        for (FlightEntity flightEntity : flightEntities) {
           // returnValue.add(modelMapper.map(flightEntity, FlightDto.class));

            returnValue.add(convertToDto(flightEntity, flightDto));



        }

        log.info("ZWRACAM " + returnValue.toString());



        return returnValue;
    }
}


















































