package com.bibliotheque.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "livre")
public class LivreModel {

	@Id
	@Column(name = "idLivre") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	private String titre;


	private String auteur;

	private String resume;

}
