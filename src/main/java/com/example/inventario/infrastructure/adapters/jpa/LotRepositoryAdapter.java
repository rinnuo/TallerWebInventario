package com.example.inventario.infrastructure.adapters.jpa;

import com.example.inventario.application.port.out.LotRepository;
import com.example.inventario.domain.models.Lot;
import com.example.inventario.infrastructure.adapters.entity.LotEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class LotRepositoryAdapter implements LotRepository {
    private LotJpaRepository lotJpaRepository;
    private LotMapper lotMapper;

    @Override
    public List<Lot> getAll() {
        return lotJpaRepository.findAll().stream().map( entity ->
            lotMapper.ofEntityToModel(entity)
        ).toList();
    }

    @Override
    public Lot getById(long id) {
        return lotMapper.ofEntityToModel(
                lotJpaRepository.findById(id).get()
        );
    }

    @Override
    public Lot save(Lot lot) {
        LotEntity entity = lotJpaRepository.save(
                lotMapper.ofModelToEntity(lot)
        );
        return lotMapper.ofEntityToModel(entity);
    }

		@Override
    public void delete(long id) {
        lotJpaRepository.deleteById(id);
    }
}
