package com.store.manager.storemanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ResourceBundle;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {

    public BadRequestException() {
        super(ResourceBundle.getBundle("message").getString("store.manager.bad.request"));
    }
}
