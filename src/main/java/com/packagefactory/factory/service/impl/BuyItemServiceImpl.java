package com.packagefactory.factory.service.impl;

import com.packagefactory.factory.core.constants.SuccessStatus;
import com.packagefactory.factory.core.response.ApiResponse;
import com.packagefactory.factory.core.utils.ResponseUtil;
import com.packagefactory.factory.dto.BuyItemDto;
import com.packagefactory.factory.entity.BuyItem;
import com.packagefactory.factory.entity.Stock;
import com.packagefactory.factory.exception.NotFoundException;
import com.packagefactory.factory.repository.BuyItemRepository;
import com.packagefactory.factory.repository.StockRepository;
import com.packagefactory.factory.service.BuyItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuyItemServiceImpl implements BuyItemService {
    private final BuyItemRepository repo;
    private final StockRepository stockRepository;

    public BuyItemServiceImpl(BuyItemRepository repo, StockRepository stockRepository) {
        this.repo = repo;
        this.stockRepository = stockRepository;
    }

    @Override
    public ApiResponse<BuyItemDto> create(BuyItemDto dto) {
        BuyItem item = new BuyItem();
        item.setName(dto.getName());
        item.setBuyPrice(dto.getBuyPrice());
        item.setWeight(dto.getWeight());
        item.setQuantity(dto.getQuantity());

        if (dto.getStockId() != null) {
            Stock stock = stockRepository.findById(dto.getStockId())
                    .orElseThrow(() -> new NotFoundException("Stock not found: " + dto.getStockId()));
            item.setStock(stock);
        }

        BuyItem saved = repo.save(item);
        return ResponseUtil.success(toDto(saved), SuccessStatus.ENTRY_CREATED, "BuyItem created");
    }

    @Override
    public ApiResponse<BuyItemDto> getById(Long id) {
        BuyItem item = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("BuyItem not found: " + id));
        return ResponseUtil.success(toDto(item), SuccessStatus.ENTRY_FOUND, "BuyItem found");
    }

    @Override
    public ApiResponse<List<BuyItemDto>> getAll() {
        List<BuyItem> items = repo.findAll();
        List<BuyItemDto> dtos = items.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseUtil.success(dtos, SuccessStatus.ENTRY_FOUND, "BuyItems fetched");
    }

    @Override
    public ApiResponse<BuyItemDto> update(Long id, BuyItemDto dto) {
        BuyItem existing = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("BuyItem not found: " + id));

        if (dto.getName() != null) existing.setName(dto.getName());
        if (dto.getBuyPrice() != null) existing.setBuyPrice(dto.getBuyPrice());
        if (dto.getWeight() != null) existing.setWeight(dto.getWeight());
        if (dto.getQuantity() != null) existing.setQuantity(dto.getQuantity());

        if (dto.getStockId() != null) {
            Stock stock = stockRepository.findById(dto.getStockId())
                    .orElseThrow(() -> new NotFoundException("Stock not found: " + dto.getStockId()));
            existing.setStock(stock);
        } else if (dto.getStockId() == null && existing.getStock() != null) {
            // Optional: allow clearing stock by sending stockId = null
            existing.setStock(null);
        }

        BuyItem updated = repo.save(existing);
        return ResponseUtil.success(toDto(updated), SuccessStatus.ENTRY_UPDATED, "BuyItem updated");
    }

    @Override
    public ApiResponse<Void> delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("BuyItem not found: " + id);
        }
        repo.deleteById(id);
        return ResponseUtil.success(null, SuccessStatus.ENTRY_DELETED, "BuyItem deleted");
    }

    private BuyItemDto toDto(BuyItem item) {
        BuyItemDto dto = new BuyItemDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setBuyPrice(item.getBuyPrice());
        dto.setWeight(item.getWeight());
        dto.setQuantity(item.getQuantity());
        dto.setStockId(item.getStock() != null ? item.getStock().getId() : null);
        return dto;
    }

}
