package com.shopson.microservices.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PersonDto implements MappableDto {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    
}
