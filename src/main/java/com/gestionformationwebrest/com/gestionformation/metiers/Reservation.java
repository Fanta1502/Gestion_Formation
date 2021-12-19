package com.gestionformationwebrest.com.gestionformation.metiers;

import java.util.Objects;

public class Reservation {
	private String id;
	private int etat;
	private Utilisateur util;
	private Formation form;
	public Reservation(String id, int etat, Utilisateur util, Formation form) {
		super();
		this.id = id;
		this.etat = etat;
		this.util = util;
		this.form = form;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public Utilisateur getUtil() {
		return util;
	}
	public void setUtil(Utilisateur util) {
		this.util = util;
	}
	public Formation getForm() {
		return form;
	}
	public void setForm(Formation form) {
		this.form = form;
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
		Reservation other = (Reservation) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", etat=" + etat + ", util=" + util + ", form=" + form + "]";
	}
}
