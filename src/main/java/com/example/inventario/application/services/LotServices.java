package com.example.inventario.application.services;

import com.example.inventario.application.port.out.LotRepository;
import com.example.inventario.application.dto.StoreDto;
import com.example.inventario.domain.models.Lot;
import com.example.inventario.domain.models.Movement;
import com.example.inventario.infrastructure.adapters.FileStoreProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LotServices {
    private final LotRepository lotRepository;
    private final MovementServices movementServices;
    private final FileStoreProvider storeProvider;

    public LotServices(LotRepository lotRepository, MovementServices movementServices, FileStoreProvider storeProvider) {
        this.lotRepository = lotRepository;
        this.movementServices = movementServices;
        this.storeProvider = storeProvider;
    }

    public List<Lot> getAll(){
        return lotRepository.getAll();
    }

    public Lot getById(long id){
        return lotRepository.getById(id);
    }

    public Lot save(Lot lot){
        return lotRepository.save(lot);
    }

    public void delete(long id){
        lotRepository.delete(id);
    }

    @Transactional
    public Lot moveLot(long lotId, long fromStoreId, long toStoreId){
        if (fromStoreId == toStoreId) {
            throw new IllegalArgumentException("fromStoreId and toStoreId must be different");
        }

        Optional<StoreDto> fromStore = storeProvider.findById(fromStoreId);
        Optional<StoreDto> toStore = storeProvider.findById(toStoreId);
        if (fromStore.isEmpty()) throw new IllegalArgumentException("Source store not found: " + fromStoreId);
        if (toStore.isEmpty()) throw new IllegalArgumentException("Target store not found: " + toStoreId);

        Lot lot = lotRepository.getById(lotId);
        if (lot == null) throw new IllegalArgumentException("Lot not found: " + lotId);
        if (lot.getStoreId() != fromStoreId) throw new IllegalArgumentException("Lot is not at the source store");

        Lot updated = new Lot(lot.getId(), lot.getProductId(), toStoreId, lot.getExpiration());
        Lot saved = lotRepository.save(updated);

        movementServices.save(new Movement(0, fromStoreId, lotId, "SENT"));

        movementServices.save(new Movement(0, toStoreId, lotId, "RECEIVED"));

        return saved;
    }
}
