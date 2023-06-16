package com.alaeldin.erpschoolSystem.exception.existdata;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RoleAlreadyExist extends RuntimeException {
    private String message;

    public RoleAlreadyExist(String message) {
        super(message);
    }
}
