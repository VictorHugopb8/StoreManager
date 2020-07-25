package com.store.manager.storemanager.stock.v1;

import com.store.manager.storemanager.exceptions.BadRequestException;
import com.store.manager.storemanager.exceptions.ProductNotFoundException;
import com.store.manager.storemanager.exceptions.StockNotFoundException;
import com.store.manager.storemanager.stock.Stock;
import com.store.manager.storemanager.stock.StockDTO;
import com.store.manager.storemanager.stock.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1/stocks")
@RequiredArgsConstructor
public class StockControllerV1 {

    private final ListStockService listStockService;
    private final SaveStockService saveStockService;
    private final UpdateStockService updateStockService;
    private final DeleteStockService deleteStockService;
    private final GetStockService getStockService;

    @GetMapping
    public Page<StockDTO> page(UriComponentsBuilder uriBuilder, HttpServletResponse response,
                                 Class<Stock> clazz, Pageable pageable) {
        return listStockService.pageStocks(uriBuilder, response, clazz, pageable);
    }

    @PostMapping("/save")
    public void save(@PathVariable("productId") Long productId, @RequestBody StockDTO stockDTO) throws ProductNotFoundException {
        saveStockService.save(stockDTO, productId);
    }

    @PutMapping("/{id}/update")
    public void update(@PathVariable("id") Long id, @RequestBody StockDTO dto) throws StockNotFoundException, BadRequestException, ProductNotFoundException {
        updateStockService.update(id, dto);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") Long id) throws StockNotFoundException {
        deleteStockService.delete(id);
    }

    @GetMapping("/{stockId}/single")
    public StockDTO get(@PathVariable("stockId") Long stockId) throws StockNotFoundException {
        return getStockService.get(stockId);
    }
}
