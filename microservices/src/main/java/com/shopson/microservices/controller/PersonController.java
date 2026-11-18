package com.shopson.microservices.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopson.microservices.mapper.PersonMapper;
import com.shopson.microservices.model.PersonDto;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2 
@RequestMapping("/person")
public class PersonController {

     @GetMapping
    public ResponseEntity<List<PersonDto>> getPersons() {
        // TODO: Implement logic to retrieve persons from the database
        List<Map<String, Object>> rowData = List.of(
            Map.of("firstName", "John", "lastName", "Doe", "dateOfBirth", LocalDate.of(1980, 1, 1)),
            Map.of("firstName", "Jane", "lastName", "Smith", "dateOfBirth", LocalDate.of(1990, 5, 15))
        );
        List<PersonDto> persons = rowData.stream()
            .map(data -> {
                PersonDto person = new PersonDto();
                PersonMapper.getInstance().populateDto(person, data);
                return person;
            })
            .toList();

        return ResponseEntity.ok(persons);
    }
    
}
