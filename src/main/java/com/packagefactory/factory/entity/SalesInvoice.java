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
public class SalesInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNumber;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Double totalPrice;
    private Double discount;
    private Double netTotal;

    @OneToMany(mappedBy = "salesInvoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalesInvoiceItem> items;
}
