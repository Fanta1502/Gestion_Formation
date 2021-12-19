package com.gestionformationwebrest.com.gestionformation;

import java.util.Collection;

import com.gestionformationwebrest.com.gestionformation.controler.*;
import com.gestionformationwebrest.com.gestionformation.metiers.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("reservation")
public class ReservationWS {
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Collection<Reservation> getReservation()
		{
			return ReservationController.findAll();
		}
		
		@GET
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Reservation getUtilisateurByLogin(@PathParam("id") String id)
		{
			return ReservationController.findById(id);
		}
		
		@POST
		@Path("/reserver")
		public void addUtilisateur(@QueryParam("id") String id, @QueryParam("etat") int etat,@QueryParam("util") String util,@QueryParam("form") int form)
		{
			Utilisateur u=UtilisateurController.findByLogin(util);
			Formation f=FormationController.findById(form);
			Reservation r=new Reservation(id, etat, u, f);
			ReservationController.add(r);
		}
		@PUT
		@Path("/updateReservation")
		public void updateUtilisateur(@PathParam("id") String id,@QueryParam("etat") int etat)
		{
			ReservationController.update(id, etat);
		}
		@DELETE
		@Path("/deleteUser/{id}")
		public void deleteUtilisateur(@PathParam("id") String id)
		{
			ReservationController.delete(id);
		}
}

