package com.packagefactory.factory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyReturnItemDto {
    private Long id;
    private Long buyItemId;
    private Double quantity;
    private Double unitPrice;
    private Double totalPrice;
}
