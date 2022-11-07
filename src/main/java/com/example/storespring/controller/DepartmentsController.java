package com.example.storespring.controller;

import com.example.storespring.domain.Departments;
import com.example.storespring.dto.DepartmentsDTO;
import com.example.storespring.repository.DepartmentsRepository;
import com.example.storespring.service.AddressService;
import com.example.storespring.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/departments")

public class DepartmentsController {
    @Autowired
    private DepartmentsService service;
    private DepartmentsRepository repo;
@Autowired
    public DepartmentsController(DepartmentsRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public List<DepartmentsDTO> getAllDepartments(){
        return service.getAllDepartments();
    }
    @GetMapping(params = "recent")
    public Iterable<Departments> allDepartments() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("description").descending());
        return repo.findAll(page).getContent();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Departments postDepartments(@RequestBody Departments departments) {
        return repo.save(departments);
    }

    @GetMapping("/{id}")
    public Optional<Departments> departmentsById(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }
}
