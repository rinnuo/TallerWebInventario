package com.example.inventario.domain.valueObjects;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public final class ExpirationValue {

    private final String value;

    public ExpirationValue(String value) {
        try {
            LocalDate parsed = LocalDate.parse(value); 
            this.value = parsed.toString(); 
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Formato de tiempo inválido. Use yyyy-MM-dd");
        }
    }

    public String getValue() {
        return value;
    }
}