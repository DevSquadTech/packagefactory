package com.packagefactory.factory.controllers;

import com.packagefactory.factory.core.response.ApiResponse;
import com.packagefactory.factory.dto.SupplierDto;
import com.packagefactory.factory.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private final SupplierService service;
    public SupplierController(SupplierService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<ApiResponse<SupplierDto>> create(@RequestBody SupplierDto dto) {
        ApiResponse<SupplierDto> resp = service.create(dto);
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SupplierDto>> getById(@PathVariable Long id) {
        ApiResponse<SupplierDto> resp = service.getById(id);
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SupplierDto>>> getAll() {
        ApiResponse<List<SupplierDto>> resp = service.getAll();
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SupplierDto>> update(@PathVariable Long id, @RequestBody SupplierDto dto) {
        ApiResponse<SupplierDto> resp = service.update(id, dto);
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        ApiResponse<Void> resp = service.delete(id);
        return ResponseEntity.status(resp.getStatusCode()).body(resp);
    }

}
