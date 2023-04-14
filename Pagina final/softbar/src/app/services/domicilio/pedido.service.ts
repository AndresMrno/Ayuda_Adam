import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pedido } from 'src/app/models/Domicilio/pedido';
import { Producto } from 'src/app/models/inventario/producto';
import { Usuario } from 'src/app/models/usuario';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  url: String = 'http://localhost:8083/pedido';


  constructor(private http: HttpClient) { }


  getPedido(): Observable<Pedido[]>{
    return this.http.get<Pedido[]>(this.url + '/listar');
  }

  getUsuario(): Observable<Usuario[]>{
    return this.http.get<Usuario[]>(this.url + '/usuario');
  }

  getProducto(): Observable<Producto[]>{
    return this.http.get<Producto[]>(this.url + '/producto');
  }

  crearPedido(pedido : Pedido): Observable<Pedido>{
    return this.http.post<Pedido>(this.url + '/agregar', pedido);
  }

  obtenerPedido(id_pedido : number): Observable<Pedido>{
    return this.http.get<Pedido>(this.url + '/'+ id_pedido);
  }

  actualizarPedido(pedido : Pedido): Observable<Pedido>{
    return this.http.put<Pedido>(this.url + '/actualizar/' + pedido.id_pedido, pedido);
  }

  eliminarPedido(id_pedido : number): Observable<any>{
    return this.http.delete<any>(this.url + '/eliminar/' + id_pedido);
  }
}


