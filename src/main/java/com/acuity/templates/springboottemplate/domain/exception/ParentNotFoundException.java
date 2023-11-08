package com.acuity.templates.springboottemplate.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ParentNotFoundException extends RuntimeException {

    public ParentNotFoundException(UUID id) {
        super("Parent with id " + id + " not found");
    }
}
