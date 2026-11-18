package com.shopson.microservices.mapper;

@FunctionalInterface 
public interface TypedBiConsumer<T, U> {
    void accept(T t, U u);
}
