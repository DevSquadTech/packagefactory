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
public class BuyItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;

    private Double buyPrice;

    private Double weight;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @OneToMany(mappedBy = "BuyItem")
    private List<BuyInvoiceItem> buyInvoiceItems;

    @OneToMany(mappedBy = "BuyItem")
    private List<BuyReturnItem> buyReturnItems;
}
