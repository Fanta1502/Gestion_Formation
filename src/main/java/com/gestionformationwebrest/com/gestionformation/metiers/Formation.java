package com.gestionformationwebrest.com.gestionformation.metiers;

import java.time.*;
import java.util.Objects;

public class Formation {
	private String id,intitule,description;
	private Formateur formateur;
	private LocalDate date;
	private int nbPlace,nbReservation;
	private double prix;
	private float score;
	private int nbScore;
	public Formation(String id, String intitule, Formateur formateur, String description, LocalDate date, int nbPlace,double prix) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.formateur = formateur;
		this.description = description;
		this.date = date;
		this.nbPlace = nbPlace;
		this.nbReservation = 0;
		this.prix = prix;
		this.score = 0;
		this.nbScore = 0;
	}
	public Formation() {
		super();
	}
	public Formation(String id, String intitule, Formateur formateur, String description, LocalDate date, int nbPlace,
			int nbReservation, double prix, float score, int nbScrore) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.formateur = formateur;
		this.description = description;
		this.date = date;
		this.nbPlace = nbPlace;
		this.nbReservation = nbReservation;
		this.prix = prix;
		this.score = score;
		this.nbScore = nbScrore;
	}

	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public int getNbReservation() {
		return nbReservation;
	}
	public void setNbReservation(int nbReservation) {
		this.nbReservation = nbReservation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getNbScore() {
		return nbScore;
	}
	public void setNbScrore(int nbScrore) {
		this.nbScore = nbScrore;
	}
	public String getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formation other = (Formation) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Formation [id=" + id + ", intitule=" + intitule + ", formateur=" + formateur + ", description="
				+ description + ", date=" + date + ", nbPlace=" + nbPlace + ", nbReservation=" + nbReservation
				+ ", prix=" + prix + ", score=" + score + ", nbScrore=" + nbScore + "]";
	}
}
