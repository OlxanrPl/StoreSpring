package com.example.storespring.mappers;


import com.example.storespring.domain.Departments;
import com.example.storespring.dto.DepartmentsDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR )
public interface DepartmentsMapper {
    DepartmentsMapper DEPARTMENTS_MAPPER = Mappers.getMapper(DepartmentsMapper.class);
    DepartmentsDTO fromAddress(Departments departments);
    @InheritInverseConfiguration
    Departments toDepartments(DepartmentsDTO departmentsDTO);
}
