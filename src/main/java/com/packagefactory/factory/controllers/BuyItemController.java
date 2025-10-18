package com.packagefactory.factory.controllers;

import com.packagefactory.factory.core.response.ApiResponse;
import com.packagefactory.factory.dto.BuyItemDto;
import com.packagefactory.factory.service.BuyItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buy-items")
public class BuyItemController {
    private final BuyItemService service;

    public BuyItemController(BuyItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BuyItemDto>> create(@RequestBody BuyItemDto dto) {
        ApiResponse<BuyItemDto> r = service.create(dto);
        return ResponseEntity.status(r.getStatusCode()).body(r);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BuyItemDto>> getById(@PathVariable Long id) {
        ApiResponse<BuyItemDto> r = service.getById(id);
        return ResponseEntity.status(r.getStatusCode()).body(r);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<BuyItemDto>>> getAll() {
        ApiResponse<List<BuyItemDto>> r = service.getAll();
        return ResponseEntity.status(r.getStatusCode()).body(r);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BuyItemDto>> update(@PathVariable Long id, @RequestBody BuyItemDto dto) {
        ApiResponse<BuyItemDto> r = service.update(id, dto);
        return ResponseEntity.status(r.getStatusCode()).body(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        ApiResponse<Void> r = service.delete(id);
        return ResponseEntity.status(r.getStatusCode()).body(r);
    }

}
