package com.example.cqrsbanking.web.dto.mapper;

import org.mapstruct.Mapper;

import com.example.cqrsbanking.domain.model.Account;
import com.example.cqrsbanking.web.dto.AccountDto;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
    
}
