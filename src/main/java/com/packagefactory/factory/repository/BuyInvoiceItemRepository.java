package com.packagefactory.factory.repository;

import com.packagefactory.factory.entity.BuyInvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BuyInvoiceItemRepository extends JpaRepository<BuyInvoiceItem,Long> {
}
