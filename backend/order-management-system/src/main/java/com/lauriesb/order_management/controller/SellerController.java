package com.lauriesb.order_management.controller;

import com.lauriesb.order_management.dto.SellerDTO;
import com.lauriesb.order_management.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/seller")
public class SellerController {

  @Autowired
  private SellerService sellerService;

  @GetMapping
  public List<SellerDTO> listAll() {
    return sellerService.listAll();
  }

  @PostMapping
  public void create(@RequestBody SellerDTO seller) {
    sellerService.create(seller);
  }

  @PutMapping("/{id}")
  public SellerDTO update(@PathVariable("id") Long id, @RequestBody SellerDTO seller) {
    return sellerService.update(id, seller);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    sellerService.delete(id);
    return ResponseEntity.ok().build();
  }

}
