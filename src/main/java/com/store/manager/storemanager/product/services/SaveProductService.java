package com.store.manager.storemanager.product.services;

import com.store.manager.storemanager.product.ProductDTO;

@FunctionalInterface
public interface SaveProductService {
    void save(ProductDTO productDTO);
}
