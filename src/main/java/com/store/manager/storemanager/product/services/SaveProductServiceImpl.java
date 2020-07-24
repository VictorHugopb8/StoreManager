package com.store.manager.storemanager.product.services;

import com.store.manager.storemanager.product.Product;
import com.store.manager.storemanager.product.ProductDTO;
import com.store.manager.storemanager.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class SaveProductServiceImpl implements SaveProductService {

    private final ProductRepository productRepository;

    @Override
    public void save(ProductDTO productDTO) {
        Product product = Product.builder()
                .barCode(productDTO.getBarCode())
                .name(productDTO.getName())
                .value(productDTO.getValue())
                .build();
        productRepository.save(product);
    }
}
