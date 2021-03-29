package com.bibliotheque.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bibliotheque.api.service.PretService;

@RestController
public class PretController {
	@Autowired
	private PretService pretService;
	/*
	@GetMapping("/Prets")
	@ResponseBody
	public Iterable<Pret> getPret(@RequestParam(value = "utilisateur", required = true) Integer id) {
		return pretService.getpret();
	}*/
}
