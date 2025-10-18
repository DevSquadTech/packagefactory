package com.packagefactory.factory.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesReturnItemDto {
    private Long id;
    private Long saleProductId;
    private Double quantity;
    private Double unitPrice;
    private Double totalPrice;
}
