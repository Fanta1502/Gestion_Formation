package com.gestionformationwebrest.com.gestionformation.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

import com.gestionformationwebrest.com.gestionformation.metiers.Utilisateur;

public class UtilisateurDAO {
	
	public boolean addUser(Utilisateur u){
		if (u==null) return false;
		Connection cnx= ConnexionBD.getInstance();
		PreparedStatement st;
		try {
			st= cnx.prepareStatement("insert into utilisateur values (?,?,?,?,?,?,?)");
			st.setString(1, u.getLogin());
			st.setString(2, u.getPassword());
			st.setString(3, u.getNom());
			st.setString(4, u.getCin());
			st.setObject(5, u.getDate_naiss());
			st.setString(6, u.getEmail());
			st.setInt(7, u.getRole());
			st.executeUpdate();
			st.close();
			cnx.close();
			return true;
		}
		catch(SQLException exp) {
			System.out.println("Probl�me d'ajout "+exp.getMessage());
		}
		return false;
    }	
	public boolean updateUser(String log,String nom,String mail)
	{
		if(findByLogin(log)==null)
			return false;
		Connection cnx=ConnexionBD.getInstance();
		PreparedStatement st;
		try
		{
			st=cnx.prepareStatement("update utilisateur set nom=?,email=? where login=?");
			st.setString(1, nom);
			st.setString(2, mail);
			st.setString(3, log);
			st.executeUpdate();
			st.close();
			cnx.close();
			return true;
		}
		catch(Exception ex)
		{
			System.out.println("Probl�me de mise � jour "+ex.getMessage());
		}
		return false;
	}
	
	public Collection<Utilisateur> findAll() {
		Collection<Utilisateur> utils=new ArrayList<Utilisateur>();
		Connection cnx = ConnexionBD.getInstance();

		try 
		{
			PreparedStatement st = cnx.prepareStatement("select * from utilisateur");
			ResultSet res = st.executeQuery();
			while (res.next())

			{
				LocalDate d=res.getDate(5).toLocalDate();
				Utilisateur u = new Utilisateur(res.getString(1),res.getString(2),res.getString(3),res.getString(4),d,res.getString(6));
				utils.add(u);
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Probl�me de recherche "+e.getMessage());
		}
        ConnexionBD.close();
		return utils;
	}
	public Utilisateur findByLogin(String log) {
		Utilisateur utils=null;
		Connection cnx = ConnexionBD.getInstance();

		try 
		{
			PreparedStatement st = cnx.prepareStatement("select * from utilisateur where login=?");
			st.setString(1, log);
			ResultSet res = st.executeQuery();
			if (res.next())

			{
				LocalDate d=res.getDate(5).toLocalDate();
				utils = new Utilisateur(res.getString(1),res.getString(2),res.getString(3),res.getString(4),d,res.getString(6));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        ConnexionBD.close();
		return utils;
	}
	public void delete(String login)
	{
		Connection cnx=ConnexionBD.getInstance();
		try
		{
			PreparedStatement pt=cnx.prepareStatement("delete from utilisateur where login=?");
			pt.setString(1, login);
			int res=pt.executeUpdate();
			if(res==1)
				System.out.println("Suppression effectuer avec succ�s");
		}catch(SQLException ex)
		{
			System.out.println("Probl�me de suppression "+ex.getMessage());
		}
	}
}
