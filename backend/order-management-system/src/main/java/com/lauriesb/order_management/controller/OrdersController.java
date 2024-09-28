package com.lauriesb.order_management.controller;

import com.lauriesb.order_management.dto.CustomerDTO;
import com.lauriesb.order_management.dto.OrdersDTO;
import com.lauriesb.order_management.entity.CustomerEntity;
import com.lauriesb.order_management.entity.OrdersEntity;
import com.lauriesb.order_management.entity.SellerEntity;
import com.lauriesb.order_management.service.CustomerService;
import com.lauriesb.order_management.service.OrdersService;
import com.lauriesb.order_management.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {

  @Autowired
  private OrdersService ordersService;


  @GetMapping
  public List<OrdersDTO> listAll() {
    return ordersService.listAll();
  }

  @Autowired
  private CustomerService customerService;

  @Autowired
  private SellerService sellerService;


  @PostMapping
  public ResponseEntity<Void> create(@RequestBody OrdersDTO orders) {
    CustomerEntity customer = customerService.findById(orders.getCustomerId());
    SellerEntity seller = sellerService.findById(orders.getSellerId());


    if (customer == null || seller == null) {
      return ResponseEntity.notFound().build();
    }

    OrdersEntity order = new OrdersEntity();
    order.setCustomer(customer);
    order.setSeller(seller);
    order.setOrderValue(orders.getOrderValue());
    order.setIssueDate(orders.getIssueDate());

    customer.addCustomerOrders(order);
    seller.addSellerOrder(order);

    ordersService.create(order);

    return ResponseEntity.ok().build();

  }

  @PutMapping("/{id}")
  public OrdersDTO update(@PathVariable("id") Long id, @RequestBody OrdersDTO orders) {
    return ordersService.update(id, orders);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    OrdersEntity order = ordersService.findById(id);

    if (order == null) {
      return ResponseEntity.notFound().build();
    }

    ordersService.delete(id);
    return ResponseEntity.ok().build();
  }

}
