package com.example.inventario.domain.models;

import com.example.inventario.domain.valueObjects.ExpirationValue;

public class Lot {

	private long id;
	private long productId;
	private long storeId;
	private String expiration;

	public Lot() {

    }

	public Lot(long id, long productId, long storeId, String expiration) {
		this.id = id;
		this.productId = productId;
		this.storeId = storeId;
		this.expiration = new ExpirationValue(expiration).getValue();
	}

    public long getId() {
        return id;
    }

    public long getProductId() {
        return productId;
    }

    public long getStoreId() {
        return storeId;
    }

    public String getExpiration() {
        return expiration;
    }
}
