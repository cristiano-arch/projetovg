package com.andcris.projetovg;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andcris.projetovg.domain.Item;
import com.andcris.projetovg.repositories.ItemRepository;

@SpringBootApplication
public class ProjetovgApplication implements CommandLineRunner{
	
	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetovgApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Item sorrowblade = new Item(null, "Sorrowblade", "+120 Poder de Arma", 3, 3100.0);
		Item shatterglass = new Item(null, "Shatterglass", "+130 Poder de Cristal", 3, 3000.0);
		
		itemRepository.saveAll(Arrays.asList(sorrowblade, shatterglass));
	}

}
