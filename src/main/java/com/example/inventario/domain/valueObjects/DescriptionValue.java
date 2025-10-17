package com.example.inventario.domain.valueObjects;

public class DescriptionValue {
    private String value;

    public DescriptionValue(String value) {
        // La descripción puede ser opcional, así que no validamos null o vacío
        if (value != null && value.length() > 500) {
            throw new IllegalArgumentException("La descripción no puede ser mayor a 500 caracteres");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}