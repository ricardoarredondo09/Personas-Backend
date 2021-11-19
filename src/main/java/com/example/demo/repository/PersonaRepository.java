package com.example.demo.repository;

import com.example.demo.model.Persona;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface PersonaRepository extends Repository<Persona, Integer> {
    List<Persona>findAll();
    Persona save(Persona p);
    void delete(Persona p);
    Persona findById(int id);
    
}
