package com.bibliotheque.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.api.model.Livre;
import com.bibliotheque.api.repository.LivreRepository;
import lombok.Data;

@Data
@Service
public class LivreService {

	@Autowired
	private LivreRepository livreRepository;

	public Optional<Livre> getLivre(final Integer id) {
		return livreRepository.findById(id);
	}

	public Iterable<Livre> getLivres() {
		return livreRepository.findAll();
	}

	public void deleteLivre(final Integer id) {
		livreRepository.deleteById(id);
	}

	public Livre saveLivre(Livre livre) {
		Livre saveLivre = livreRepository.save(livre);
		return saveLivre;
	}

	public Iterable<Livre> getLivresSearch(String search) {
		List<Livre> livres = livreRepository.findByTitreContainingOrAuteurContaining(search); // voir si syntaxe de la méthode correct à vérfier en test 
		return livres; 
	}

}
