package com.lauriesb.order_management.controller;

import com.lauriesb.order_management.dto.OrdersDTO;
import com.lauriesb.order_management.service.CustomerService;
import com.lauriesb.order_management.service.OrdersService;
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

  @PostMapping
  public void create(@RequestBody OrdersDTO orders) {
    ordersService.create(orders);
  }

  @PutMapping
  public OrdersDTO update(@RequestBody OrdersDTO orders) {
    return ordersService.update(orders);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    ordersService.delete(id);
    return ResponseEntity.ok().build();
  }

}
