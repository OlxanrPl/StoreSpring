package com.example.storespring.controller;

import com.example.storespring.domain.Address;
import com.example.storespring.dto.AddressDTO;
import com.example.storespring.repository.AddressRepository;
import com.example.storespring.service.AddressService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/address")
public class AddressController {
    private final AddressRepository repo;
    @Autowired
    private AddressService service;

    @Autowired
    public AddressController(AddressRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public List<AddressDTO> getAllAddress(){
        return service.getAllAddress();
    }
    @GetMapping(params = "recent")
    public ResponseEntity<List<Address>> allAddress() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("description").descending());
       List<Address> addressList= repo.findAll();
        for (Address adr: addressList)
              {
                  System.out.println(adr.toString());

        }

        return  ResponseEntity.ok(repo.findAll(page).getContent());
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Address postAddress(@RequestBody Address address) {
        return repo.save(address);
    }
    @GetMapping("/{id}")
    public Optional<Address> addressById(@PathVariable("id") Integer id){
       return repo.findById(id);
    }
}
