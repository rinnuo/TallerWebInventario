package com.example.inventario.infrastructure.adapters.jpa;

import com.example.inventario.infrastructure.adapters.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementJpaRepository extends JpaRepository<MovementEntity, Long>{
	
}
