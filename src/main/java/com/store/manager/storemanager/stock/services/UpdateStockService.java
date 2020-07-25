package com.store.manager.storemanager.stock.services;

import com.store.manager.storemanager.exceptions.BadRequestException;
import com.store.manager.storemanager.exceptions.ProductNotFoundException;
import com.store.manager.storemanager.exceptions.StockNotFoundException;
import com.store.manager.storemanager.stock.StockDTO;

@FunctionalInterface
public interface UpdateStockService {
    void update(Long stockId, StockDTO stockDTO) throws StockNotFoundException, BadRequestException, ProductNotFoundException;
}
