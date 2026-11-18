package com.shopson.microservices.mapper;

import com.shopson.microservices.model.PersonDto;

public class PersonMapper extends DtoMapper<PersonDto> {
    private static final PersonMapper INSTANCE = new PersonMapper();

    public static PersonMapper getInstance() {
        return INSTANCE;
    }
    
    @Override
    public void initializeMappings() {
            registerSetter("firstName", PersonDto::setFirstName);
            registerSetter("lastName", PersonDto::setLastName);
            registerSetter("dateOfBirth", PersonDto::setDateOfBirth);
    }
}
