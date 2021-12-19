package com.gestionformationwebrest.com.gestionformation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import com.gestionformationwebrest.com.gestionformation.metiers.Formateur;


public class FormateurDAO {
	
	public boolean addFormateur(Formateur f){
		if (f==null) return false;
		Connection cnx= ConnexionBD.getInstance();
		PreparedStatement st;
		try {
			st= cnx.prepareStatement("insert into formateur values (?,?,?,?)");
			st.setString(1,f.getCin());
			st.setString(2, f.getNom());
			st.setString(3, f.getPrenom());
			st.setInt(4, f.getAge());
			st.executeUpdate();
			st.close();
			cnx.close();
			return true;
		}
		catch(SQLException exp) {
			System.out.println("Problème d'ajout "+exp.getMessage());
		}
		return false;
    }	
	public boolean updateUser(String cin,int nbrePoint)
	{
		if(findByCin(cin)==null)
			return false;
		Connection cnx=ConnexionBD.getInstance();
		PreparedStatement st;
		try
		{
			st=cnx.prepareStatement("update formateur set nbrePoint=? where cin=?");
			st.setInt(1, nbrePoint);
			st.setString(2, cin);
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
	
	public Collection<Formateur> findAll() {
		Collection<Formateur> lesFormateurs=new ArrayList<Formateur>();
		Connection cnx = ConnexionBD.getInstance();

		try 
		{
			PreparedStatement st = cnx.prepareStatement("select * from formateur");
			ResultSet res = st.executeQuery();
			while (res.next())

			{
				Formateur f = new Formateur(res.getString(1),res.getString(2),res.getString(3),res.getInt(4));
				lesFormateurs.add(f);
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Probl�me de recherche "+e.getMessage());
		}
        ConnexionBD.close();
		return lesFormateurs;
	}
	public Formateur findByCin(String cin) {
		Formateur form=null;
		Connection cnx = ConnexionBD.getInstance();

		try 
		{
			PreparedStatement st = cnx.prepareStatement("select * from formateur where cin=?");
			st.setString(1, cin);
			ResultSet res = st.executeQuery();
			if (res.next())

			{
				form= new Formateur(res.getString(1),res.getString(2),res.getString(3),res.getInt(4));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        ConnexionBD.close();
		return form;
	}
	public void delete(String cin)
	{
		Connection cnx=ConnexionBD.getInstance();
		try
		{
			PreparedStatement pt=cnx.prepareStatement("delete from formateur where cin=?");
			pt.setString(1, cin);
			int res=pt.executeUpdate();
			if(res==1)
				System.out.println("Suppression effectuer avec succ�s");
		}catch(SQLException ex)
		{
			System.out.println("Probl�me de suppression "+ex.getMessage());
		}
	}
}
