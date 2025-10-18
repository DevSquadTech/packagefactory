package com.packagefactory.factory.dto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesReturnInvoiceDto {
    private Long id;
    private String returnNumber;
    private LocalDateTime dateTime;
    private Long customerId;
    private Double totalAmount;
    private List<SalesReturnItemDto> items;
}