package com.store.manager.storemanager.stock.services;

import com.store.manager.storemanager.stock.Stock;
import com.store.manager.storemanager.stock.StockDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface ListStockService {

    Page<StockDTO> pageStocks(
            UriComponentsBuilder uriBuilder, HttpServletResponse response, Class<Stock> clazz, Pageable pageable
    );
}
