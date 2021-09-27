package com.andcris.projetovg.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andcris.projetovg.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> list = new ArrayList<>();
		Categoria arma = new Categoria(null, "Arma");
		Categoria cristal= new Categoria(null, "Cristal");
		list.addAll(Arrays.asList(arma, cristal));
		return ResponseEntity.ok().body(list);
	}
}
