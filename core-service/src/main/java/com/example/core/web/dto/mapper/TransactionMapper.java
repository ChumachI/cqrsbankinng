package com.example.core.web.dto.mapper;

import org.mapstruct.Mapper;

import com.example.common.domain.model.Transaction;
import com.example.core.web.dto.TransactionDto;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto>{
    
}
