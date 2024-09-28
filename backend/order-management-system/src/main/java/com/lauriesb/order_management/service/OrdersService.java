package com.lauriesb.order_management.service;

import com.lauriesb.order_management.dto.CustomerDTO;
import com.lauriesb.order_management.dto.OrdersDTO;
import com.lauriesb.order_management.entity.CustomerEntity;
import com.lauriesb.order_management.entity.OrdersEntity;
import com.lauriesb.order_management.entity.SellerEntity;
import com.lauriesb.order_management.repository.OrdersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

  @Autowired
  public OrdersRepository ordersRepository;

  @Autowired
  private CustomerService customerService;

  @Autowired
  private SellerService sellerService;

  public List<OrdersDTO> listAll() {
    List<OrdersEntity> orders = ordersRepository.findAll();
    return orders.stream().map(OrdersDTO::new).toList();
  }

  public void create(OrdersEntity orders) {
    ordersRepository.save(orders);
  }

  public OrdersDTO update(Long id, OrdersDTO orders) {
    OrdersEntity ordersEntity = ordersRepository.findById(id).get();

    if(orders.getIssueDate() != null) {
      ordersEntity.setIssueDate(orders.getIssueDate());
    }

    if(orders.getOrderValue() > 0) {
      ordersEntity.setOrderValue(orders.getOrderValue());
    }

    if(orders.getCustomerId() != null) {
      CustomerEntity customer = customerService.findById(orders.getCustomerId());
      ordersEntity.setCustomer(customer);
    }

    if(orders.getSellerId() != null) {
      SellerEntity seller = sellerService.findById(orders.getSellerId());
      ordersEntity.setSeller(seller);
    }
    
    OrdersEntity updatedOrder = ordersRepository.save(ordersEntity);

    return new OrdersDTO(updatedOrder);
  }

  public void delete(Long id) {
    OrdersEntity ordersEntity = ordersRepository.findById(id).get();
    CustomerEntity customer = ordersEntity.getCustomer();
    SellerEntity seller = ordersEntity.getSeller();

    customer.removeCustomerOrders(ordersEntity);
    seller.removeSellerOrder(ordersEntity);

    ordersRepository.delete(ordersEntity);
  }

  public OrdersDTO findByID(Long id) {
    return new OrdersDTO(ordersRepository.findById(id).get());
  }

  public OrdersEntity findById(Long id) {
    return ordersRepository.findById(id).get();
  }


}
