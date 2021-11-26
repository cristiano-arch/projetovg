package com.andcris.projetovg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andcris.projetovg.domain.Item;
import com.andcris.projetovg.dto.ItemDTO;
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
	
	@Transactional
	public Item insert(Item obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public Item update(Item obj) {
		Item newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public List<Item> findByNome(String text) {
		return repo.findByNomeContainingIgnoreCase(text);
	}
	
	private void updateData(Item newObj, Item obj) {
		newObj.setId(obj.getId());
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
		newObj.setNivel(obj.getNivel());
		newObj.setPreco(obj.getPreco());
	}

	public Item fromDTO(ItemDTO objDto) {
		return new Item(objDto.getId(), objDto.getNome(), objDto.getDescricao(), objDto.getNivel(), objDto.getPreco());
	}
}
