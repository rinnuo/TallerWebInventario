package com.example.inventario.infrastructure.adapters.jpa;

import com.example.inventario.application.port.out.MovementRepository;
import com.example.inventario.domain.models.Movement;
import com.example.inventario.infrastructure.adapters.entity.MovementEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class MovementRepositoryAdapter implements MovementRepository {
    private MovementJpaRepository movementJpaRepository;
    private MovementMapper movementMapper;

    @Override
    public List<Movement> getAll() {
        return movementJpaRepository.findAll().stream().map( entity ->
            movementMapper.ofEntityToModel(entity)
        ).toList();
    }

    @Override
    public Movement getById(long id) {
        return movementMapper.ofEntityToModel(
                movementJpaRepository.findById(id).get()
        );
    }

    @Override
    public Movement save(Movement movement) {
        MovementEntity entity = movementJpaRepository.save(
                movementMapper.ofModelToEntity(movement)
        );
        return movementMapper.ofEntityToModel(entity);
    }
}
