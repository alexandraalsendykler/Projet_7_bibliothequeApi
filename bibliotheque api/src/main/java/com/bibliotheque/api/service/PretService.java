package com.bibliotheque.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bibliotheque.api.model.Pret;
import com.bibliotheque.api.repository.PretRepository;

import lombok.Data;

@Data
@Service
public class PretService {

	@Autowired
	private PretRepository pretRepository;

	public Optional<Pret> getPret(final Integer id) {
		return pretRepository.findById(id);
	}

	public Iterable<Pret> getPrets() {
		return pretRepository.findAll();
	}

	public void deletePret(final Integer id) {
		pretRepository.deleteById(id);
	}

	public Pret savePret(Pret pret) {
		Pret savePret = pretRepository.save(pret);
		return savePret;
	}


}
