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
public class SalesInvoiceDto {
    private Long id;
    private String invoiceNumber;
    private LocalDateTime dateTime;
    private Long customerId;
    private Double totalPrice;
    private Double discount;
    private Double netTotal;
    private List<SalesInvoiceItemDto> items;
}
