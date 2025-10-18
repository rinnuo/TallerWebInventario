package com.example.inventario.domain.models;

import com.example.inventario.domain.valueObjects.MovementTypeValue;


public class Movement {

    private long id;
    private long storeId;
    private long lotId;
    private String movementType;

    public Movement() {

    }

    public Movement(long id, long storeId, long lotId, String movementType) {
        this.id = id;
        this.storeId = storeId;
        this.lotId = lotId;
        this.movementType = new MovementTypeValue(movementType).getValue();
    }

    public long getId() {
        return id;
    }

    public long getStoreId() {
        return storeId;
    }

    public long getLotId() {
        return lotId;
    }

    public String getMovementType() {
        return movementType;
    }
}
