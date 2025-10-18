package com.packagefactory.factory.repository;

import com.packagefactory.factory.entity.SalesReturnItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesReturnItemRepository extends JpaRepository<SalesReturnItem,Long> {
}
