package com.gestionformationwebrest.com.gestionformation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.gestionformationwebrest.com.gestionformation.metiers.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ReservationDAO {
	public boolean addReservation(Reservation r){
		if (r==null) return false;
		java.sql.Connection cnx= ConnexionBD.getInstance();
		java.sql.PreparedStatement st;
		try {
			st= cnx.prepareStatement("insert into reservation values (?,?,?,?)");
			st.setString(1,r.getId());
			st.setInt(2, r.getEtat());
			st.setString(3,r.getForm().getId());
			st.setString(4, r.getUtil().getLogin());
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
	public boolean updateReservation(String id,int etat)
	{
		java.sql.Connection cnx=ConnexionBD.getInstance();
		java.sql.PreparedStatement st;
		try
		{
			st=cnx.prepareStatement("update reservation set etat=? where id=?");
			st.setInt(1, etat);
			st.setString(2, id);
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
	
	public Collection<Reservation> findAll() {
		Collection<Reservation> lesReservations=new ArrayList<Reservation>();
		FormationDAO f=new FormationDAO();
		Collection<Formation> lesFormations=f.findAll();
		UtilisateurDAO u=new UtilisateurDAO();
		Collection<Utilisateur> lesUtilisateurs=u.findAll();
		java.sql.Connection cnx = ConnexionBD.getInstance();

		try 
		{
			java.sql.PreparedStatement st = cnx.prepareStatement("select id,etat,form_id,util_login from reservation");
			ResultSet res = st.executeQuery();
			while (res.next())

			{
				Formation form=null;
				Utilisateur util=null;
				for(Formation f1:lesFormations)
					if(f1.getId().equals(res.getString(3)))
						form=f1;
				for(Utilisateur u1 :lesUtilisateurs)
					if(u1.getLogin().equals(res.getString(4)))
						util=u1;
				Reservation r1=new Reservation(res.getString(1),res.getInt(2),util,form);
				lesReservations.add(r1);
				}
			st.close();
		} catch (SQLException e) {
			System.out.println("Probl�me de recherche "+e.getMessage());
		}
        ConnexionBD.close();
		return lesReservations;
	}
	public Reservation findById(String id) {
		Reservation r=null;
		FormationDAO f=new FormationDAO();
		Collection<Formation> lesFormations=f.findAll();
		UtilisateurDAO u=new UtilisateurDAO();
		Collection<Utilisateur> lesUtilisateurs=u.findAll();
		java.sql.Connection cnx = ConnexionBD.getInstance();

		try 
		{
			PreparedStatement st = (PreparedStatement) cnx.prepareStatement("select id,etat,form_id,util_login from reservation where id=?");
			st.setString(1, id);
			ResultSet res = st.executeQuery();
			while (res.next())

			{
				Formation form=null;
				Utilisateur util=null;
				for(Formation f1:lesFormations)
					if(f1.getId().equals(res.getString(3)))
						form=f1;
				for(Utilisateur u1 :lesUtilisateurs)
					if(u1.getLogin().equals(res.getString(4)))
						util=u1;
				r=new Reservation(res.getString(1),res.getInt(2),util,form);
				}
			st.close();
		} catch (SQLException e) {
			System.out.println("Probl�me de recherche "+e.getMessage());
		}
        ConnexionBD.close();
		return r;
	}
	public void delete(String id)
	{
		java.sql.Connection cnx=ConnexionBD.getInstance();
		try
		{
			PreparedStatement pt=(PreparedStatement) cnx.prepareStatement("delete from reservation where id=?");
			pt.setString(1, id);
			int res=pt.executeUpdate();
			if(res==1)
				System.out.println("Suppression effectuer avec succ�s");
		}catch(SQLException ex)
		{
			System.out.println("Probl�me de suppression "+ex.getMessage());
		}
	}
}
