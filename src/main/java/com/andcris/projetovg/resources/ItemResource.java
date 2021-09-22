package com.andcris.projetovg.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andcris.projetovg.domain.Item;
import com.andcris.projetovg.dto.ItemDTO;
import com.andcris.projetovg.services.ItemService;

@RestController
@RequestMapping(value="/itens")
public class ItemResource {

	@Autowired
	private ItemService service;
	
	@GetMapping
	public ResponseEntity<List<ItemDTO>> findAll() {
		List<Item> list = service.findAll();
		List<ItemDTO> listDto = list.stream().map(x -> new ItemDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ItemDTO> find(@PathVariable Integer id) {
		Item obj = service.find(id);
		return ResponseEntity.ok().body(new ItemDTO(obj));
	}
}
