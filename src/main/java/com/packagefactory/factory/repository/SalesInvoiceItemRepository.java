package com.packagefactory.factory.repository;

import com.packagefactory.factory.entity.SalesInvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesInvoiceItemRepository extends JpaRepository<SalesInvoiceItem,Long> {
}
