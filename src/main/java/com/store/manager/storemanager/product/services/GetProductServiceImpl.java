package com.store.manager.storemanager.product.services;

import com.store.manager.storemanager.exceptions.ProductNotFoundException;
import com.store.manager.storemanager.product.Product;
import com.store.manager.storemanager.product.ProductDTO;
import com.store.manager.storemanager.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProductServiceImpl implements GetProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDTO get(Long id) throws ProductNotFoundException {
        Optional<Product> productOpt = productRepository.findById(id);
        Product product = productOpt.orElseThrow(ProductNotFoundException::new);
        return ProductDTO.builder()
                .id(product.getId())
                .barCode(product.getBarCode())
                .name(product.getName())
                .build();
   }
}
