package com.prueba.demo.models.services;

import java.util.List;

import com.prueba.demo.models.entity.Pelicula;

public interface PeliculaService {

	public Pelicula registrarPelicula(Pelicula peli);
	
	public List<Pelicula> listarPeliculas();
	
	public void eliminarPelicula(Integer idpelicula);
	
}