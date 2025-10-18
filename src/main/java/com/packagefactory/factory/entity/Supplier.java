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
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String address;
    private String email;

    @Column(length = 500)
    private String notes;

    @OneToMany(mappedBy = "supplier")
    private List<BuyInvoice> buyInvoices;

    @OneToMany(mappedBy = "supplier")
    private List<BuyReturnInvoice> buyReturnInvoices;
}
