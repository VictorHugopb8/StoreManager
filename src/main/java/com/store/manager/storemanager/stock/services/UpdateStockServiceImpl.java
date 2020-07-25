package com.store.manager.storemanager.stock.services;

import com.store.manager.storemanager.exceptions.BadRequestException;
import com.store.manager.storemanager.exceptions.ProductNotFoundException;
import com.store.manager.storemanager.exceptions.StockNotFoundException;
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
public class UpdateStockServiceImpl implements UpdateStockService {

    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    @Override
    public void update(Long id, StockDTO stockDTO) throws StockNotFoundException, BadRequestException, ProductNotFoundException {
        if (id != null) {
            Optional<Stock> stockOpt = stockRepository.findById(id);
            Optional<Product> product = productRepository.findById(stockDTO.getProductId());
            Stock stock = stockOpt.orElseThrow(() -> new StockNotFoundException(null));
            stock.setQuantity(stockDTO.getQuantity());
            stock.setProduct(product.orElseThrow(ProductNotFoundException::new));
            stock.setHasStock(stockDTO.getQuantity() != null && stockDTO.getQuantity() > 0);

            stockRepository.save(stock);
        } else {
            throw new BadRequestException();
        }
    }
}
