package com.example.demo.service;

import com.example.demo.model.Persona;
import java.util.List;
import org.springframework.stereotype.Service;


public interface PersonaService {
    List<Persona>listar();
    Persona listarId(int id);
    Persona add(Persona p);
    Persona edit(Persona p);
    Persona delete(int id);
}
