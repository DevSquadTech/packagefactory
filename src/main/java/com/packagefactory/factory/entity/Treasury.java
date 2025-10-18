package com.packagefactory.factory.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "treasury")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Treasury {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double totalbalance = 0.0;

    @OneToMany(mappedBy = "treasury", cascade = CascadeType.ALL)
    private List<PaymentMethod> paymentMethods;

    @OneToMany(mappedBy = "treasury", cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}
