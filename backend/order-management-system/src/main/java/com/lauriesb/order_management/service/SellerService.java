package com.lauriesb.order_management.service;

import com.lauriesb.order_management.dto.SellerDTO;
import com.lauriesb.order_management.entity.PersonEntity;
import com.lauriesb.order_management.entity.SellerEntity;
import com.lauriesb.order_management.exceptions.ExistingSSNException;
import com.lauriesb.order_management.exceptions.InvalidStateException;
import com.lauriesb.order_management.exceptions.PersonNotFoundException;
import com.lauriesb.order_management.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;

@Service
public class SellerService {

  @Autowired
  public SellerRepository sellerRepository;

  public List<SellerDTO> listAll() {
    List<SellerEntity> sellers = sellerRepository.findAll();
    return sellers.stream().map(SellerDTO::new).toList();
  }

  public void create(SellerDTO sellers) {
    if (sellerRepository.existsBySsn(sellers.getSsn())) {
      throw new ExistingSSNException("SSN already registered", sellers.getSsn());
    }

    String stateInput = sellers.getState().toLowerCase();
    try {
      PersonEntity.BrazilianState state = PersonEntity.BrazilianState.valueOf(stateInput);
    } catch (IllegalArgumentException e) {
      throw new InvalidStateException("Invalid state provided", stateInput);
    }

    SellerEntity sellerEntity = new SellerEntity(sellers);
    sellerRepository.save(sellerEntity);
  }

  public SellerDTO update(Long id, SellerDTO seller) {
    SellerEntity sellerEntity = sellerRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Seller not registered", id));

    String stateInput = seller.getState().toLowerCase();
    try {
      PersonEntity.BrazilianState state = PersonEntity.BrazilianState.valueOf(stateInput);
    } catch (IllegalArgumentException e) {
      throw new InvalidStateException("Invalid state provided", stateInput);
    }

    if(seller.getSsn() != null) {
      sellerEntity.setSsn(seller.getSsn());
    }

    if(seller.getName() != null) {
      sellerEntity.setName(seller.getName());
    }

    if(seller.getAddress() != null) {
      sellerEntity.setAddress(seller.getAddress());
    }

    if(seller.getCity() != null) {
      sellerEntity.setCity(seller.getCity());
    }

    if(seller.getState() != null) {
      sellerEntity.setState(seller.getState());
    }

    if(seller.getAreaCode() != null) {
      sellerEntity.setAreaCode(seller.getAreaCode());
    }

    if(seller.getPhoneNumber() != null) {
      sellerEntity.setPhoneNumber(seller.getPhoneNumber());
    }

    if(seller.getPostalCode() != null) {
      sellerEntity.setPostalCode(seller.getPostalCode());
    }

    if(seller.getBaseSalary() > 0) {
      sellerEntity.setBaseSalary(seller.getBaseSalary());
    }

    if(seller.getCommissionRate() > 0) {
      sellerEntity.setCommissionRate(seller.getCommissionRate());
    }

    SellerEntity updatedSeller = sellerRepository.save(sellerEntity);
    return new SellerDTO(updatedSeller);
  }

  public void delete(Long id) {
    SellerEntity sellerEntity = sellerRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Seller not registered", id));
    sellerRepository.delete(sellerEntity);
  }

  public SellerDTO findByID(Long id) {
    return new SellerDTO(sellerRepository.findById(id).get());
  }

  public SellerEntity findById(Long id) {
    return sellerRepository.findById(id).get();
  }

}
