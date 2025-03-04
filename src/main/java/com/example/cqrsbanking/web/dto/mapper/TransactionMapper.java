package com.example.cqrsbanking.web.dto.mapper;

import org.mapstruct.Mapper;

import com.example.cqrsbanking.domain.model.Transaction;
import com.example.cqrsbanking.web.dto.TransactionDto;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto>{
    
}
