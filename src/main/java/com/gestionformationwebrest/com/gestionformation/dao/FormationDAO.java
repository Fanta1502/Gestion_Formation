package  com.gestionformationwebrest.com.gestionformation.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import com.gestionformationwebrest.com.gestionformation.metiers.Formateur;
import com.gestionformationwebrest.com.gestionformation.metiers.Formation;

public class FormationDAO {
	public boolean addUser(Formation f){
		if (f==null) return false;
		Connection cnx= ConnexionBD.getInstance();
		PreparedStatement st;
		try {
			st= cnx.prepareStatement("insert into formation values (?,?,?,?,?,?,?,?,?,?)");
			st.setString(1, f.getId());
			st.setString(2, f.getIntitule());
			st.setString(3, f.getFormateur().getCin());
			st.setString(4, f.getDescription());
			st.setObject(5, f.getDate());
			st.setInt(6, f.getNbPlace());
			st.setInt(7, f.getNbReservation());
			st.setDouble(8, f.getPrix());
			st.setFloat(9, f.getScore());
			st.setInt(10, f.getNbScore());
			st.executeUpdate();
			st.close();
			cnx.close();
			return true;
		}
		catch(SQLException exp) {
			System.out.println("Probleme d'ajout "+exp.getMessage());
		}
		return false;
    }	
	public boolean updateUser (int id,String intitule,String descript,LocalDate date,int nbReservation,double prix)
	{
		if(findById(id)==null)
			return false;
		Connection cnx=ConnexionBD.getInstance();
		PreparedStatement st;
		try
		{
			st=cnx.prepareStatement("update formation set intitule=?,date=?,nbResrvation=?,prix=?,description=?  where id=?");
			st.setInt(6, id);
			st.setString(1, intitule);
			st.setObject(2, date);
			st.setInt(3, nbReservation);
			st.setDouble(4, prix);
			st.setString(5, descript);
			st.executeUpdate();
			st.close();
			cnx.close();
			return true;
		}
		catch(Exception ex)
		{
			System.out.println("Proble de mise � jour "+ex.getMessage());
		}
		return false;
	}
	public Collection<Formation> findAll() {
		Collection<Formation> forms=new ArrayList<Formation>();
		FormateurDAO fr=new FormateurDAO();
		Collection<Formateur> lesFormateurs=fr.findAll();
		Connection cnx = ConnexionBD.getInstance();

		try 
		{
			PreparedStatement st = cnx.prepareStatement("select id,intitule,cinFormateur,description,date,nbPlace,nbReservation,prix,score,nbScore from formation");
			ResultSet res = st.executeQuery();
			while (res.next())

			{
				Formateur f=null;
				LocalDate d=res.getDate(5).toLocalDate();
				for(Formateur f1:lesFormateurs)
					if(f1.getCin().equals(res.getString(3)))
						f=f1;
				Formation ff=new Formation(res.getString(1),res.getString(2),f,res.getString(4),d,res.getInt(6),res.getInt(7),res.getDouble(8),res.getFloat(9),res.getInt(10));
				forms.add(ff);
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Probl�me de recherche "+e.getMessage());
		}
        ConnexionBD.close();
		return forms;
	}

	public Formation findById(int id) {
				Formation ff=null;
				Connection cnx = ConnexionBD.getInstance();
				FormateurDAO fr=new FormateurDAO();
				Collection<Formateur> lesFormateurs=fr.findAll();
		
				try 
				{
					PreparedStatement st = cnx.prepareStatement("select id,intitule,cinFormateur,description,date,nbPlace,nbReservation,prix,score,nbScore from formation where id=?");
					st.setInt(1, id);
					ResultSet res = st.executeQuery();
					if (res.next())
		
					{
						Formateur f=null;
		                LocalDate d=res.getDate(5).toLocalDate();
						for(Formateur f1:lesFormateurs)
							if(f1.getCin().equals(res.getString(3)))
								f=f1;
						 ff=new Formation(res.getString(1),res.getString(2),f,res.getString(4),d,res.getInt(6),res.getInt(7),res.getDouble(8),res.getFloat(9),res.getInt(10));
					}
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		        ConnexionBD.close();
				return ff;
	}
	public void delete(String id)
	{
		Connection cnx=ConnexionBD.getInstance();
		try
		{
			PreparedStatement pt=cnx.prepareStatement("delete from tformation where if=?");
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
