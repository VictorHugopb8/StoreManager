package com.store.manager.storemanager.product.services;

import com.store.manager.storemanager.exceptions.BadRequestException;
import com.store.manager.storemanager.exceptions.ProductNotFoundException;
import com.store.manager.storemanager.product.ProductDTO;

@FunctionalInterface
public interface UpdateProductService {
    void update(Long productId, ProductDTO productDTO) throws ProductNotFoundException, BadRequestException;
}
