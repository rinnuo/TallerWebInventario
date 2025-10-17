package com.example.inventario.domain.valueObjects;

public class PriceValue {
    private double value;

    public PriceValue(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if (value > 999999.99) {
            throw new IllegalArgumentException("El precio no puede ser mayor a 999,999.99");
        }
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}