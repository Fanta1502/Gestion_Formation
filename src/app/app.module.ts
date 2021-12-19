import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import {CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import { AddUserComponent } from './users/add-user/add-user.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ListeUserComponent } from './users/liste-user/liste-user.component';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatTableModule} from '@angular/material/table';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexModule } from '@angular/flex-layout';
import { ModifierUserComponent } from './users/modifier-user/modifier-user.component';
import { ListeFormationComponent } from './formations/liste-formation/liste-formation.component';
import { AddFormationComponent } from './formations/add-formation/add-formation.component';
import { ListeReservationComponent } from './reservation/liste-reservation/liste-reservation.component';
import { LoginComponent } from './login/login/login.component';
import { ListeUserGuard } from './Guard/liste-user.guard';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import { CookieService } from 'ngx-cookie-service';
import { ModifierFormationComponent } from './formations/modifier-formation/modifier-formation.component';

const appRoutes: Routes = [
  {
      path: 'allUsers',
      component: ListeUserComponent,
      canActivate:[ListeUserGuard]
  },
  {
      path: 'addUser',
      component: AddUserComponent
  },
  {
      path: 'modifierUser',
      component: ModifierUserComponent
  },
  {
      path: 'allFormation',
      component: ListeFormationComponent
  },
  {
      path: 'addFormation',
      component: AddFormationComponent
  },
  {
      path: 'login',
      component: LoginComponent
  },
  {
      path: 'allReservation',
      component: ListeReservationComponent
  },
  {
      path: 'modifierFormation',
      component: ModifierFormationComponent
  },
  { 
      path: '', redirectTo: '/login', 
      pathMatch: 'full' 
  },
  {
      path: '**',
      redirectTo: 'landing'
  }
]
@NgModule({
  declarations: [
    AppComponent,
    AddUserComponent,
    ListeUserComponent,
    ModifierUserComponent,
    ListeFormationComponent,
    AddFormationComponent,
    ListeReservationComponent,
    LoginComponent,
    ModifierFormationComponent,
  ],
  imports: [
    MatInputModule,
    MatIconModule,
    FlexModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    MatButtonModule,
    MatCardModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatTableModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
