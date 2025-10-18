package com.packagefactory.factory.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyInvoiceItemDto {

    private Long id;
    private Long buyItemId;
    private Double quantity;
    private Double unitPrice;
    private Double totalPrice;
}
