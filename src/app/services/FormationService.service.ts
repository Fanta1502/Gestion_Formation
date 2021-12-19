import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Formation } from '../registre/formation';

@Injectable({
  providedIn: 'root'
})
export class FormationService {

  baseUrl: string = 'http://localhost:8090/com.gestionformation/webapi/formations';
  url: string = 'http://localhost:8090/com.gestionformation/webapi/formateurs';
  constructor(private http: HttpClient) { }
	//http://localhost:8090/com.gestionformation/webapi/formations/addFormation?id=fsns963&intitule=angular&formateur=ML190013&date=10/01/2022&description=apprendre&prix=100

  allFormation() {
    return this.http.get(this.baseUrl);
  }
  formation(id:string):Observable<Formation>
  {
    const url = 'http://localhost:8090/com.gestionformation/webapi/formations/formation/'+id;
    return this.http.get<Formation>(url);

  }
  allFormateur() {
    return this.http.get(this.url);
  }
  addFormation(formation: Formation,cin:String): Observable<Formation>
  {
    const url='http://localhost:8090/com.gestionformation/webapi/formations/addFormation?intitule='+formation.intitule+'&formateur='+cin+'&date='+formation.dateform+'&description='+formation.description+'&nbPlace='+formation.nbPlace+'&prix='+formation.prix; 
    return this.http.post<Formation>(url,formation);
  }
  formateur(cin :string)
  {
    const url='http://localhost:8090/com.gestionformation/webapi/formateurs/formateur/'+cin;
    return this.http.get(url);
  }
  deleteFormation(id:string): Observable<{}>
  {
    const url = 'http://localhost:8090/com.gestionformation/webapi/formations/deleteFormation/'+id;
    return this.http.delete<Formation>(url);
  }
  modifier(formation:Formation):Observable<Formation>
  {
    const url='http://localhost:8090/com.gestionformation/webapi/formations/updateFormation/'+formation.id+'?intitule='+formation.intitule+'&description='+formation.description+'&nbreReservation='+formation.nbReservation+'&prix='+formation.prix; 
    return this.http.put<Formation>(url,formation);
  }
}
