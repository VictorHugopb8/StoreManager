package com.store.manager.storemanager.product.services;

import com.store.manager.storemanager.exceptions.BadRequestException;
import com.store.manager.storemanager.exceptions.ProductNotFoundException;
import com.store.manager.storemanager.product.Product;
import com.store.manager.storemanager.product.ProductDTO;
import com.store.manager.storemanager.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class UpdateProductServiceImpl implements UpdateProductService {

    private final ProductRepository productRepository;

    @Override
    public void update(Long id, ProductDTO productDTO) throws ProductNotFoundException, BadRequestException {
        if (id != null) {
            Optional<Product> productOpt = productRepository.findById(id);
            Product product = productOpt.orElseThrow(ProductNotFoundException::new);

            if (productDTO.getBarCode() != null) {
                product.setBarCode(productDTO.getBarCode());
            }
            if (productDTO.getName() != null) {
                product.setName(productDTO.getName());
            }
            if (productDTO.getValue() != null) {
                product.setValue(productDTO.getValue());
            }

            productRepository.save(product);
        } else {
            throw new BadRequestException();
        }
    }
}
