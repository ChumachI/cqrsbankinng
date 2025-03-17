package com.example.core.web.dto.mapper;

import static org.mapstruct.InjectionStrategy.*;
import static org.mapstruct.MappingConstants.ComponentModel.*;

import org.mapstruct.Mapper;

import com.example.common.domain.model.Transaction;
import com.example.core.web.dto.TransactionDto;

@Mapper(
        componentModel = SPRING,
        uses = CardMapper.class,
        injectionStrategy = CONSTRUCTOR
)
public interface TransactionMapper
        extends Mappable<Transaction, TransactionDto> {
}