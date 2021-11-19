package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/personas"})
public class PersonaController {

    @Autowired
    PersonaService service;

    @GetMapping
    public List<Persona>listar(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<?> agregar(@Valid @RequestBody Persona p,  BindingResult result){
        Map<String, Object> response = new HashMap<>();
        if(result.hasErrors()){
            System.out.println("prueba");
            List<String> errors = new ArrayList<>();
            
            for(FieldError err: result.getFieldErrors()){
                errors.add("El campo: " + err.getField() +' '+err.getDefaultMessage());
            } 
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<Persona>(service.add(p), HttpStatus.OK);
    }
    
    @GetMapping(path = {"/{id}"})
    public Persona listarId(@PathVariable("id")int id){
        return service.listarId(id);
    }
    
    @PutMapping(path = {"/{id}"})
    public Persona editar(@PathVariable("id")int id, @RequestBody Persona p ){
        p.setId(id);
        return service.edit(p);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public Persona delete(@PathVariable("id")int id){
        return service.delete(id);
    }
}
