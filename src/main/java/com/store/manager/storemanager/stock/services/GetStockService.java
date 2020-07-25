package com.store.manager.storemanager.stock.services;

import com.store.manager.storemanager.exceptions.StockNotFoundException;
import com.store.manager.storemanager.stock.StockDTO;

@FunctionalInterface
public interface GetStockService {
    StockDTO get(Long stockId) throws StockNotFoundException;
}
