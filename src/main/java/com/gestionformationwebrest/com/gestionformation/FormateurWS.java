package com.gestionformationwebrest.com.gestionformation;

import java.util.Collection;

import com.gestionformationwebrest.com.gestionformation.controler.FormateurController;
import com.gestionformationwebrest.com.gestionformation.metiers.Formateur;

import jakarta.ws.rs.*;

@Path("/formateurs")
public class FormateurWS {
	@GET
	@Produces("application/json")
	public Collection<Formateur> getFormateur()
	{
		return FormateurController.findAll();
	}
	
	
	  @GET
	  
	  @Path("/formateur/{cin}")
	  
	  @Produces("application/json") public Formateur
	  getFormateurByCin(@PathParam("cin") String cin) { return
	  FormateurController.findByCin(cin); }
	 
	
	
	  @POST
	  
	  @Path("/addFormateur") public void addFormateur(@QueryParam("cin") String
	  cin,@QueryParam("nom") String nom,@QueryParam("prenom") String
	  prenom, @QueryParam("age") int age) { FormateurController.add(new
	  Formateur(cin, nom, prenom, age)); }
	 
	
	/*
	 * @PUT
	 * 
	 * @Path("/updateFormateur") public void updateFormateur(@PathParam("cin")
	 * String cin,@QueryParam("nbPoint") int nb) { FormateurController.update(cin,
	 * nb); }
	 */
	 
	
	  @DELETE
	  
	  @Path("/deleteFormateur") public void deleteUtilisateur(@PathParam("cin")
	  String cin) { FormateurController.delete(cin); }
	 
}
