package com.packagefactory.factory.service;

import com.packagefactory.factory.core.response.ApiResponse;
import com.packagefactory.factory.dto.BuyItemDto;

import java.util.List;

public interface BuyItemService {
    ApiResponse<BuyItemDto> create(BuyItemDto dto);
    ApiResponse<BuyItemDto> getById(Long id);
    ApiResponse<List<BuyItemDto>> getAll();
    ApiResponse<BuyItemDto> update(Long id, BuyItemDto dto);
    ApiResponse<Void> delete(Long id);
}
