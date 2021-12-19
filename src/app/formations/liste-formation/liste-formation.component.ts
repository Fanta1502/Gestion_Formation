import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Formation } from 'src/app/registre/formation';
import { User } from 'src/app/registre/user';
import { FormationService } from 'src/app/services/FormationService.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-liste-formation',
  templateUrl: './liste-formation.component.html',
  styleUrls: ['./liste-formation.component.scss']
})
export class ListeFormationComponent implements OnInit {
  formations: any;
  userL: string;
  user: User;
  constructor(private formationService: FormationService, private router: Router, private cookieService: CookieService, private userService: UserService) { }

  ngOnInit(): void {
    this.formationService.allFormation().subscribe(data => {
      this.formations = data;
    })
    console.log(this.formations);
  }
  addFormation(): void {
    this.router.navigate(['addFormation']).then(() => {
      window.location.reload();
    })
  } saveCompleted(): void {
    this.router.navigate(['allFormation']).then(() => {
      window.location.reload();
    })
  }
  supprimer(formation: Formation) {
    if (confirm("Voulez-vous réelement supprimer cette formation ???"))
      this.formationService.deleteFormation(formation.id).subscribe(
        {
          next: () => this.saveCompleted()
        })
  }
  reserver(formation: Formation) {
    this.userL = this.cookieService.get('utilLogin');
    console.log(this.userL);
    this.userService.user(this.userL).subscribe(data => this.user = data);
    console.log(this.user);
  }
  modifier(formation: Formation) {

    this.cookieService.set('forma', formation.id);
    this.router.navigate(['modifierFormation']).then(() => {
      window.location.reload();
    });
  }
}
