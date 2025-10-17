package com.example.inventario.domain.models;

import com.example.inventario.domain.valueObjects.ProductNameValue;
import com.example.inventario.domain.valueObjects.BrandValue;
import com.example.inventario.domain.valueObjects.DescriptionValue;
import com.example.inventario.domain.valueObjects.PriceValue;

public class Product {

    private Long id;
    private ProductNameValue name;
    private BrandValue brand;
    private DescriptionValue description;
    private PriceValue price;
    private boolean active;

    public Product() {
        this.active = true;
    }

    public Product(Long id, String name, String brand, String description, double price) {
        this.id = id;
        this.name = new ProductNameValue(name);
        this.brand = new BrandValue(brand);
        this.description = new DescriptionValue(description);
        this.price = new PriceValue(price);
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name.getValue();
    }

    public String getBrand() {
        return brand.getValue();
    }

    public String getDescription() {
        return description != null ? description.getValue() : null;
    }

    public double getPrice() {
        return price.getValue();
    }

    public boolean isActive() {
        return active;
    }

    // Métodos de dominio
    public Product deactivate() {
        this.active = false;
        return this;
    }

    public Product activate() {
        this.active = true;
        return this;
    }

    public Product withUpdatedInfo(String name, String brand, String description, double price) {
        return new Product(
                this.id,
                name != null ? name : this.getName(),
                brand != null ? brand : this.getBrand(),
                description != null ? description : this.getDescription(),
                price >= 0 ? price : this.getPrice()
        );
    }
}