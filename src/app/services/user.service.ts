import{Injectable}from'@angular/core';
import{HttpClient, HttpHandler, HttpHeaders,HttpResponse, HttpParams}from'@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { User } from '../registre/user';
import { Router } from '@angular/router';

@Injectable({
providedIn: 'root'
})

export class UserService {

  constructor(private http: HttpClient, private router: Router) { }
  user(login : string):Observable<User>
  {
    const getUrl= 'http://localhost:8090/com.gestionformation/webapi/users/login/'+login;
    return this.http.get<User>(getUrl);
  }
  allUsers() {
    const getUrl= 'http://localhost:8090/com.gestionformation/webapi/users';
      return this.http.get(getUrl);
  }
  deleteUser(login : string): Observable<{}>
  {
    const url= 'http://localhost:8090/com.gestionformation/webapi/users/deleteUser/'+login;
    return this.http.delete<User>(url);
  }
  addUser(user : User): Observable<User>
  {
    const postUrl='http://localhost:8090/com.gestionformation/webapi/users/addUser?login='+ user.login +'&password=' +user.password +'&nom='+user.nom+'&cin='+user.cin+'&email='+user.email+"&date_naiss="+user.date_naiss;
    return this.http.post<User>(postUrl, user);
  }
  modifierUser(user : User): Observable<User>
  {
    const putUrl='http://localhost:8090/com.gestionformation/webapi/users/updateUser/'+ user.login +'?nom='+user.nom+'&email='+user.email;
    return this.http.put<User>(putUrl,user);
  }
}
