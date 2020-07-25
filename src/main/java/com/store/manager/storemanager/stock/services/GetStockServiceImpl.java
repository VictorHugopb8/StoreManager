package com.store.manager.storemanager.stock.services;

import com.store.manager.storemanager.exceptions.StockNotFoundException;
import com.store.manager.storemanager.stock.Stock;
import com.store.manager.storemanager.stock.StockDTO;
import com.store.manager.storemanager.stock.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetStockServiceImpl implements GetStockService {

    private final StockRepository stockRepository;

    @Override
    public StockDTO get(Long id) throws StockNotFoundException {
        Optional<Stock> stockOpt = stockRepository.findById(id);
        Stock stock = stockOpt.orElseThrow(() -> new StockNotFoundException(null));
        return StockDTO.builder()
                .id(stock.getId())
                .hasStock(stock.getQuantity() != null && stock.getQuantity() > 0)
                .productId(stock.getProduct().getId())
                .quantity(stock.getQuantity())
                .build();
   }
}
