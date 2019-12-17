package com.space.spacetourist.services;


import com.space.spacetourist.entities.UserEntity;
import com.space.spacetourist.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

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
}
