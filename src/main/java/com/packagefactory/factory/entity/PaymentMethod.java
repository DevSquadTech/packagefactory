package com.packagefactory.factory.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "payment_method")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double balance = 0.0;

    @ManyToOne
    @JoinColumn(name = "treasury_id")
    private Treasury treasury;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
}
