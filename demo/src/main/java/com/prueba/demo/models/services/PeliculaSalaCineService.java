package com.prueba.demo.models.services;

import java.util.Date;
import java.util.List;

import com.prueba.demo.models.entity.PeliculaSalaCine;

public interface PeliculaSalaCineService {

	public PeliculaSalaCine registrarPeliculaSalaCine(PeliculaSalaCine psc);
	
	public List<PeliculaSalaCine> listarPeliculaSalaCine();
	
	public List<PeliculaSalaCine> buscarPorPeliculaSala(String nombre,Integer idsalacine);
	
	public List<PeliculaSalaCine> buscarPorFecha(Date fecha);
	
	public List<PeliculaSalaCine> buscarByNombreSala(String nombre);
	
}