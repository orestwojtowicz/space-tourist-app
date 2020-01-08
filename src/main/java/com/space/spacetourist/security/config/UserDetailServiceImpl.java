package com.space.spacetourist.security.config;

import com.space.spacetourist.entity.UserEntity;
import com.space.spacetourist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            log.info("CAN'T FIND USER ");
            throw new UsernameNotFoundException(username);
        }
        log.info("USER FOUND " + user.get());
        return (UserDetails) user.get();
    }
}
