package com.packagefactory.factory.service.impl;

import com.packagefactory.factory.core.constants.SuccessStatus;
import com.packagefactory.factory.core.response.ApiResponse;
import com.packagefactory.factory.core.utils.ResponseUtil;
import com.packagefactory.factory.dto.StockDto;
import com.packagefactory.factory.entity.Stock;
import com.packagefactory.factory.exception.NotFoundException;
import com.packagefactory.factory.repository.StockRepository;
import com.packagefactory.factory.service.StockService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {
    private final StockRepository repo;

    public StockServiceImpl(StockRepository repo) {
        this.repo = repo;
    }

    @Override
    public ApiResponse<StockDto> create(StockDto dto) {
        Stock stock = new Stock();
        stock.setName(dto.getName());
        stock.setLocation(dto.getLocation());
        Stock saved = repo.save(stock);
        return ResponseUtil.success(toDto(saved), SuccessStatus.ENTRY_CREATED, "Stock created");
    }

    @Override
    public ApiResponse<StockDto> getById(Long id) {
        Stock stock = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Stock not found: " + id));
        return ResponseUtil.success(toDto(stock), SuccessStatus.ENTRY_FOUND, "Stock found");
    }

    @Override
    public ApiResponse<List<StockDto>> getAll() {
        List<Stock> stocks = repo.findAll();
        List<StockDto> dtos = stocks.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseUtil.success(dtos, SuccessStatus.ENTRY_FOUND, "Stocks fetched");
    }

    @Override
    public ApiResponse<StockDto> update(Long id, StockDto dto) {
        Stock existing = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Stock not found: " + id));
        if (dto.getName() != null) existing.setName(dto.getName());
        if (dto.getLocation() != null) existing.setLocation(dto.getLocation());
        Stock updated = repo.save(existing);
        return ResponseUtil.success(toDto(updated), SuccessStatus.ENTRY_UPDATED, "Stock updated");
    }

    @Override
    public ApiResponse<Void> delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Stock not found: " + id);
        }
        repo.deleteById(id);
        return ResponseUtil.success(null, SuccessStatus.ENTRY_DELETED, "Stock deleted");
    }

    private StockDto toDto(Stock stock) {
        StockDto dto = new StockDto();
        dto.setId(stock.getId());
        dto.setName(stock.getName());
        dto.setLocation(stock.getLocation());
        return dto;
    }

}
