package com.proyecto.apprendiendo.utils;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ResponseDecorator {
    @FunctionalInterface
    public interface CallableEx<T> {
        T execute();
    }

    public <T> ResponseEntity<T> decorate(CallableEx<T> service) {
        try {
            return ResponseEntity.ok().body(service.execute());
        }
        catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
