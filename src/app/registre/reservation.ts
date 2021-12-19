import { Formation } from "./formation";
import { User } from "./user";

export class Reservation
{
    id:string;
    etat:number;
    util:User;
    form:Formation;
}