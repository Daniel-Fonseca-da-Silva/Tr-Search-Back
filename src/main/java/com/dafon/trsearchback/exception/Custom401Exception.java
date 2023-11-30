package com.dafon.trsearchback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class Custom401Exception extends RuntimeException {
        public Custom401Exception(String message) {
            super(message);
        }
}
