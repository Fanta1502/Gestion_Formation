import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-liste-reservation',
  templateUrl: './liste-reservation.component.html',
  styleUrls: ['./liste-reservation.component.scss']
})
export class ListeReservationComponent implements OnInit {
  reservations:any;
  constructor(private reservationService : ReservationService, private router: Router) { }

  ngOnInit(): void {
    this.reservationService.allReservation().subscribe(data=>
      {
        this.reservations=data;
      })
      console.log(this.reservations);
  }
  addReservation(): void
  {
    this.router.navigate(['addReservation']).then(()=>
    {
      window.location.reload();
    })
  }

}
