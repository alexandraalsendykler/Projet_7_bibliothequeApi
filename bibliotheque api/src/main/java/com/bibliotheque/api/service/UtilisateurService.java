package com.bibliotheque.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.api.model.Pret;
import com.bibliotheque.api.model.Utilisateur;
import com.bibliotheque.api.repository.UtilisateurRepository;

import lombok.Data;

@Data
@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	public Optional<Utilisateur> getUtilisateur(final Integer id) {
		return utilisateurRepository.findById(id);
	}

	public List<Utilisateur> getLogin(final String email) {
		return utilisateurRepository.findByEmail(email);
	}

	public Iterable<Utilisateur> getUtilisateurs() {
		return utilisateurRepository.findAll();
	}

	public void deleteUtilisateur(final Integer id) {
		utilisateurRepository.deleteById(id);
	}

	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		Utilisateur saveUtilisateur = utilisateurRepository.save(utilisateur);
		return saveUtilisateur;
	}

	public Optional<Utilisateur> findAllByPret(Pret pret) {
		return utilisateurRepository.findAllByPret(pret);
	}

}
