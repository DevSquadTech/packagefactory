package com.packagefactory.factory.repository;

import com.packagefactory.factory.entity.BuyItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyItemRepository extends JpaRepository<BuyItem , Long> {
}
