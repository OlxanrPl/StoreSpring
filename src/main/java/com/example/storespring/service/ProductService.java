package com.example.storespring.service;

import com.example.storespring.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
}
