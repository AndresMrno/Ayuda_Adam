import { Producto } from "./producto";

export class Inventario {

    id_inventario : number;
    fecha_ingreso : Date;
    fecha_vencimiento : Date;
    cantidad_existente : number;
    nota : string;
    id_producto_fk : Producto;
}
