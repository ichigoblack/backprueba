package com.prueba.demo.models.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.demo.models.entity.SalaCine;
import com.prueba.demo.models.repository.SalaCineRepository;
import com.prueba.demo.models.services.SalaCineService;

@Service
public class SalaCineDaoImpl implements SalaCineService{

	@Autowired
	SalaCineRepository salaCineRepository;
	
	@Override
	@Transactional
	public SalaCine registrarPelicula(SalaCine sc) {
		return salaCineRepository.save(sc);
	}

	@Override
	@Transactional
	public List<SalaCine> listarSalas() {
		return (List<SalaCine>) salaCineRepository.findAll();
	}

}