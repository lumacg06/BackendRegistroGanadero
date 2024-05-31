package com.software2ex.RegistroGanadero.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.software2ex.RegistroGanadero.model.modelRegistro;


@RestController
@RequestMapping("/api/registro")

public class controllerRegistro {
    private List<modelRegistro>registrosGanaderos;

    public controllerRegistro(){
        try {
         ObjectMapper objectMapper = new ObjectMapper();
         modelRegistro[] registrosGanaderosArray = objectMapper
         .readValue(new ClassPathResource("registrosGanaderos.json")
         .getFile(), modelRegistro[].class);
         registrosGanaderos = new ArrayList<>(Arrays.asList(registrosGanaderosArray));
        } catch (IOException e) {
            e.printStackTrace();
            registrosGanaderos = new ArrayList<>();
            
        }
    }
    
    @GetMapping
    public List<modelRegistro> obtenerRegistros(){
        return registrosGanaderos;
    }

    @GetMapping("/{id}")
    public modelRegistro obtenerRegistroPorId(@PathVariable Long id){
        return registrosGanaderos.stream()
        .filter(registro -> registro.getId().equals(id))
        .findFirst()
        .orElse(null);
    }   
    
    @PostMapping
    public modelRegistro crearRegistro(@RequestBody modelRegistro registro){
        registrosGanaderos.add(registro);
        return registro;
    }

}
