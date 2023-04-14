
import { Time } from "@angular/common";
import { Cancha } from "./cancha";
import { Usuario } from "./usuario";

export class Reserva {

id_reserva : number;
numero_personas : number;
fecha : Date;
hora : string;
id_cancha : Cancha;
id_usuario : Usuario;


}
