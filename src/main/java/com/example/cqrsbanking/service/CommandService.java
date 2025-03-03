package com.example.cqrsbanking.service;

public interface CommandService<T> {
    void create(T object);
}
