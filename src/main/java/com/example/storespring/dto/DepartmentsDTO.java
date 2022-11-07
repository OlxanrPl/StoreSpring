package com.example.storespring.dto;

import com.example.storespring.domain.Products;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class DepartmentsDTO {
    private Integer depId;
    private String depName;
    private Set<Products> productsSet;
}
