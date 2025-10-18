package com.packagefactory.factory.service.impl;

import com.packagefactory.factory.core.constants.SuccessStatus;
import com.packagefactory.factory.core.response.ApiResponse;
import com.packagefactory.factory.core.utils.ResponseUtil;
import com.packagefactory.factory.dto.SupplierDto;
import com.packagefactory.factory.entity.Supplier;
import com.packagefactory.factory.exception.NotFoundException;
import com.packagefactory.factory.repository.SupplierRepository;
import com.packagefactory.factory.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public ApiResponse<SupplierDto> create(SupplierDto supplierDto) {
        Supplier supplier = toEntity(supplierDto);
        Supplier saved = supplierRepository.save(supplier);
        SupplierDto savedDto = toDto(saved);
        return ResponseUtil.success(savedDto, SuccessStatus.ENTRY_CREATED, "Supplier created");    }

    @Override
    public ApiResponse<SupplierDto> update(Long id, SupplierDto dto) {
        Supplier existing = supplierRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier not found: " + id));
        updateEntity(existing, dto);
        Supplier updated = supplierRepository.save(existing);
        SupplierDto updatedDto = toDto(updated);
        return ResponseUtil.success(updatedDto, SuccessStatus.ENTRY_UPDATED, "Supplier updated");
    }

    @Override
    public ApiResponse<SupplierDto> getById(Long id) {
        Supplier s = supplierRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier not found: " + id));
        SupplierDto dto = toDto(s);
        return ResponseUtil.success(dto, SuccessStatus.ENTRY_FOUND, "Supplier found");    }

    @Override
    public ApiResponse<List<SupplierDto>> getAll() {
        List<Supplier> list = supplierRepository.findAll();
        List<SupplierDto> dtos = list.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseUtil.success(dtos, SuccessStatus.ENTRY_FOUND, "Suppliers fetched");
    }

    @Override
    public ApiResponse<Void> delete(Long id) {
        if (!supplierRepository.existsById(id)) {
            throw new NotFoundException("Supplier not found: " + id);
        }
        supplierRepository.deleteById(id);
        return ResponseUtil.success(null, SuccessStatus.ENTRY_DELETED, "Supplier deleted");
    }

    private SupplierDto toDto(Supplier supplier) {
        SupplierDto dto = new SupplierDto();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setPhone(supplier.getPhone());
        dto.setAddress(supplier.getAddress());
        dto.setEmail(supplier.getEmail());
        dto.setNotes(supplier.getNotes());
        dto.setBalance(supplier.getBalance());
        return dto;
    }

    private Supplier toEntity(SupplierDto dto){
        Supplier s = new Supplier();
        s.setName(dto.getName());
        s.setPhone(dto.getPhone());
        s.setAddress(dto.getAddress());
        s.setEmail(dto.getEmail());
        s.setNotes(dto.getNotes());
        s.setBalance(dto.getBalance() != null ? dto.getBalance() : 0.0);
        return s;
    }

    private void updateEntity(Supplier s, SupplierDto dto){
        if(dto.getName() != null) s.setName(dto.getName());
        if(dto.getPhone() != null) s.setPhone(dto.getPhone());
        if(dto.getAddress() != null) s.setAddress(dto.getAddress());
        if(dto.getEmail() != null) s.setEmail(dto.getEmail());
        if(dto.getNotes() != null) s.setNotes(dto.getNotes());
        if(dto.getBalance() != null) s.setBalance(dto.getBalance());
    }
}
