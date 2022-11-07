package com.example.storespring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductDTO {

  public List<String> buyersName;

  public List<String> buyersAddressDescription;
  public String productsDescription;
  public Double productsCount;

  private Integer productsId;
  public Double productsPrice;
  public String productsDepartmentDepName;

  @Override
  public String toString() {
    return "ProductDTO{" +
        "name='" + buyersName + '\'' +
        ", address='" + buyersAddressDescription + '\'' +
        ", product='" + productsDescription + '\'' +
        ", count=" + productsCount +
        ", price=" + productsPrice +
        ", product department='" + productsDepartmentDepName + '\'' +
        '}' + '\n';
  }
}
