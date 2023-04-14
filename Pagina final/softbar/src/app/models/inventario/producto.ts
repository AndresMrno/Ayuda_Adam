import { Categoria } from "./categoria";

export class Producto {

    id_producto : number;
    nombre_producto : string;
    id_categoria : Categoria;
    precio : number;
    descripcion: string;
    cantidad: number;
}

