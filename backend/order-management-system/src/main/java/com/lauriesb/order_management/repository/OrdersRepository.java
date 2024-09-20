package com.lauriesb.order_management.repository;

import com.lauriesb.order_management.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {

}
