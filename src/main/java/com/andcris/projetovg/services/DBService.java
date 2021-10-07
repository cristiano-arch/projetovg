package com.andcris.projetovg.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andcris.projetovg.domain.Categoria;
import com.andcris.projetovg.domain.Item;
import com.andcris.projetovg.repositories.CategoriaRepository;
import com.andcris.projetovg.repositories.ItemRepository;

@Service
public class DBService {
	
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	public void instantiateTestDataBase() {
		Item sorrowblade = new Item(null, "Sorrowblade", "+120 Poder de Arma", 3, 3100.00);
		Item shatterglass = new Item(null, "Shatterglass", "+130 Poder de Cristal", 3, 3000.00);
		
		itemRepository.saveAll(Arrays.asList(sorrowblade, shatterglass));
		
		Categoria arma = new Categoria(null, "Arma");
		arma.setItens(Arrays.asList(sorrowblade));
		Categoria cristal= new Categoria(null, "Cristal");
		arma.setItens(Arrays.asList(shatterglass));
		
		categoriaRepository.saveAll(Arrays.asList(arma, cristal));
		
		sorrowblade.setCategorias(Arrays.asList(arma));
		shatterglass.setCategorias(Arrays.asList(cristal));
		
		itemRepository.saveAll(Arrays.asList(sorrowblade, shatterglass));
	}
}
