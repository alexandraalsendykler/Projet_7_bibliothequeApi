package com.bibliotheque.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "identifiant")
@Table(name = "exemplaire")

public class Exemplaire {

	@Id
	@Column(name = "idExemplaire")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identifiant;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "exemplaire")
	@JsonIgnoreProperties("exemplaire")
	private List<Pret> prets;
	@ManyToOne
	@JsonIgnoreProperties("exemplaires")
	@JoinColumn(name = "idLivre")
	private Livre livre;


	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public List<Pret> getPrets() {
		return prets;
	}

	public void setPrets(List<Pret> prets) {
		this.prets = prets;
	}

	public Integer getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Integer identifiant) {
		this.identifiant = identifiant;
	}

}
