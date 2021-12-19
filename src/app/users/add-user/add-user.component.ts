import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/registre/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {
  public user: User = new User();
  constructor(private userService: UserService, private router: Router) { }
  users: any;
  hide = true;
  ngOnInit(): void {
  }
  saveCompled()
  {
    this.userService.allUsers().subscribe(data => {
      this.users = data;
    });
  }
  public saveFormData(registerForm: NgForm) {
    this.userService.addUser(this.user).subscribe(user => this.users.push(user));
    console.log('Valeurs : ', JSON.stringify(registerForm.value));
    this.router.navigate(['allUsers']);
    this.saveCompled();
  }
}
