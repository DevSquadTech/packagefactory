package com.packagefactory.factory.service;

import com.packagefactory.factory.core.response.ApiResponse;
import com.packagefactory.factory.dto.SupplierDto;

import java.util.List;

public interface SupplierService {
    ApiResponse<SupplierDto> create(SupplierDto supplierDto);
    ApiResponse<SupplierDto> update(Long id, SupplierDto supplierDto);
    ApiResponse<SupplierDto> getById(Long id);
    ApiResponse<List<SupplierDto>> getAll();
    ApiResponse<Void> delete(Long id);
}
