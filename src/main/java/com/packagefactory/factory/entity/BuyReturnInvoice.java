package com.packagefactory.factory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyReturnInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String returnNumber;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private Double totalAmount;

    @OneToMany(mappedBy = "buyReturnInvoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BuyReturnItem> buyReturnItems;
}
