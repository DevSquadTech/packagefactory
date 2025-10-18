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
public class BuyInvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private BuyInvoice buyInvoice;

    @ManyToOne
    @JoinColumn(name = "buyitem_id")
    private BuyItem buyItem;

    private Double quantity;
    private Double unitPrice;
    private Double totalPrice;

}
