package com.example.cqrsbanking.web.dto;

import java.util.UUID;

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

    @NotBlank(
        message = "Card number must be not empty.",
        groups = OnCreate.class
    )
    @Null(
        message = "Card number must be null."
    )
    private String number;

    @NotBlank(
        message = "Card date must be not empty.",
        groups = OnCreate.class
    )
    @Null(
        message = "Card date must be null."
    )
    private String date;

    @NotBlank(
        message = "Card cvv must be not empty.",
        groups = OnCreate.class
    )
    @Null(
        message = "Card cvv must be null."
    )
    private String cvv;
}
