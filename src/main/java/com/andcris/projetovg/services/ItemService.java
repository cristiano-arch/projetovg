package com.andcris.projetovg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andcris.projetovg.domain.Item;
import com.andcris.projetovg.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repo;
	
	public List<Item> findAll() {
		return repo.findAll();
	}
}
