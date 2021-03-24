package com.bibliotheque.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bibliotheque.api.model.Pret;

@Repository
	public interface PretRepository extends CrudRepository <Pret, Integer> {
		Optional<Pret> findById(Integer id);
	}


