package com.example.cqrsbanking.web.dto.mapper;

import org.mapstruct.Mapper;

import com.example.cqrsbanking.domain.model.Client;
import com.example.cqrsbanking.web.dto.ClientDto;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
    
}
