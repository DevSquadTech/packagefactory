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
public class BuyReturnItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyreturninvoice_id")
    private BuyReturnInvoice buyReturnInvoice;

    @ManyToOne
    @JoinColumn(name = "buyitem_id")
    private BuyItem buyItem;

    private Double quantity;
    private Double unitPrice;
    private Double totalPrice;
}
