package com.bibliotheque.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotheque.api.model.Utilisateur;
import com.bibliotheque.api.service.UtilisateurService;

@RestController
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping("/seconnecter") 
	@ResponseBody
	public Utilisateur getLogin(@RequestParam(value="email", required = true) String email) { 

		List<Utilisateur> utilisateurs = utilisateurService.getLogin(email);
		for (Utilisateur utilisateur : utilisateurs) {
			return utilisateur;

		}
		return null;
	}

}
