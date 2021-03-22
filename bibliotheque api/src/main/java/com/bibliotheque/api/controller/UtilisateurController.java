package com.bibliotheque.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotheque.api.model.Utilisateur;
import com.bibliotheque.api.service.UtilisateurService;

@RestController
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;

	@PostMapping("/seconnecter") // changer postmapping changer par getmapping
	@ResponseBody
	public Utilisateur getLogin(@RequestBody Utilisateur newUser) { // remplacer par String Email à la place Utilisateur newuser 
		String email = newUser.getEmail(); // virer cette ligne ensuite // ligne 22 @requestBody remplacher par un @pathvariable 

		List<Utilisateur> utilisateurs = utilisateurService.getLogin(email);
		for (Utilisateur utilisateur : utilisateurs) {
			return utilisateur;

		}
		return null;
	}

}
