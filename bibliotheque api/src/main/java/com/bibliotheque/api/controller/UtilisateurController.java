package com.bibliotheque.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotheque.api.model.Utilisateur;

import com.bibliotheque.api.repository.UtilisateurRepository;
import com.bibliotheque.api.service.UtilisateurService;

@RestController
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@GetMapping("/password") // a virer à terme pour faire encryptage dans web
	public void password() {
		Iterable<Utilisateur> utilisateurs = utilisateurRepository.findAll();
		for (Utilisateur utilisateur : utilisateurs) {
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			String password = utilisateur.getMotDePasse();
			utilisateur.setMotDePasse(encoder.encode(password));
			utilisateurRepository.save(utilisateur);
		}
	}

	@GetMapping("/seconnecter/{email}")
	public Utilisateur getLogin(@PathVariable("email") String email) {
		List<Utilisateur> utilisateurs = utilisateurService.getLogin(email);
		for (Utilisateur utilisateur : utilisateurs) {
			return utilisateur;

		}
		return null;
	}

	@GetMapping("/user/{id}")
	public Optional<Utilisateur> getId(@PathVariable("id") Integer id) {
		return utilisateurService.getUtilisateur(id);

	}

}
