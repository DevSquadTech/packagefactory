package com.packagefactory.factory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesInvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private SalesInvoice salesInvoice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private SaleProduct saleProduct;

    private Double quantity;
    private Double unitPrice;
    private Double totalPrice;
}
