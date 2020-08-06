package com.store.manager.storemanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ResourceBundle;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super(ResourceBundle.getBundle("messages").getString("store.manager.user.not.found"));
    }
}
