package com.bibliotheque.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bibliotheque.api.model.Utilisateur;
import com.bibliotheque.api.model.Pret;

@Repository
	public interface PretRepository extends CrudRepository <Pret, Integer> {
		List <Utilisateur> findByUtilisateur(Utilisateur utilisateur);
	}


