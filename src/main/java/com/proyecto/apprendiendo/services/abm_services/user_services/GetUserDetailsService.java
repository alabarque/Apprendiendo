package com.proyecto.apprendiendo.services.abm_services.user_services;

import com.proyecto.apprendiendo.config.security.DefaultUserDetails;
import com.proyecto.apprendiendo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(userRepository.findByUsername(username))
                .map(DefaultUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
}
