package com.store.manager.storemanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ResourceBundle;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StockNotFoundException extends Exception {

    public StockNotFoundException() {
        super(ResourceBundle.getBundle("message").getString("store.manager.stock.not.found"));
    }
}
