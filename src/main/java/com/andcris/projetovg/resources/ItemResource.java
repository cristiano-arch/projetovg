package com.andcris.projetovg.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ItemDTO objDto) {
		Item obj = service.fromDTO(objDto);
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ItemDTO> update(@PathVariable Integer id, @RequestBody ItemDTO objDto) {
		objDto.setId(id);
		Item obj = service.fromDTO(objDto);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
