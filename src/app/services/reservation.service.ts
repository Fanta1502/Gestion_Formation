import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reservation } from '../registre/reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) { }

  allReservation():Observable<Reservation> 
  {
    const getUrl= 'http://localhost:8090/com.gestionformation/webapi/reservation';
      return this.http.get<Reservation>(getUrl);
  }
  effectuerReservation(reservation : Reservation)
  {

  }
}
