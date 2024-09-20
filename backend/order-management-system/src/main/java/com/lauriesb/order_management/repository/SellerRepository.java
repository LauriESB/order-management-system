package com.lauriesb.order_management.repository;

import com.lauriesb.order_management.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerEntity, Long> {

}
