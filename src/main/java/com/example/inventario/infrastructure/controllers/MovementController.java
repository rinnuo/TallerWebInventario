package com.example.inventario.infrastructure.controllers;



import com.example.inventario.application.services.MovementServices;
import com.example.inventario.domain.models.Movement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/movement")
@RequiredArgsConstructor
public class MovementController {
    private final MovementServices movementServices;
 


    @GetMapping
    public List<Movement> getAll(){
        return movementServices.getAll();
    }

    @GetMapping("/{id}")
		public Movement getById(@PathVariable long id){
      
			return movementServices.getById(id);
		}

    @PostMapping
    public Movement save(@RequestBody Movement movement){
        return movementServices.save(movement);
    }

    @PostMapping("/{id}")
    public Movement update(@PathVariable long id){
        return movementServices.getById(id);
    }
}
