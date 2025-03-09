package com.example.core.web.dto.mapper;

import org.mapstruct.Mapper;

import com.example.common.domain.model.Client;
import com.example.core.web.dto.ClientDto;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
    
}
