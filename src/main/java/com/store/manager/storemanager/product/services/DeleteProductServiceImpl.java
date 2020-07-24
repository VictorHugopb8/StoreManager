package com.store.manager.storemanager.product.services;

import com.store.manager.storemanager.exceptions.ProductNotFoundException;
import com.store.manager.storemanager.product.Product;
import com.store.manager.storemanager.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class DeleteProductServiceImpl implements DeleteProductService {

    private final ProductRepository productRepository;

    @Override
    public void delete(Long id) throws ProductNotFoundException {
        Optional<Product> productOpt = productRepository.findById(id);
        Product product = productOpt.orElseThrow(ProductNotFoundException::new);
        productRepository.delete(product);
    }
}
