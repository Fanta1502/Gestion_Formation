package com.gestionformationwebrest.com.gestionformation.controler;

import java.time.LocalDate;
import java.util.Collection;

import com.gestionformationwebrest.com.gestionformation.dao.FormationDAO;
import com.gestionformationwebrest.com.gestionformation.metiers.*;
public class FormationController {
	
	public static Collection<Formation> findAll()
	{
		FormationDAO f=new FormationDAO();
		Collection<Formation> form=f.findAll();
		return form;
	}
	public static Formation findById(int id)
	{
		FormationDAO f=new FormationDAO();
		return f.findById(id);
	}
	public static void add(Formation f)
	{
		FormationDAO forms=new FormationDAO();
		forms.addUser(f);
	}
	public static void update(int id,String intitule,String descript,LocalDate date,int nbReservation,double prix)
	{
		FormationDAO f=new FormationDAO();
		f.updateUser(id, intitule, descript, date, nbReservation, prix);
	}
	public static void delete(String id)
	{
		FormationDAO f=new FormationDAO();
		f.delete(id);
	}
}
