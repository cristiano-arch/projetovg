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
		
		Item weaponblade = new Item(null, "Weapon Blade", "+10 Poder de Arma", 1, 300.00);
		Item heavysteel = new Item(null, "Heavy Steel", "+45 Poder de Arma", 2, 1150.00);
		Item sixsins = new Item(null, "Six Sins", "+25 Poder de Arma", 2, 650.00);
		Item sorrowblade = new Item(null, "Sorrowblade", "+120 Poder de Arma", 3, 3100.00);
		
		itemRepository.saveAll(Arrays.asList(weaponblade, heavysteel, sixsins, sorrowblade));
		
		Item crystalbit = new Item(null, "Crystal Bit", "+15 Poder de Cristal", 1, 300.00);
		Item heavyprism = new Item(null, "Heavy Prism", "+45 Poder de Cristal", 2, 1050.00);
		Item eclipseprism = new Item(null, "Eclipse Prism", "+30 Poder de Cristal", 2, 650.00);
		Item shatterglass = new Item(null, "Shatterglass", "+130 Poder de Cristal", 3, 3000.00);
		
		itemRepository.saveAll(Arrays.asList(crystalbit, heavyprism, eclipseprism, shatterglass));
		
		Item oakheart = new Item(null, "Oakheart", "+150 Vida Máxima", 1, 300.00);
		Item lifespring = new Item(null, "Lifespring", "+200 Vida Máxima", 2, 800.00);
		Item dragonheart = new Item(null, "Dragonheart", "+350 Vida Máxima", 2, 650.00);
		Item pulseweave = new Item(null, "Pulseweave", "+600 Vida Máxima", 3, 3000.00);
		
		itemRepository.saveAll(Arrays.asList(oakheart, lifespring, dragonheart, pulseweave));
		
		Item sprintboots = new Item(null, "Sprint Boots", "+0.3 Velocidade de Movimento", 1, 300.00);
		Item travelboots = new Item(null, "Travel Boots", "+0.5 Velocidade de Movimento", 2, 650.00);
		Item teleportboots = new Item(null, "Teleport Boots", "+0.5 Velocidade de Movimento", 3, 1400.00);
		
		itemRepository.saveAll(Arrays.asList(sprintboots, travelboots, teleportboots));
		
		Item weaponinfusion = new Item(null, "Weapon Infusion", "+40 Poder de Arma", 0, 500.00);
		Item crystalinfusion = new Item(null, "Crystal Infusion", "+60 Poder de Cristal", 0, 500.00);
		
		itemRepository.saveAll(Arrays.asList(weaponinfusion, crystalinfusion));
		
		Categoria arma = new Categoria(null, "Arma");
		arma.setItens(Arrays.asList(weaponblade, heavysteel, sixsins, sorrowblade));
		Categoria cristal = new Categoria(null, "Cristal");
		cristal.setItens(Arrays.asList(crystalbit, heavyprism, eclipseprism, shatterglass));
		Categoria defesa = new Categoria(null, "Defesa");
		defesa.setItens(Arrays.asList(oakheart, lifespring, dragonheart, pulseweave));
		Categoria utilitario = new Categoria(null, "Utilitário");
		utilitario.setItens(Arrays.asList(sprintboots, travelboots, teleportboots));
		Categoria outros = new Categoria(null, "Outros");
		outros.setItens(Arrays.asList(weaponinfusion, crystalinfusion));
		
		categoriaRepository.saveAll(Arrays.asList(arma, cristal, defesa, utilitario, outros));
		
		weaponblade.setCategorias(Arrays.asList(arma));
		heavysteel.setCategorias(Arrays.asList(arma));
		sixsins.setCategorias(Arrays.asList(arma));
		sorrowblade.setCategorias(Arrays.asList(arma));
		
		itemRepository.saveAll(Arrays.asList(weaponblade, heavysteel, sixsins, sorrowblade));
		
		crystalbit.setCategorias(Arrays.asList(cristal));
		heavyprism.setCategorias(Arrays.asList(cristal));
		eclipseprism.setCategorias(Arrays.asList(cristal));
		shatterglass.setCategorias(Arrays.asList(cristal));
		
		itemRepository.saveAll(Arrays.asList(crystalbit, heavyprism, eclipseprism, shatterglass));
		
		oakheart.setCategorias(Arrays.asList(defesa));
		lifespring.setCategorias(Arrays.asList(defesa));
		dragonheart.setCategorias(Arrays.asList(defesa));
		pulseweave.setCategorias(Arrays.asList(defesa));
		
		itemRepository.saveAll(Arrays.asList(oakheart, lifespring, dragonheart, pulseweave));
		
		sprintboots.setCategorias(Arrays.asList(utilitario));
		travelboots.setCategorias(Arrays.asList(utilitario));
		teleportboots.setCategorias(Arrays.asList(utilitario));
		
		itemRepository.saveAll(Arrays.asList(sprintboots, travelboots, teleportboots));
		
		weaponinfusion.setCategorias(Arrays.asList(outros));
		crystalinfusion.setCategorias(Arrays.asList(outros));
		
		itemRepository.saveAll(Arrays.asList(weaponinfusion, crystalinfusion));
	}
}
