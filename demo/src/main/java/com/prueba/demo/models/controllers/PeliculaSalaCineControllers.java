package com.prueba.demo.models.controllers;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.demo.models.entity.PeliculaSalaCine;
import com.prueba.demo.models.services.PeliculaSalaCineService;
import com.prueba.demo.util.util;

@RestController
public class PeliculaSalaCineControllers {

	private PeliculaSalaCineService peliculaSalaCineService;
	private String patron = "yyyy-MM-dd";
	
    public PeliculaSalaCineControllers(PeliculaSalaCineService pscs) {
        this.peliculaSalaCineService = pscs;
    }
    
    @PostMapping("/crearPeliculaSalaCine")
	public ResponseEntity<PeliculaSalaCine> crearPeliculaSalaCine(@RequestBody PeliculaSalaCine psc) {
	    psc = peliculaSalaCineService.registrarPeliculaSalaCine(psc);
	    return new ResponseEntity<>(psc, HttpStatus.CREATED);
	}
    
    @GetMapping("/listarPeliculaSalaCine")
    public List<PeliculaSalaCine> listarPeliculaSalaCine() {
        return peliculaSalaCineService.listarPeliculaSalaCine();
    }
    
    @GetMapping("/listarPeliculaByNombreAndSala/{nombre}/{idsala}")
    public List<PeliculaSalaCine> listarPeliculaByNombreAndSala(@PathVariable String nombre,@PathVariable Integer idsala) {
    	return peliculaSalaCineService.buscarPorPeliculaSala(nombre, idsala);
    }
    
    @GetMapping("/listarPeliculaByFecha/{fecha}")
	public ResponseEntity<?> listarPeliculaByFecha(@PathVariable String fecha) {
    	
    	List<PeliculaSalaCine> listaPeliculas = null;
    	int cantidad = 0;
    	//util ut = new util();
    	Date fec = null;
    	try {
			fec = util.stringToDate(fecha, patron);
		} catch (Exception e) {
		}
    	Map<String,Object> response = new LinkedHashMap<>();
    	System.out.println("fec "+fec);
    	try {			
    		listaPeliculas = peliculaSalaCineService.buscarPorFecha(fec);
		} catch (Exception e) {
			System.out.println("error "+e.getMessage());
		}
    	if(listaPeliculas!=null) {
    		cantidad = listaPeliculas.size();
    		response.put("peliculas", listaPeliculas);
    		response.put("cantidad", cantidad);
    	}
    	return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
    
    @PostMapping("/buscarByNombreSala")
	public ResponseEntity<?> buscarByNombreSala(@RequestBody String nombre) {
    	List<PeliculaSalaCine> listaPeliculas = null;
    	int cantidad = 0;
    	
    	Map<String,Object> response = new LinkedHashMap<>();
    	try {
			listaPeliculas = peliculaSalaCineService.buscarByNombreSala(nombre);
		} catch (Exception e) {
			System.out.println("error "+e.getMessage());
		}
    	if(listaPeliculas!=null) {
    		cantidad = listaPeliculas.size();
    		if(cantidad < 3) {    			
    			response.put("mensaje", "Sala casi Vacía");
    		}
    		if(cantidad > 2 && cantidad < 6) {
    			response.put("mensaje", "Sala casi Llena");
    		}
    		if(cantidad > 5) {
    			response.put("mensaje", "Sala  Llena");
    		}
    	}
    	return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
    
}