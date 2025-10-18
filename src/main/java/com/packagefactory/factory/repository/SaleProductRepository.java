package com.packagefactory.factory.repository;

import com.packagefactory.factory.entity.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct,Long> {
}
