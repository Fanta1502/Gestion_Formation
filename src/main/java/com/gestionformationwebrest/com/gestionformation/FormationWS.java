package com.gestionformationwebrest.com.gestionformation;

import java.time.LocalDate;
import java.util.Collection;

import com.gestionformationwebrest.com.gestionformation.controler.FormationController;
import com.gestionformationwebrest.com.gestionformation.metiers.Formateur;
import com.gestionformationwebrest.com.gestionformation.metiers.Formation;


import jakarta.ws.rs.*;


@Path("/formations")
public class FormationWS 
{
	@GET
	@Produces("application/json")
	public Collection<Formation> getFormation()
	{
		return FormationController.findAll();
	}
	
	
	  @GET
	  
	  @Path("/formation/{id}")
	  
	  @Produces("application/json") public Formation
	  getFormationById(@PathParam("id") int id) { return
	  FormationController.findById(id); }
	 
	
	/*
	 * @POST
	 * 
	 * @Path("/addFormation") public void addFormation(@QueryParam("id") String
	 * id,@QueryParam("intitule") String intitule,@QueryParam("formateur") Formateur
	 * formateur,@QueryParam("description") String description, @QueryParam("date")
	 * LocalDate date,@QueryParam("nbPlace") int nbPlace,@QueryParam("prix") double
	 * prix) { FormationController.add(new Formation(id, intitule, formateur,
	 * description, date, nbPlace, prix)); }
	 */
		/*
		 * @PUT
		 * 
		 * @Path("/updateFormation") public void updateFormation(@PathParam("id") int
		 * id,@QueryParam("intitule") String intitule,@QueryParam("desc") String descr,
		 * 
		 * @QueryParam("date") LocalDate d,@QueryParam("nbreRes") int
		 * nbR,@QueryParam("prix") Double doub) {
		 * FormationController.update(id,intitule,descr,d,nbR,doub); }
		 */
	
	  @DELETE
	  
	  @Path("/deleteFormation") public void deleteFormation(@PathParam("id") String
	  id) { FormationController.delete(id); }
	 
}
