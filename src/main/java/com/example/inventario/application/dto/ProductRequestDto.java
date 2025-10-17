package com.example.inventario.application.dto;

public class ProductRequestDto {
    public String name;
    public String brand;
    public String description;
    public double price;

    public ProductRequestDto() {
    }

    public ProductRequestDto(String name, String brand, String description, double price) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
    }
}