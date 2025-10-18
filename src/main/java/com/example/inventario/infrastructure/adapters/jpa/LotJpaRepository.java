package com.example.inventario.infrastructure.adapters.jpa;

import com.example.inventario.infrastructure.adapters.entity.LotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotJpaRepository extends JpaRepository<LotEntity, Long>{
	
}
