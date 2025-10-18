package com.example.inventario.infrastructure.adapters.jpa;

import com.example.inventario.domain.models.Movement;
import com.example.inventario.infrastructure.adapters.entity.MovementEntity;

import org.springframework.stereotype.Service;

@Service
public class MovementMapper {

    public MovementEntity ofModelToEntity(Movement movement){
        MovementEntity movementEntity = new MovementEntity();
        movementEntity.setStoreId(movement.getStoreId());
        movementEntity.setLotId(movement.getLotId());
        movementEntity.setMovementType(movement.getMovementType());

        return movementEntity;
    }

    public Movement ofEntityToModel(MovementEntity entity){
        return new Movement(
                entity.getId(),
                entity.getStoreId(),
                entity.getLotId(),
                entity.getMovementType()
        );
    }

}
