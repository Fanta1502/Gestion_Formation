package com.gestionformationwebrest.com.gestionformation.controler;

import java.util.Collection;

import com.gestionformationwebrest.com.gestionformation.dao.FormateurDAO;
import com.gestionformationwebrest.com.gestionformation.metiers.Formateur;




public class FormateurController {
	public static Collection<Formateur> findAll()
	{
		FormateurDAO f=new FormateurDAO();
		Collection<Formateur> formateurs=f.findAll();
		return formateurs;
	}
	public static Formateur findByCin(String cin)
	{
		FormateurDAO f=new FormateurDAO();
		return f.findByCin(cin);
	}
	public static void add(Formateur f)
	{
		FormateurDAO form=new FormateurDAO();
		form.addFormateur(f);
	}
	public static void update(String cin,int nb)
	{
		FormateurDAO forma=new FormateurDAO();
		forma.updateUser(cin, nb);
	}
	public static void delete(String cin)
	{
		FormateurDAO f=new FormateurDAO();
		f.delete(cin);
	}
}
