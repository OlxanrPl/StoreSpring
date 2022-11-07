package com.example.storespring.repository;

import com.example.storespring.domain.Address;
import com.example.storespring.domain.Buyers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
