package com.space.spacetourist.service.impl;


import com.space.spacetourist.entity.UserEntity;
import com.space.spacetourist.mapper.DtoMapper;
import com.space.spacetourist.repository.UserRepository;
import com.space.spacetourist.service.UserService;
import com.space.spacetourist.shared.UserDto;
import com.space.spacetourist.ui.model.request.UserRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;


@Service
@Slf4j
public class MyUserDetailsService extends DtoMapper implements UserDetailsService, UserService {

    private final UserRepository userRepository;


    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> findAuthUser = userRepository.findByUsername(userName);
        if (findAuthUser.isPresent()) {
            return new User(findAuthUser.get().getUsername(), findAuthUser.get().getPassword(), new ArrayList<>());
        }

        throw new UsernameNotFoundException("User does not exist");
    }


    @Override
    public UserDto createNewUser(UserDto userDto) {

        UserDto returnValue = new UserDto();
        UserEntity userEntity = convertToEntityUser(userDto, new UserEntity());
        userEntity.setUserId(UUID.randomUUID().toString());


        UserEntity savedUser = userRepository.save(userEntity);

        returnValue = convertToDtoUser(savedUser,returnValue);

        log.info("Returning saved user -- " + returnValue);

        return returnValue;
    }
}
/*
    public TouristEntity createNewTourist(TouristRequestModel touristEntityDTO) {

        ModelMapper mapper = new ModelMapper();
        TouristEntity returnTourist = mapper.map(touristEntityDTO, TouristEntity.class);
        returnTourist.setTouristId(UUID.randomUUID().toString());
        log.info("SAVING TOURIST " + returnTourist);
        touristRepository.save(returnTourist);

        return returnTourist;

    }*/
