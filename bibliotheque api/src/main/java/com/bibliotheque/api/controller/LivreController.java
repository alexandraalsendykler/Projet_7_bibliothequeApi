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
	public Iterable<Livre> getLivre() {
		return livreService.getLivres();

	}

	@GetMapping(value = "/recherchelivres/{search}")
	public Iterable<Livre> rechercheLivres(@PathVariable("search") String search) {
		return livreService.getLivresSearch(search);

	}

}

//@GetMapping(value = "/recherchesites")
//public String rechercheSites(Model model, @RequestParam String searchsites,
// @RequestParam(required = false) Boolean officiel) {
// if (officiel != null) {
// List<Site> sites =
// siteRepository.findByRegionContainingOrNomContainingAndOfficiel(searchsites,searchsites,
// officiel);
// model.addAttribute("sites", sites);
// } else {

// List<Site> sites =
// siteRepository.findByRegionContainingOrNomContaining(searchsites,searchsites);
// model.addAttribute("sites", sites);
// }

// return ("rechercheSites");
