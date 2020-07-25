package com.store.manager.storemanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StockNotFoundException extends Exception {

    public StockNotFoundException(String productName) {
        super("Estoque do produto" + productName + "não encontrado.");
    }
}
