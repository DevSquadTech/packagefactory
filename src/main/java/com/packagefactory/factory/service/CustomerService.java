package com.packagefactory.factory.service;

import com.packagefactory.factory.core.response.ApiResponse;
import com.packagefactory.factory.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    ApiResponse<CustomerDto> create(CustomerDto customerDto);
    ApiResponse<CustomerDto> update(Long id, CustomerDto customerDto);
    ApiResponse<CustomerDto> delete(Long id);
    ApiResponse<CustomerDto> getById(Long id);
    ApiResponse<List<CustomerDto>> getAll();
}

