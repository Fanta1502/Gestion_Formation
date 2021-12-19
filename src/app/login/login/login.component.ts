import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { User } from 'src/app/registre/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  nom:string;
  pass:string;
  user : User =new User();
  constructor(private userService:UserService,private router:Router,private cookieService: CookieService) { }
  hide = true;
  ngOnInit(): void { }
  onLoggedin()
  {
    this.userService.user(this.nom).subscribe(data => {
      this.user=data});
      console.log(this.user);
      console.log(this.user.password);
      if(this.user.password==this.pass)
      {
        this.cookieService.set('utilLogin',this.nom);
        this.router.navigate(['allFormation']).then(()=>
        {
          window.location.reload();
        })        
      }
      else
      {
        alert("Veillez verifier votre mot de passe");
      }
  }
}
