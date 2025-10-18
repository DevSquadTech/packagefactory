package com.packagefactory.factory.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyItemDto {

    private Long id;
    private String name;
    private Double buyPrice;
    private Double weight;
    private Double quantity;
    private Long stockId;
}
