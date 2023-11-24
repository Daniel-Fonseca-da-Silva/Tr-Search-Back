package com.dafon.trsearchback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Custom404Exception extends RuntimeException {

    public Custom404Exception(String message) {
        super(message);
    }
}
