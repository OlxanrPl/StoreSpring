package com.example.storespring.controller;

import com.example.storespring.domain.Buyers;
import com.example.storespring.domain.Products;
import com.example.storespring.dto.ProductDTO;
import com.example.storespring.repository.ProductsRepository;
import com.example.storespring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/products")
public class ProductsController {
    private ProductsRepository repo;
    private ProductService productService;

    @Autowired
    public ProductsController(ProductsRepository repo, ProductService productService)
    {   this.productService = productService;
        this.repo = repo;
    }

    @GetMapping(params = "recent")
    public ResponseEntity<Iterable<ProductDTO>> allProducts() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("description").descending());
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Products postProducts(@RequestBody Products products) {
        return repo.save(products);
    }

    @GetMapping("/{id}")
    public Optional<Products> productsById(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }
}
