package com.example.storespring.service;

import com.example.storespring.domain.Address;
import com.example.storespring.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    List<AddressDTO> getAllAddress();
    AddressDTO getAddressById(Integer id);
    AddressDTO addAddress(Address address);
    void delAddress(Integer id);
}
