package com.example.inventario.application.port.out;

import com.example.inventario.domain.models.Movement;
import java.util.List;

public interface MovementRepository {

    public List<Movement> getAll();
    public Movement getById(long id);
    public Movement save(Movement movement);
}
