package com.bibliotheque.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bibliotheque.api.model.Livre;

@Repository
public interface LivreRepository extends CrudRepository <Livre, Integer> {	

}
