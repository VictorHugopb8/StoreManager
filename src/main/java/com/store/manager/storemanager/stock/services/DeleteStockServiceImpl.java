package com.store.manager.storemanager.stock.services;

import com.store.manager.storemanager.exceptions.StockNotFoundException;
import com.store.manager.storemanager.product.ProductRepository;
import com.store.manager.storemanager.stock.Stock;
import com.store.manager.storemanager.stock.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class DeleteStockServiceImpl implements DeleteStockService {

    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    @Override
    public void delete(Long id) throws StockNotFoundException {
        Optional<Stock> stockOpt = stockRepository.findById(id);
        stockRepository.delete(stockOpt.orElseThrow(StockNotFoundException::new));
    }
}
