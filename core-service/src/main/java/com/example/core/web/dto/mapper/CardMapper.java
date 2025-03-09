package com.example.core.web.dto.mapper;

import org.mapstruct.Mapper;

import com.example.common.domain.model.Card;
import com.example.core.web.dto.CardDto;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
    
}
