package com.bibliotheque.api.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bibliotheque.api.model.Pret;
import com.bibliotheque.api.model.Utilisateur;
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

	public Optional<Pret> saveProlongation(Integer id) {
		Optional <Pret> prets=pretRepository.findById(id);
		if(prets.isPresent()) {
		Pret pret = prets.get();
		Integer quatreSemaines = 28;
		Date dateDeFin = pret.getDateDeFin();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateDeFin);
		calendar.add(Calendar.DAY_OF_YEAR,quatreSemaines);
		Date newDateDeFin = calendar.getTime();
		pret.setDateDeFin(newDateDeFin);
		pretRepository.save(pret);
		return Optional.of(pret);
		}
		return prets;
	}
}
