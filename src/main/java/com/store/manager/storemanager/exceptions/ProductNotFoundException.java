package com.store.manager.storemanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ResourceBundle;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends Exception {

    public ProductNotFoundException() {
        super(ResourceBundle.getBundle("message").getString("store.manager.product.not.found"));
    }

}
