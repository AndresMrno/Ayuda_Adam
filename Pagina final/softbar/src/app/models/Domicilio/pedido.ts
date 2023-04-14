import { Producto } from "../inventario/producto";
import { Usuario } from "../usuario";

export class Pedido {

    id_pedido : number;
    precio : number;
    cantidad : number;
    total : number
    id_usuario_fk : Usuario;
    id_productos_fk : Producto;
}
