package com.example.inventario.application.dto;

public class MoveRequest {
    private long fromStoreId;
    private long toStoreId;

    public MoveRequest() {
    }

    public MoveRequest(long fromStoreId, long toStoreId) {
        this.fromStoreId = fromStoreId;
        this.toStoreId = toStoreId;
    }

    public long getFromStoreId() {
        return fromStoreId;
    }

    public void setFromStoreId(long fromStoreId) {
        this.fromStoreId = fromStoreId;
    }

    public long getToStoreId() {
        return toStoreId;
    }

    public void setToStoreId(long toStoreId) {
        this.toStoreId = toStoreId;
    }
}
