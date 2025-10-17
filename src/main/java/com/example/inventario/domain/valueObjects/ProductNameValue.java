package com.example.inventario.domain.valueObjects;

public class ProductNameValue {
    private String value;

    public ProductNameValue(String value) {
        if(value == null || value.isEmpty()){
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (value.length() > 100) {
            throw new IllegalArgumentException("El nombre del producto no puede ser mayor a 100 caracteres");
        }
        if (value.length() < 2) {
            throw new IllegalArgumentException("El nombre del producto no puede ser menor a 2 caracteres");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}