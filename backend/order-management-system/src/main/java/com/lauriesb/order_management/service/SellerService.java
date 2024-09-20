package com.lauriesb.order_management.service;

import com.lauriesb.order_management.dto.SellerDTO;
import com.lauriesb.order_management.entity.SellerEntity;
import com.lauriesb.order_management.repository.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

  public SellerRepository sellerRepository;

  public List<SellerDTO> listAll() {
    List<SellerEntity> sellers = sellerRepository.findAll();
    return sellers.stream().map(SellerDTO::new).toList();
  }

  public void create(SellerDTO sellers) {
    SellerEntity sellerEntity = new SellerEntity(sellers);
    sellerRepository.save(sellerEntity);
  }

  public SellerDTO update(SellerDTO sellers) {
    SellerEntity sellerEntity = new SellerEntity(sellers);
    return new SellerDTO(sellerRepository.save(sellerEntity));
  }

  public void delete(Long id) {
    SellerEntity sellerEntity = sellerRepository.findById(id).get();
    sellerRepository.delete(sellerEntity);
  }

  public SellerDTO findByID(Long id) {
    return new SellerDTO(sellerRepository.findById(id).get());
  }

}
