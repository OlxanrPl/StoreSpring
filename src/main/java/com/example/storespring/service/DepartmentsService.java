package com.example.storespring.service;

import com.example.storespring.domain.Departments;
import com.example.storespring.dto.DepartmentsDTO;

import java.util.List;

public interface DepartmentsService {
    List<DepartmentsDTO> getAllDepartments();
    DepartmentsDTO getDepartmentsById(Integer depId);
    DepartmentsDTO addDepartments(Departments departments);
    void delDepartments(Integer depId);
}
