package com.example.inventario.infrastructure.adapters.jpa;

import org.springframework.stereotype.Service;

import com.example.inventario.domain.models.Lot;
import com.example.inventario.infrastructure.adapters.entity.LotEntity;

@Service
public class LotMapper {

    public LotEntity ofModelToEntity(Lot lot){
        LotEntity lotEntity = new LotEntity();
        if (lot.getId() > 0) {
            lotEntity.setId(lot.getId());
        }
        lotEntity.setProductId(lot.getProductId());
        lotEntity.setStoreId(lot.getStoreId());
        lotEntity.setExpiration(lot.getExpiration());

        return lotEntity;
    }

    public Lot ofEntityToModel(LotEntity entity){
        return new Lot(
                entity.getId(),
                entity.getProductId(),
                entity.getStoreId(),
                entity.getExpiration()
        );
    }

}
