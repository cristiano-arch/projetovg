package com.andcris.projetovg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andcris.projetovg.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByNomeContainingIgnoreCase(String text);
}
