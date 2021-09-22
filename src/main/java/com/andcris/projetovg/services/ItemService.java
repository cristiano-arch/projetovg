package com.andcris.projetovg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andcris.projetovg.domain.Item;
import com.andcris.projetovg.repositories.ItemRepository;
import com.andcris.projetovg.services.exceptions.ObjectNotFoundException;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repo;
	
	public List<Item> findAll() {
		return repo.findAll();
	}
	
	public Item find(Integer id) {
		Optional<Item> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Item não encontrado Id: " + id + ", Tipo: " + Item.class.getName()));
	}
}
