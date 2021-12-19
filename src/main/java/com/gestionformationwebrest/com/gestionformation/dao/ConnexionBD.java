package com.gestionformationwebrest.com.gestionformation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {

	
	private static String url="jdbc:mysql://localhost:3306/BDFormationwebrest";
	private static String utilisateur="root";
	private static String motPasse="";
	static Connection cnx=null;

	public static Connection getInstance() {
		try {
			if(cnx==null ||  cnx.isClosed())
				//connection a la BD et ajouter une dependance ds pom.xml
			     	Class.forName("com.mysql.cj.jdbc.Driver");
					cnx=DriverManager.getConnection(url,utilisateur ,motPasse);
					System.out.println("Vous ete connecté");
				} 
				catch (SQLException e) {
					System.out.println("Vous n'ete pas  connecté");
					e.printStackTrace();
					
				}//Fin connection
 catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return cnx;	
	}
	public static void close() {
		try {
		if(cnx!=null && !cnx.isClosed())
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(" Echec de la fermeture de la Connexion ");
			}
		}
}
