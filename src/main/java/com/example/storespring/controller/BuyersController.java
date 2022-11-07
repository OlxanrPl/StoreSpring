package com.example.storespring.controller;

import com.example.storespring.domain.Address;
import com.example.storespring.domain.Buyers;
import com.example.storespring.repository.BuyersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/buyers")
public class BuyersController {
    private BuyersRepository repo;

    @Autowired
    public BuyersController(BuyersRepository repo) {
        this.repo = repo;
    }

    @GetMapping(params = "recent")
    public Iterable<Buyers> allBuyers() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("name").descending());
        return repo.findAll(page).getContent();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Buyers postBuyers(@RequestBody Buyers buyers) {
        return repo.save(buyers);
    }

    @GetMapping("/{id}")
    public Optional<Buyers> buyersById(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }
}
