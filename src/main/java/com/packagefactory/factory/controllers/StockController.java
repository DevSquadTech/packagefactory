package com.packagefactory.factory.controllers;

import com.packagefactory.factory.core.response.ApiResponse;
import com.packagefactory.factory.dto.StockDto;
import com.packagefactory.factory.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StockDto>> create(@RequestBody StockDto dto) {
        ApiResponse<StockDto> r = service.create(dto);
        return ResponseEntity.status(r.getStatusCode()).body(r);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StockDto>> getById(@PathVariable Long id) {
        ApiResponse<StockDto> r = service.getById(id);
        return ResponseEntity.status(r.getStatusCode()).body(r);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StockDto>>> getAll() {
        ApiResponse<List<StockDto>> r = service.getAll();
        return ResponseEntity.status(r.getStatusCode()).body(r);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StockDto>> update(@PathVariable Long id, @RequestBody StockDto dto) {
        ApiResponse<StockDto> r = service.update(id, dto);
        return ResponseEntity.status(r.getStatusCode()).body(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        ApiResponse<Void> r = service.delete(id);
        return ResponseEntity.status(r.getStatusCode()).body(r);
    }
    }
