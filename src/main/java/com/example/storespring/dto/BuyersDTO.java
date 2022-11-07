package com.example.storespring.dto;

import com.example.storespring.domain.Products;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class BuyersDTO {
    private Integer id;
    private String name;
    private Set<ProductDTO> productsSet;

}
