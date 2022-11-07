package com.example.storespring.mappers;

import com.example.storespring.domain.Address;
import com.example.storespring.dto.AddressDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR )
public interface AddressMapper {
    AddressMapper ADDRESS_MAPPER = Mappers.getMapper(AddressMapper.class);
    AddressDTO fromAddress(Address address);
    @InheritInverseConfiguration
    Address toAddress(AddressDTO addressDTO);
}
