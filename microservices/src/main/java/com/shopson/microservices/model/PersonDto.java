package com.shopson.microservices.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class PersonDto implements MappableDto {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    
}
