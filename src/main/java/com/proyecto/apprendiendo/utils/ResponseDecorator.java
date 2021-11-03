package com.proyecto.apprendiendo.utils;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ResponseDecorator {
    private ResponseDTOBuilder responseDTOBuilder;

    public <T> ResponseEntity<T> decorate(CallableEx<T> service) {
        try {
            return ResponseEntity.ok().body((T)responseDTOBuilder.build(service.execute()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @FunctionalInterface
    public interface CallableEx<T> {
        T execute();
    }
}
