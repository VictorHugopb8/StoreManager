package com.store.manager.storemanager.stock.services;

import com.store.manager.storemanager.stock.Stock;
import com.store.manager.storemanager.stock.StockDTO;
import com.store.manager.storemanager.stock.StockRepository;
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
public class ListStockServiceImpl implements ListStockService {
    private final StockRepository stockRepository;

    @Override
    public Page<StockDTO> pageStocks(UriComponentsBuilder uriBuilder, HttpServletResponse response, Class<Stock> clazz, Pageable pageable) {
        Page<Stock> stocks = stockRepository.findAll(pageable);
        List<StockDTO> stockDTOs = new ArrayList<>();
        stocks.forEach(stock -> {
            StockDTO dto = StockDTO.builder()
                    .id(stock.getId())
                    .hasStock(stock.getQuantity() != null && stock.getQuantity() > 0)
                    .build();
            stockDTOs.add(dto);
        });

        return new PageImpl<>(stockDTOs);

    }

}
