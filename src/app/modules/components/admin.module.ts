import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListeUserComponent } from 'src/app/users/liste-user/liste-user.component';
import { ListeFormationComponent } from 'src/app/formations/liste-formation/liste-formation.component';
import { AddFormationComponent } from 'src/app/formations/add-formation/add-formation.component';



@NgModule({
  declarations: [ListeUserComponent, ListeFormationComponent, AddFormationComponent],
  imports: [],
})
export class AdminModule {}
