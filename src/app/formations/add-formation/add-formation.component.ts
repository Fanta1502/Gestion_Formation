import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Formateur } from 'src/app/registre/formateur';
import { Formation } from 'src/app/registre/formation';
import { FormationService } from 'src/app/services/FormationService.service'; 
@Component({
  selector: 'app-add-formation',
  templateUrl: './add-formation.component.html',
  styleUrls: ['./add-formation.component.scss']
})
export class AddFormationComponent implements OnInit {

  constructor(private formationService: FormationService, private router: Router) { }
  formateurs:any;
  cin:string;
  formateur:any;
  public formation: Formation =new Formation();

  ngOnInit(): void {
    this.formationService.allFormateur().subscribe(data => this.formateurs = data);
  }
  saveCompleted()
  {
    this.router.navigate(['allFormation']).then(()=>
    {
      window.location.reload();
    })
  }
  public saveFormData(registerForm: NgForm) {
    
    this.formationService.addFormation(this.formation,this.cin).subscribe(formation => this.formateurs.push(formation));
    this.saveCompleted();
  }
}
