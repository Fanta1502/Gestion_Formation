import { useAnimation } from '@angular/animations';
import { Component, OnInit } from '@angular/core';

import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { User } from 'src/app/registre/user';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-modifier-user',
  templateUrl: './modifier-user.component.html',
  styleUrls: ['./modifier-user.component.scss']
})
export class ModifierUserComponent implements OnInit {
  public user: User = new User();
  userL:string;
  u:User;
  mail:string;
  constructor(private userService: UserService, private router: Router,private cookieService:CookieService) { }
  users: any;

  ngOnInit(): void {
    this.savedCompleted();
    this.userL=this.cookieService.get('userLog');
    this.userService.user(this.userL).subscribe(
      data=>{this.u=data}
    );
  }
  savedCompleted()
  {
    this.userService.allUsers().subscribe(data => {
      this.users = data;
    });
  }
  public saveFormData(registerForm: NgForm) {
    this.userService.modifierUser(this.u).subscribe(u => this.users.push(u));
    this.router.navigate(['allUsers']);
    this.savedCompleted();
  }
}
