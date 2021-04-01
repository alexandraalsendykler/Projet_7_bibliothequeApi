package com.bibliotheque.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotheque.api.model.Livre;
import com.bibliotheque.api.service.LivreService;

@RestController
public class LivreController {
	@Autowired
	private LivreService livreService;
	
	@GetMapping("/Livres")
	public Iterable<Livre> getLivre(){
		return livreService.getLivres();
		
	}
	
	@GetMapping(value="/recherchelivres/{search}")
	public Iterable<Livre> rechercheLivres(@PathVariable("search") String search) {
	return livreService.getLivresSearch(search);

}

}



