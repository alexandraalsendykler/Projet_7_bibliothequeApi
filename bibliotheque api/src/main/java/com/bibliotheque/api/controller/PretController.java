package com.bibliotheque.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotheque.api.model.Livre;
import com.bibliotheque.api.model.Pret;
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
