package com.example.storespring.dto;

import com.example.storespring.domain.Buyers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AddressDTO {
    private Integer id;
    private BuyersDTO buyers;
    private String description;
}
