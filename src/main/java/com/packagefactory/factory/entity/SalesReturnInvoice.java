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
public class SalesReturnInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String returnNumber;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Double totalAmount;

    @OneToMany(mappedBy = "salesReturnInvoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalesReturnItem> items;
}
