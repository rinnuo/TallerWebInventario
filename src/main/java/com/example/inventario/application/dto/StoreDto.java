package com.example.inventario.application.dto;

public class StoreDto {
    private Long id;
    private String name;

    public StoreDto() {
    }

    public StoreDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
