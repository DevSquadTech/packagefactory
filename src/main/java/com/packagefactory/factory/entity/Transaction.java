package com.packagefactory.factory.entity;

import com.packagefactory.factory.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "transaction")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "treasury_id")
    private Treasury treasury;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToOne
    @JoinColumn(name = "sales_invoice_id")
    private SalesInvoice salesInvoice;

    @OneToOne
    @JoinColumn(name = "sales_return_invoice_id")
    private SalesReturnInvoice salesReturnInvoice;

    @OneToOne
    @JoinColumn(name = "buy_invoice_id")
    private BuyInvoice buyInvoice;

    @OneToOne
    @JoinColumn(name = "buy_return_invoice_id")
    private BuyReturnInvoice buyReturnInvoice;
}
