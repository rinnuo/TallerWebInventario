package com.example.inventario.infrastructure.controllers;

import com.example.inventario.application.services.LotServices;
import com.example.inventario.domain.models.Lot;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.inventario.application.dto.MoveRequest;

@RestController
@RequestMapping("api/lot")
@RequiredArgsConstructor
public class LotController {
    private final LotServices lotServices;


    @GetMapping
    public List<Lot> getAll(){
        return lotServices.getAll();
    }

    @GetMapping("/{id}")
		public Lot getById(@PathVariable long id){
      
			return lotServices.getById(id);
		}

    @PostMapping
    public Lot save(@RequestBody Lot lot){
        return lotServices.save(lot);
    }

    @PostMapping("/{id}")
    public Lot update(@PathVariable long id){
        return lotServices.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        lotServices.delete(id);
    }

    @PostMapping("/{id}/move")
    public Lot move(@PathVariable long id, @RequestBody MoveRequest request){
        return lotServices.moveLot(id, request.getFromStoreId(), request.getToStoreId());
    }
}
