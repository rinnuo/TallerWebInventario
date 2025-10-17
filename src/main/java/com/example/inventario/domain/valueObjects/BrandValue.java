package com.example.inventario.domain.valueObjects;

public class BrandValue {
    private String value;

    public BrandValue(String value) {
        if(value == null || value.isEmpty()){
            throw new IllegalArgumentException("La marca no puede estar vacía");
        }
        if (value.length() > 50) {
            throw new IllegalArgumentException("La marca no puede ser mayor a 50 caracteres");
        }
        if (value.length() < 2) {
            throw new IllegalArgumentException("La marca no puede ser menor a 2 caracteres");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}