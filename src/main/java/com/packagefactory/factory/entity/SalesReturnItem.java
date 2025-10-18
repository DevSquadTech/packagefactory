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
public class SalesReturnItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "return_invoice_id")
    private SalesReturnInvoice salesReturnInvoice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private SaleProduct saleProduct;

    private Double quantity;
    private Double unitPrice;
    private Double totalPrice;
}
