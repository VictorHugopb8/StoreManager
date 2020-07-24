package com.store.manager.storemanager.product.services;

import com.store.manager.storemanager.exceptions.ProductNotFoundException;

@FunctionalInterface
public interface DeleteProductService {
    void delete(Long productId) throws ProductNotFoundException;
}
