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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;

    private String phone;

    private String address;

    private String email;

    @Column(length = 500)
    private String notes;

    @OneToMany(mappedBy = "customer")
    private List<SalesInvoice> salesInvoices;

    @OneToMany(mappedBy = "customer")
    private List<SalesReturnInvoice> salesReturnInvoices;
}
