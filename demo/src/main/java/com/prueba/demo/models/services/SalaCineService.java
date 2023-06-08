package com.prueba.demo.models.services;

import java.util.List;

import com.prueba.demo.models.entity.SalaCine;

public interface SalaCineService {

	public SalaCine registrarPelicula(SalaCine sc);
	
	public List<SalaCine> listarSalas();
}