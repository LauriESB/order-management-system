package com.lauriesb.order_management.service;

import com.lauriesb.order_management.dto.CustomerDTO;
import com.lauriesb.order_management.entity.CustomerEntity;
import com.lauriesb.order_management.entity.PersonEntity;
import com.lauriesb.order_management.exceptions.ExistingSSNException;
import com.lauriesb.order_management.exceptions.InvalidStateException;
import com.lauriesb.order_management.exceptions.PersonNotFoundException;
import com.lauriesb.order_management.exceptions.AvailableCreditException;
import com.lauriesb.order_management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
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

  public void create(CustomerDTO customer) {
    if(customer.getAvailableCredit() != null) {
      if(customer.getAvailableCredit() > customer.getCreditLimit()) {
        throw new AvailableCreditException("available credit cannot be greater than the credit limit", customer.getAvailableCredit());
      }
    }

    if (customerRepository.existsBySsn(customer.getSsn())) {
      throw new ExistingSSNException("SSN already registered", customer.getSsn());
    }

    String stateInput = customer.getState().toLowerCase();
    try {
      PersonEntity.BrazilianState state = PersonEntity.BrazilianState.valueOf(stateInput);
    } catch (IllegalArgumentException e) {
      throw new InvalidStateException("Invalid state provided", stateInput);
    }

    CustomerEntity customerEntity = new CustomerEntity(customer);
    customerRepository.save(customerEntity);
  }

  public CustomerDTO update(Long id, CustomerDTO customer) {
    CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Customer not registered", id));

    if(customer.getAvailableCredit() != null) {
      if(customer.getAvailableCredit() > customer.getCreditLimit()) {
        throw new AvailableCreditException("available credit cannot be greater than the credit limit", customer.getAvailableCredit());
      }
    }

    if (customerRepository.existsBySsn(customer.getSsn())) {
      throw new ExistingSSNException("SSN already registered", customer.getSsn());
    }

    String stateInput = customer.getState().toLowerCase();
    try {
      PersonEntity.BrazilianState state = PersonEntity.BrazilianState.valueOf(stateInput);
    } catch (IllegalArgumentException e) {
      throw new InvalidStateException("Invalid state provided", stateInput);
    }

    if(customer.getSsn() != null) {
      customerEntity.setSsn(customer.getSsn());
    }

    if(customer.getName() != null) {
      customerEntity.setName(customer.getName());
    }

    if(customer.getAddress() != null) {
      customerEntity.setAddress(customer.getAddress());
    }

    if(customer.getCity() != null) {
      customerEntity.setCity(customer.getCity());
    }

    if(customer.getState() != null) {
      customerEntity.setState(customer.getState());
    }

    if(customer.getAreaCode() != null) {
      customerEntity.setAreaCode(customer.getAreaCode());
    }

    if(customer.getPhoneNumber() != null) {
      customerEntity.setPhoneNumber(customer.getPhoneNumber());
    }

    if(customer.getPostalCode() != null) {
      customerEntity.setPostalCode(customer.getPostalCode());
    }

    if (customer.getCreditLimit() > 0) {
      Double currentCreditLimit = customerEntity.getCreditLimit();
      Double currentAvailableCredit = customerEntity.getAvailableCredit();

      Double usedCredit = currentCreditLimit - currentAvailableCredit;
      customerEntity.setCreditLimit(customer.getCreditLimit());

      if (usedCredit == null) {
        customerEntity.setAvailableCredit(customer.getCreditLimit());
      } else {
        Double newAvailableCredit = customer.getCreditLimit() - usedCredit;
        customerEntity.setAvailableCredit(newAvailableCredit);
      }
    }

    if(customer.getAvailableCredit() != null && customer.getAvailableCredit() > 0) {
        customerEntity.setAvailableCredit(customer.getAvailableCredit());
    }

    CustomerEntity updatedCustomer = customerRepository.save(customerEntity);
    return new CustomerDTO(updatedCustomer);
  }

  public void delete(Long id) {
    CustomerEntity customer = customerRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Customer not registered", id));
    customerRepository.delete(customer);
  }

  public CustomerDTO findByID(Long id) {
    return new CustomerDTO(customerRepository.findById(id).get());
  }

  public CustomerEntity findById(Long id) {
    return customerRepository.findById(id).get();
  }

}
