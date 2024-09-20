package com.lauriesb.order_management.controller;

import com.lauriesb.order_management.dto.CustomerDTO;
import com.lauriesb.order_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping
  public List<CustomerDTO> listAll() {
    return customerService.listAll();
  }

  @PostMapping
  public void create(@RequestBody CustomerDTO customer) {
    customerService.create(customer);
  }

  @PutMapping
  public CustomerDTO update(@RequestBody CustomerDTO customer) {
    return customerService.update(customer);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    customerService.delete(id);
    return ResponseEntity.ok().build();
  }

}
