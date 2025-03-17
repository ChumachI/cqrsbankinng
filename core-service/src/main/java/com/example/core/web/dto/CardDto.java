package com.example.core.web.dto;

import java.util.UUID;

import com.example.core.web.dto.mapper.OnTransactionFrom;
import com.example.core.web.dto.mapper.OnTransactionTo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {

    @NotNull(
        message = "Id must be not null.",
        groups = OnUpdate.class
    )
    @Null(
        message = "Id must be null.",
        groups = OnCreate.class
    )
    private UUID id;

    @Null(
        message = "Card number must be null.",
        groups = {
            OnCreate.class,
            OnTransactionFrom.class,
            OnTransactionTo.class
        }
    )
    private String number;

    @NotBlank(
        message = "Card date must be not empty.",
        groups = {OnCreate.class, OnTransactionFrom.class}
    )
    private String date;

    @NotBlank(
        message = "Card cvv must be not empty.",
        groups = {OnCreate.class, OnTransactionFrom.class}
    )
    @Null(
        message = "Card cvv must be null.",
        groups = OnTransactionTo.class
    )
    private String cvv;
}
