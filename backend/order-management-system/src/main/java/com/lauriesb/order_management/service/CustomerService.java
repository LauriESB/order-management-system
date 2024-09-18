package com.lauriesb.order_management.service;

import com.lauriesb.order_management.dto.CustomerDTO;
import com.lauriesb.order_management.entity.CustomerEntity;
import com.lauriesb.order_management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

  @Autowired
  public CustomerRepository customerRepository;

  // crud op(service) : go to repository and manage CRUD data - return into DTO

  public List<CustomerDTO> listAll() {
    List<CustomerEntity> customers = customerRepository.findAll();
    return customers.stream().map(CustomerDTO::new).toList();
  }

  public void insert(CustomerDTO customer) {
    CustomerEntity customerEntity = new CustomerEntity(customer);
    customerRepository.save(customerEntity);
  }

  public CustomerDTO update(CustomerDTO customer) {
    CustomerEntity customerEntity = new CustomerEntity(customer);
    return new CustomerDTO(customerRepository.save(customerEntity));
  }

  public void delete(Long id) {
    CustomerEntity customer = customerRepository.findById(id).get();
    customerRepository.delete(customer);
  }

  public CustomerDTO findByID(Long id) {
    return new CustomerDTO(customerRepository.findById(id).get());
  }

}
