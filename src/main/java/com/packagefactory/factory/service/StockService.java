package com.packagefactory.factory.service;

import com.packagefactory.factory.core.response.ApiResponse;
import com.packagefactory.factory.dto.StockDto;

import java.util.List;

public interface StockService {
    ApiResponse<StockDto> create(StockDto dto);
    ApiResponse<StockDto> getById(Long id);
    ApiResponse<List<StockDto>> getAll();
    ApiResponse<StockDto> update(Long id, StockDto dto);
    ApiResponse<Void> delete(Long id);
}
