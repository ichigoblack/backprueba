package com.prueba.demo.models.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.demo.models.entity.Pelicula;
import com.prueba.demo.models.services.PeliculaService;

@RestController
public class PeliculaControllers {

	private  PeliculaService peliservice;

    public PeliculaControllers(PeliculaService peliservice) {
        this.peliservice = peliservice;
    }
    
	@GetMapping("/mensaje")
    public String obtenerMensaje() {
        return "Mensaje impreso en la consola.";
    }
	
	@PostMapping("/crearPelicula")
	public ResponseEntity<Pelicula> crearPelicula(@RequestBody Pelicula peli) {
	    peli = peliservice.registrarPelicula(peli);
	    return new ResponseEntity<>(peli, HttpStatus.CREATED);
	}
	
	@GetMapping("/listarTodasPeliculas")
    public List<Pelicula> listarPeliculas() {
        return peliservice.listarPeliculas();
    }
	
	@GetMapping("/eliminarPelicula/{idpelicula}")
    public void eliminarPelicula(@PathVariable Integer idpelicula) {
        peliservice.eliminarPelicula(idpelicula);
    }
	
}