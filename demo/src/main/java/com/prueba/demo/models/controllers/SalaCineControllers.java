package com.prueba.demo.models.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.demo.models.entity.SalaCine;
import com.prueba.demo.models.services.SalaCineService;

@RestController
public class SalaCineControllers {

	private  SalaCineService salaCineService;

    public SalaCineControllers(SalaCineService salaCineService) {
        this.salaCineService = salaCineService;
    }
 
    @PostMapping("/crearSalaCine")
	public ResponseEntity<SalaCine> crearSalaCine(@RequestBody SalaCine sc) {
	    sc = salaCineService.registrarPelicula(sc);
	    return new ResponseEntity<>(sc, HttpStatus.CREATED);
	}
	
	@GetMapping("/listarTodasSalasCines")
    public List<SalaCine> listarSalasCines() {
        return salaCineService.listarSalas();
    }
    
}