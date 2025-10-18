package com.packagefactory.factory.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyReturnInvoiceDto {
    private Long id;
    private String returnNumber;
    private LocalDateTime dateTime;
    private Long supplierId;
    private Double totalAmount;
    private List<BuyReturnItemDto> items;
}
