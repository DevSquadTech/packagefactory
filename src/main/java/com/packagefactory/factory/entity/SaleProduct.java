package com.packagefactory.factory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private Double price;
    private String unit;

    @OneToMany(mappedBy = "saleProduct")
    private List<SalesInvoiceItem> salesInvoiceItems;

    @OneToMany(mappedBy = "saleProduct")
    private List<SalesReturnItem> salesReturnItems;
}
