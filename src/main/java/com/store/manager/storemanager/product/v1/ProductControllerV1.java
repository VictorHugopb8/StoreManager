package com.store.manager.storemanager.product.v1;

import com.store.manager.storemanager.exceptions.BadRequestException;
import com.store.manager.storemanager.exceptions.ProductNotFoundException;
import com.store.manager.storemanager.product.Product;
import com.store.manager.storemanager.product.ProductDTO;
import com.store.manager.storemanager.product.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductControllerV1 {

    private final ListProductService listProductService;
    private final SaveProductService saveProductService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;
    private final GetProductService getProductService;

    @GetMapping
    public Page<ProductDTO> page(UriComponentsBuilder uriBuilder, HttpServletResponse response,
                                 Class<Product> clazz, Pageable pageable) {
        return listProductService.pageProducts(uriBuilder, response, clazz, pageable);
    }

    @PostMapping("/save")
    public void save(@RequestBody ProductDTO productDTO) {
        saveProductService.save(productDTO);
    }

    @PostMapping("/{quantity}/save")
    public void saveMultiplies(@PathVariable("quantity") int quantity, @RequestBody ProductDTO dto) {
        for (int i = 0; i < quantity; i++) {
            ProductDTO dto1 = ProductDTO.builder()
                    .name(dto.getName() + " " + i)
                    .barCode(dto.getBarCode() + Math.random()*10)
                    .value(dto.getValue().pow(i))
                    .build();
            saveProductService.save(dto1);
        }
    }

    @PutMapping("/{id}/update")
    public void update(@PathVariable("id") Long id, @RequestBody ProductDTO dto) throws ProductNotFoundException, BadRequestException {
        updateProductService.update(id, dto);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") Long id) throws ProductNotFoundException {
        deleteProductService.delete(id);
    }

    @GetMapping("/{productId}/single")
    public ProductDTO get(@PathVariable("productId") Long productId) throws ProductNotFoundException {
        return getProductService.get(productId);
    }
}
