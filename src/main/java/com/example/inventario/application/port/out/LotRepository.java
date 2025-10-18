package com.example.inventario.application.port.out;

import com.example.inventario.domain.models.Lot;
import java.util.List;

public interface LotRepository {

    public List<Lot> getAll();
    public Lot getById(long id);
    public Lot save(Lot lot);
    public void delete(long id);

}
