package com.gestionformationwebrest.com.gestionformation.metiers;

import java.util.Objects;

public class Formateur {
	private String cin,nom,prenom;
	private int age;
	public int getNbPoint() {
		return nbPoint;
	}
	public void setNbPoint(int nbPoint) {
		this.nbPoint = nbPoint;
	}
	private int nbPoint;

	public Formateur() {
		super();
	}
	public Formateur(String cin, String nom, String prenom, int age) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.nbPoint=0;
	}
	
	@Override
	public String toString() {
		return "Formateur [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCin() {
		return cin;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formateur other = (Formateur) obj;
		return Objects.equals(cin, other.cin);
	}
	
}
