package com.packagefactory.factory.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNumber;
    private LocalDateTime dateTime;

    private Double totalPrice;
    private Double discount;
    private Double additionalCharges;
    private Double netTotal;

    @OneToMany(mappedBy = "BuyInvoice",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<BuyInvoiceItem> buyInvoiceItems;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToOne(mappedBy = "buyInvoice", cascade = CascadeType.ALL)
    private Transaction transaction;
}
