package com.example.storespring.service.impl;

import com.example.storespring.domain.Address;
import com.example.storespring.dto.AddressDTO;
import com.example.storespring.mappers.AddressMapper;
import com.example.storespring.repository.AddressRepository;
import com.example.storespring.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("addressservice")
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository repository;

    @Override
    public List<AddressDTO> getAllAddress() {
        List<AddressDTO> addressDTOList = new ArrayList<>();
        List<Address> addressList = repository.findAll();
        for (Address address : addressList) {
            addressDTOList.add(AddressMapper.ADDRESS_MAPPER.fromAddress(address));
        }
        return addressDTOList;
    }

    @Override
    public AddressDTO getAddressById(Integer id) {
        return null;
    }

    @Override
    public AddressDTO addAddress(Address address) {
        return null;
    }

    @Override
    public void delAddress(Integer id) {

    }
}
