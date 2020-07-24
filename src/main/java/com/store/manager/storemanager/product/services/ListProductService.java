package com.store.manager.storemanager.product.services;

import com.store.manager.storemanager.product.Product;
import com.store.manager.storemanager.product.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface ListProductService {

    Page<ProductDTO> pageProducts(
            UriComponentsBuilder uriBuilder, HttpServletResponse response, Class<Product> clazz, Pageable pageable
    );
}
