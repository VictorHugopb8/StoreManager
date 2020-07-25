package com.store.manager.storemanager.stock.services;

import com.store.manager.storemanager.exceptions.ProductNotFoundException;
import com.store.manager.storemanager.product.Product;
import com.store.manager.storemanager.product.ProductRepository;
import com.store.manager.storemanager.stock.Stock;
import com.store.manager.storemanager.stock.StockDTO;
import com.store.manager.storemanager.stock.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class SaveStockServiceImpl implements SaveStockService {

    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    @Override
    public void save(StockDTO stockDTO, Long productId) throws ProductNotFoundException {
        Optional<Product> productOpt = productRepository.findById(productId);
        Stock stock = Stock.builder()
                .product(productOpt.orElseThrow(ProductNotFoundException::new))
                .build();
        stockRepository.save(stock);
    }
}
