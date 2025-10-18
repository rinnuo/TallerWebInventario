package com.example.inventario.domain.valueObjects;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class MovementTypeValue {

    private static final Set<String> ALLOWED = new HashSet<>(
            Arrays.asList("SENT", "RECEIVED")
    );

    private final String value;

    public MovementTypeValue(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Movement type no puede estar vacío");
        }
        String normalized = value.trim().toUpperCase();
        if (!ALLOWED.contains(normalized)) {
            throw new IllegalArgumentException("Movement type no permitido: " + value);
        }
        this.value = normalized;
    }

    public String getValue() {
        return value;
    }
}