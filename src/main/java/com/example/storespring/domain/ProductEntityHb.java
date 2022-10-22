package com.example.storespring.domain;

import java.util.Set;

public class ProductEntityHb {
    private Integer id;
    private String description;
    private Double price;
    private Double count;
    private Set<BuyerEntityHb> buyerEntityHbs;
    private ProductDepartment productDepartment;
}
