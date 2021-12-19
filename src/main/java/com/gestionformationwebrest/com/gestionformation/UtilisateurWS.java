package com.gestionformationwebrest.com.gestionformation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;
import java.util.*;

import com.gestionformationwebrest.com.gestionformation.controler.UtilisateurController;
import com.gestionformationwebrest.com.gestionformation.metiers.Utilisateur;

@Path("users")
public class UtilisateurWS {
	Collection<Utilisateur> lesUsers=null;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Utilisateur> getUtilisateur()
	{    lesUsers=UtilisateurController.findAll();
		for(Utilisateur u :lesUsers)
		System.out.println("la liste des utilisateur :"+u);
		return lesUsers;
	}
	
	@GET
	@Path("login/{login}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur getUtilisateurByLogin(@PathParam("login") String login)
	{
		Utilisateur user= UtilisateurController.findByLogin(login);
		System.out.println("la liste de utilisateur  :"+user);

		return user;
	}
	
	//ne marche pas
	
	
	/*
	 * @POST
	 * 
	 * @Path("/addUser") public void addUtilisateur(@QueryParam("log") String
	 * login, @QueryParam("pass") String password, @QueryParam("nom") String
	 * nom, @QueryParam("cin") String cin, @QueryParam("date") LocalDate
	 * date_naiss, @QueryParam("mail") String email) { UtilisateurController.add(new
	 * Utilisateur(login,password,nom,cin,date_naiss,email)); }
	 */
	 
	@PUT
	@Path("/updateUser/{log}")
	public void updateUtilisateur(@PathParam("log") String login,@QueryParam("nom") String nom,@QueryParam("mail") String email)
	{
		UtilisateurController.update(login,nom,email);
	}
	@DELETE
	@Path("/deleteUser/{log}")
	public void deleteUtilisateur(@PathParam("log") String login)
	{
		UtilisateurController.delete(login);
	}
}
