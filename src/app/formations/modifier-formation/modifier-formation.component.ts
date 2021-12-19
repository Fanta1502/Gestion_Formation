import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Formation } from 'src/app/registre/formation';
import { FormationService } from 'src/app/services/FormationService.service';

@Component({
  selector: 'app-modifier-formation',
  templateUrl: './modifier-formation.component.html',
  styleUrls: ['./modifier-formation.component.scss']
})
export class ModifierFormationComponent implements OnInit {

  formId:string;
  formation:Formation
  constructor(private router:Router,private formationService:FormationService,private cookieService:CookieService) { }

  ngOnInit(): void {
    
    this.formId=this.cookieService.get('forma');
    this.formationService.formation(this.formId).subscribe(data=>this.formation=data);
    console.log(this.formId);
    console.log(this.formation.dateform);
  }
  saveCompleted()
  {
    this.router.navigate(['allFormation']).then(()=>
    {
      window.location.reload();
    })
  }
  public saveFormData(registerForm: NgForm) {
    
   //a this.formationService.addFormation(this.formation,this.cin).subscribe(formation => this.formateurs.push(formation));
    this.saveCompleted();
  }

}
