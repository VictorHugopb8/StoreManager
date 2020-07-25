package com.store.manager.storemanager.product.services;

import com.store.manager.storemanager.exceptions.ProductNotFoundException;
import com.store.manager.storemanager.product.ProductDTO;

@FunctionalInterface
public interface GetProductService {
    ProductDTO get(Long productId) throws ProductNotFoundException;
}
