package com.example.cqrsbanking.web.dto.mapper;

import org.mapstruct.Mapper;

import com.example.cqrsbanking.domain.model.Card;
import com.example.cqrsbanking.web.dto.CardDto;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
    
}
