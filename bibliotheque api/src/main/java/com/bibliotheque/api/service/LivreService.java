package com.bibliotheque.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.api.model.LivreModel;
import com.bibliotheque.api.repository.LivreRepository;


import lombok.Data;

@Data
@Service
public class LivreService  {
	
	@Autowired
	private LivreRepository livreRepository;
	
	public Optional <LivreModel> getLivre(final Integer id){
        return livreRepository.findById(id);
		}
	
	public Iterable<LivreModel> getLivres(){
		return livreRepository.findAll();
	}
	
	public void deleteLivre(final Integer id) {
		livreRepository.deleteById(id);	
	}
	
	public LivreModel saveLivre(LivreModel livre) {
		LivreModel saveLivre = livreRepository.save(livre);
		return saveLivre;
	}

}
