package com.gestionformationwebrest.com.gestionformation.controler;

import java.util.*;

import com.gestionformationwebrest.com.gestionformation.dao.UtilisateurDAO;
import com.gestionformationwebrest.com.gestionformation.metiers.Utilisateur;

public class UtilisateurController {
	
	public static Collection<Utilisateur> findAll()
	{
		UtilisateurDAO u=new UtilisateurDAO();
		Collection<Utilisateur> utils=u.findAll();
		return utils;
	}
	public static Utilisateur findByLogin(String log)
	{
		UtilisateurDAO u=new UtilisateurDAO();
		return u.findByLogin(log);
	}
	public static void add(Utilisateur u)
	{
		UtilisateurDAO ut=new UtilisateurDAO();
		ut.addUser(u);
	}
	public static void update(String log,String nom,String mail)
	{
		UtilisateurDAO ut=new UtilisateurDAO();
		ut.updateUser(log,nom,mail);
	}
	public static void delete(String log)
	{
		UtilisateurDAO u=new UtilisateurDAO();
		u.delete(log);
	}
}
