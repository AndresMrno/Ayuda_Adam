import { Domicilio } from "../Domicilio/domicilio";
import { FormaPago } from "./forma-pago";

export class VentaDomicilio {

    id_venta_domicilio : number;
    valor_total : number;
    id_domicilio_fk: Domicilio;
    id_forma_pago : FormaPago;
}


