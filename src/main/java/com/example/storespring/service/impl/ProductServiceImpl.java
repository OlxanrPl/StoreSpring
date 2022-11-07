package com.example.storespring.service.impl;

import com.example.storespring.domain.Address;
import com.example.storespring.domain.Buyers;
import com.example.storespring.dto.ProductDTO;
import com.example.storespring.repository.AddressRepository;
import com.example.storespring.repository.ProductsRepository;
import com.example.storespring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductsRepository productsRepository;
    private AddressRepository addressRepository;

    @Autowired
    public ProductServiceImpl(ProductsRepository productsRepository, AddressRepository addressRepository) {
        this.productsRepository = productsRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<ProductDTO> findAll() {

        Map<Integer, String> addressNameByBuyerId = addressRepository.findAll().stream().collect(Collectors
                .toMap(address -> address.getBuyers().getId(), Address::getDescription));

        return productsRepository.findAll().stream().map(entity -> {

            Set<Buyers> buyers = entity.getBuyers();
            List<String> buyerAddresses = buyers.stream().map(buyer -> addressNameByBuyerId.get(buyer.getId())).collect(Collectors.toList());

            List<String> buyersName = buyers.stream().map(Buyers::getName).collect(Collectors.toList());

            return new ProductDTO(buyersName, buyerAddresses, entity.getDescription(), entity.getCount(),
                    entity.getId(), entity.getPrice(), entity.getDepartments().getDepName());
        }).collect(Collectors.toList());
    }

}
