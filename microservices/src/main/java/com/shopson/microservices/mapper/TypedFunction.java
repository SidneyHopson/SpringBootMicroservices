package com.shopson.microservices.mapper;

@FunctionalInterface 
public interface TypedFunction<T, U> {
    void apply(T t, U u);
}
