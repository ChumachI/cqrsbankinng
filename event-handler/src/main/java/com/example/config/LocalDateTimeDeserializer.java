package com.example.config;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import lombok.SneakyThrows;

@Component
public class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {

    @Override
    @SneakyThrows
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context){
        return LocalDateTime.ofInstant(
            Instant.ofEpochMilli(json.getAsLong()/1000),
            TimeZone.getDefault().toZoneId()
        );
    }
    
}
