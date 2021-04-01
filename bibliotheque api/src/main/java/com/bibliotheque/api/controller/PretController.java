package com.bibliotheque.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotheque.api.model.Pret;
import com.bibliotheque.api.service.PretService;

@RestController
public class PretController {
	@Autowired
	private PretService pretService;
	
	@GetMapping("/Pret/{id}")
	public Optional<Pret> getPret(@PathVariable("id") final int id) {
		return pretService.getPret(id);
	}
	
	@GetMapping("/Prolonger/{id}")
	public Optional<Pret> getProlongation(@PathVariable("id")final int id) {
		return pretService.saveProlongation(id);
}

}
