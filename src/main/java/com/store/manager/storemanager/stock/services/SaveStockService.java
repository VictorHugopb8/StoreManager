package com.store.manager.storemanager.stock.services;

import com.store.manager.storemanager.exceptions.ProductNotFoundException;
import com.store.manager.storemanager.stock.StockDTO;

@FunctionalInterface
public interface SaveStockService {

    void save(StockDTO stockDTO, Long productId) throws ProductNotFoundException;
}
