package com.store.manager.storemanager.stock.services;

import com.store.manager.storemanager.exceptions.StockNotFoundException;

@FunctionalInterface
public interface DeleteStockService {
    void delete(Long stockId) throws StockNotFoundException;
}
