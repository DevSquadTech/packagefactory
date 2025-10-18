package com.packagefactory.factory.dto;


import com.packagefactory.factory.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private Long id;
    private LocalDateTime dateTime;
    private TransactionType type;
    private Double amount;
    private Long paymentMethodId;
    private Long treasuryId;
    private Long customerId;
    private Long supplierId;
    private Long salesInvoiceId;
    private Long salesReturnInvoiceId;
    private Long buyInvoiceId;
    private Long buyReturnInvoiceId;
}
