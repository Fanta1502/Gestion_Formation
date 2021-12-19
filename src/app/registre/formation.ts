import { Formateur } from "./formateur";

export class Formation
{
    id:string;
    intitule:string;
    description:string;
    formateur:Formateur;
    dateform:Date;
    nbPlace:number;
    nbReservation:number;
    prix:number;
    score:number;
    nbScore:number;
}