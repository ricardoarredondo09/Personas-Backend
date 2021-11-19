/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ricardo
 */

@Service
public class PersonaServiceImp implements PersonaService{
    
    @Autowired
    private PersonaRepository personaRepository;
    
    
    @Override
    public List<Persona> listar() {
       return personaRepository.findAll();
    }

    @Override
    public Persona listarId(int id) {
       return personaRepository.findById(id);
    }

    @Override
    public Persona add(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona edit(Persona persona) {
       return personaRepository.save(persona);
    }

    @Override
    public Persona delete(int id) {
        Persona p = personaRepository.findById(id);
        
        if(p!= null){
            personaRepository.delete(p);
        }
        return p;
    }
    
}
