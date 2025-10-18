package com.packagefactory.factory.controllers;

import com.packagefactory.factory.core.response.ApiResponse;
import com.packagefactory.factory.dto.CustomerDto;
import com.packagefactory.factory.entity.Customer;
import com.packagefactory.factory.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CustomerDto>> create(@RequestBody CustomerDto customerDto) {
        ApiResponse<CustomerDto> resp = customerService.create(customerDto);
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerDto>> getById(@PathVariable Long id) {
        ApiResponse<CustomerDto> resp = customerService.getById(id);
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerDto>>> getAll() {
        ApiResponse<List<CustomerDto>> resp = customerService.getAll();
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerDto>> update(@PathVariable Long id, @RequestBody CustomerDto dto) {
        ApiResponse<CustomerDto> resp = customerService.update(id, dto);
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerDto>> delete(@PathVariable Long id) {
        ApiResponse<CustomerDto> resp = customerService.delete(id);
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }
}
