package com.andcris.projetovg.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andcris.projetovg.domain.Item;

@RestController
@RequestMapping(value="/itens")
public class ItemResource {

	@GetMapping
	public ResponseEntity<List<Item>> findAll() {
		List<Item> list = new ArrayList<>();
		Item sorrowblade = new Item(null, "Sorrowblade", "+120 Poder de Arma", 3, 3100.0);
		Item shatterglass = new Item(null, "Shatterglass", "+130 Poder de Cristal", 3, 3000.0);
		list.addAll(Arrays.asList(sorrowblade, shatterglass));
		return ResponseEntity.ok().body(list);
	}
}
