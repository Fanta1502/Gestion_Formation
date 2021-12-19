package com.gestionformationwebrest.com.gestionformation.metiers;

import java.time.*;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class Utilisateur {
	private String login, password, nom, cin;
	private LocalDate date_naiss;
	private String email;
	private int role;

	public Utilisateur(String login, String password, String nom, String cin, LocalDate date_naiss, String email) {
		super();
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.cin = cin;
		this.date_naiss = date_naiss;
		this.email = email;
		this.role = 0;
	}
	public Utilisateur() {
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(LocalDate date_naiss) {
		this.date_naiss = date_naiss;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(login);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(login, other.login);
	}

	@Override
	public String toString() {
		return "Utilisateur [login=" + login + ", password=" + password + ", nom=" + nom + ", cin=" + cin
				+ ", date_naiss=" + date_naiss + ", email=" + email + ", role=" + role + "]";
	}
}
