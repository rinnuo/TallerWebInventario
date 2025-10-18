package com.example.inventario.application.services;

import com.example.inventario.application.port.out.MovementRepository;
import com.example.inventario.domain.models.Movement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementServices {
    private final MovementRepository movementRepository;

    public MovementServices(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public List<Movement> getAll(){
        return movementRepository.getAll();
    }

    public Movement getById(long id){
        return movementRepository.getById(id);
    }

    public Movement save(Movement movement){
        return movementRepository.save(movement);
    }
}
