package com.gestionformationwebrest.com.gestionformation.controler;

import java.util.Collection;

import com.gestionformationwebrest.com.gestionformation.dao.ReservationDAO;
import com.gestionformationwebrest.com.gestionformation.metiers.Reservation;

public class ReservationController {
	public static Collection<Reservation> findAll()
	{
		ReservationDAO r=new ReservationDAO();
		Collection<Reservation> reservation=r.findAll();
		return reservation;
	}
	public static Reservation findById(String id)
	{
		ReservationDAO r=new ReservationDAO();
		return r.findById(id);
	}
	public static void add(Reservation r)
	{
		ReservationDAO res=new ReservationDAO();
		res.addReservation(r);
	}
	public static void update(String id,int etat)
	{
		ReservationDAO res=new ReservationDAO();
		res.updateReservation(id, etat);
	}
	public static void delete(String id)
	{
		ReservationDAO f=new ReservationDAO();
		f.delete(id);
	}
}




