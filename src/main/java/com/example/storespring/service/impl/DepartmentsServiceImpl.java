package com.example.storespring.service.impl;

import com.example.storespring.domain.Address;
import com.example.storespring.domain.Departments;
import com.example.storespring.dto.AddressDTO;
import com.example.storespring.dto.DepartmentsDTO;
import com.example.storespring.mappers.AddressMapper;
import com.example.storespring.mappers.DepartmentsMapper;
import com.example.storespring.repository.DepartmentsRepository;
import com.example.storespring.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("departmensservice")
public class DepartmentsServiceImpl implements DepartmentsService {
    @Autowired
    DepartmentsRepository departmentsRepository;
    @Override
    public List<DepartmentsDTO> getAllDepartments() {
        List<DepartmentsDTO> departmentsDTOList = new ArrayList<>();
        List<Departments> departmentsList = departmentsRepository.findAll();
        for (Departments departmentsl : departmentsList) {
            departmentsDTOList.add(DepartmentsMapper.DEPARTMENTS_MAPPER.
                    fromAddress(departmentsl));

        }
        return departmentsDTOList;
    }

    @Override
    public DepartmentsDTO getDepartmentsById(Integer depId) {
        return null;
    }

    @Override
    public DepartmentsDTO addDepartments(Departments departments) {
        return null;
    }

    @Override
    public void delDepartments(Integer depId) {

    }
}
