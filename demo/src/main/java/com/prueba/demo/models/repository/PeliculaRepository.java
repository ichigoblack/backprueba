package com.prueba.demo.models.repository;

import com.prueba.demo.models.entity.Pelicula;

import org.springframework.data.repository.*;

public interface PeliculaRepository extends CrudRepository<Pelicula,Integer>{
	
}