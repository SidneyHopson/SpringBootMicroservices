package com.shopson.microservices.mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import com.shopson.microservices.model.MappableDto;

public class DtoMapper <T extends MappableDto>{
    private Map<String, TypedBiConsumer<T, Object>> setterMap = new HashMap<>();

    public DtoMapper() {
        initializeMappings();
    }

    public void initializeMappings() {}

    @SuppressWarnings("unchecked")
    public <U> void registerSetter(String fieldName, BiConsumer<T, U> setter) {
        setterMap.put(fieldName, (dto, value) -> setter.accept(dto, (U)value));
    }

    public <U> void setValue(T dto, String fieldName, U value) {
        setterMap.get(fieldName).accept(dto, value);
    }

    public void populateDto(T dto, Map<String, Object> rowData) {
        for (Map.Entry<String, Object> entry : rowData.entrySet()) {
            setValue(dto, entry.getKey(), entry.getValue());
        }
    }
}
