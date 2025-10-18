package com.packagefactory.factory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleProductDto {
    private Long id;
    private String name;
    private String category;
    private Double price;
    private String unit;
}
