package com.lauriesb.order_management.service;

import com.lauriesb.order_management.dto.CustomerDTO;
import com.lauriesb.order_management.dto.OrdersDTO;
import com.lauriesb.order_management.entity.CustomerEntity;
import com.lauriesb.order_management.entity.OrdersEntity;
import com.lauriesb.order_management.repository.OrdersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

  @Autowired
  public OrdersRepository ordersRepository;

  public List<OrdersDTO> listAll() {
    List<OrdersEntity> orders = ordersRepository.findAll();
    return orders.stream().map(OrdersDTO::new).toList();
  }

  public void create(OrdersDTO orders) {
    OrdersEntity ordersEntity = new OrdersEntity(orders);
    ordersRepository.save(ordersEntity);
  }

  public OrdersDTO update(OrdersDTO orders) {
    OrdersEntity ordersEntity = new OrdersEntity(orders);
    return new OrdersDTO(ordersRepository.save(ordersEntity));
  }

  public void delete(Long id) {
    OrdersEntity ordersEntity = ordersRepository.findById(id).get();
    ordersRepository.delete(ordersEntity);
  }

  public OrdersDTO findByID(Long id) {
    return new OrdersDTO(ordersRepository.findById(id).get());
  }

}
