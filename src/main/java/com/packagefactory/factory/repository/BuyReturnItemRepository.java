package com.packagefactory.factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyReturnItemRepository extends JpaRepository<BuyReturnItemRepository,Long> {
}
