package com.esprit.microservices.candidate;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pilote1 implements Serializable{
	private static final long serialVersionUID = 6711457437559348053L;
	@Id
	@GeneratedValue
	private int id;
	private String nom, prenom;
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Pilote1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pilote1(String nom) {
		super();
		this.nom = nom;
	}
	
}



