import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { User } from 'src/app/registre/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-liste-user',
  templateUrl: './liste-user.component.html',
  styleUrls: ['./liste-user.component.scss']
})
export class ListeUserComponent implements OnInit {

  users:any;
  pubuser: User;
  constructor(private userService: UserService, private router: Router,private cookieService: CookieService) { }


  ngOnInit(): void {
    this.userService.allUsers().subscribe(data => {
      this.users = data;
    });
  } 
  
  addUser(): void
  {
    this.router.navigate(['addUser']).then(()=>
    {
      window.location.reload();
    })
  }
  saveCompleted():void
  {
    this.router.navigate(['allUsers']).then(()=>
    {
      window.location.reload();
    })
  }
  supprimer(user : User): void
  {
    console.log("yeahhhhhhhh");
    console.log(user.login);
    if(confirm("Voulez-vous réelement supprimer cet utilisateur ???"))
    this.userService.deleteUser(user.login).subscribe(
      {
        next:()=>this.saveCompleted()
      }
    )
  }
 public modifierListe(user : User)
  {
    this.cookieService.set('userLog',user.login);
    this.pubuser=user;
    this.router.navigate(['modifierUser']).then(()=>
    {
      window.location.reload();
    });
    return user;
  }
}
