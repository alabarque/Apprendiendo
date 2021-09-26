package com.proyecto.apprendiendo.services.login_services;

import com.proyecto.apprendiendo.config.security.JwtTokenUtil;
import com.proyecto.apprendiendo.entities.UserToken;
import com.proyecto.apprendiendo.entities.dtos.UserLoginDTO;
import com.proyecto.apprendiendo.repositories.UserRepository;
import com.proyecto.apprendiendo.repositories.UserTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserTokenRepository userTokenRepository;
    private final UserRepository userRepository;

    public String execute(UserLoginDTO userDTO) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
        UserDetails userDetail = (UserDetails) authenticate.getPrincipal();
        Optional<UserToken> userTokenOptional = userTokenRepository.findFirstByUsername(userDetail.getUsername());
        if(userTokenOptional.isPresent()){
            return userTokenOptional.get().getToken();
        } else{
            String token = jwtTokenUtil.generateToken(userDetail);
            UserToken userToken = UserToken.builder().username(userDetail.getUsername()).token(token).build();
            userTokenRepository.save(userToken);
            return token;
        }
    }
}
