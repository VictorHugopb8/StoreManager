package com.store.manager.storemanager.product.services;

import com.store.manager.storemanager.product.Product;
import com.store.manager.storemanager.product.ProductDTO;
import com.store.manager.storemanager.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListProductServiceImpl implements ListProductService {
    private final ProductRepository productRepository;

    @Override
    public Page<ProductDTO> pageProducts(UriComponentsBuilder uriBuilder, HttpServletResponse response, Class<Product> clazz, Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        List<ProductDTO> productDTOs = new ArrayList<>();
        products.forEach(product -> {
            ProductDTO dto = ProductDTO.builder()
                    .id(product.getId())
                    .barCode(product.getBarCode())
                    .name(product.getName())
                    .value(product.getValue())
                    .build();
            productDTOs.add(dto);
        });

        return new PageImpl<>(productDTOs);

    }

}
