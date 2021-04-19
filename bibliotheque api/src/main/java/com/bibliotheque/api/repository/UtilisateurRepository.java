package com.bibliotheque.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bibliotheque.api.model.Pret;
import com.bibliotheque.api.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
	List<Utilisateur> findByEmail(String email);

	Optional<Utilisateur> findAllByPret(Pret pret);
}
