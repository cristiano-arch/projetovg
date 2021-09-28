package com.andcris.projetovg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andcris.projetovg.domain.Categoria;
import com.andcris.projetovg.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public List<Categoria> findAll() {
		return repo.findAll();
	}
}
