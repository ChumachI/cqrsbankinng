package com.example.core.web.dto.mapper;

import org.mapstruct.Mapper;

import com.example.common.domain.model.Account;
import com.example.core.web.dto.AccountDto;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
    
}
