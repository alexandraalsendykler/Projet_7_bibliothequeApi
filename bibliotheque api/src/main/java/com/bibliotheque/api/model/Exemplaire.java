package com.bibliotheque.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "exemplaire")

public class Exemplaire {

	@Id
	@Column(name = "idExemplaire")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer identifiant;

	@ManyToOne
	@JoinColumn(name = "idLivre")
	private Livre livre;

	@OneToMany
	@JoinColumn(name = "idPret")
	private List<Pret> prets;

	public List<Pret> getPrets() {
		return prets;
	}

	public void setPrets(List<Pret> prets) {
		this.prets = prets;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Integer getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Integer identifiant) {
		this.identifiant = identifiant;
	}

}
