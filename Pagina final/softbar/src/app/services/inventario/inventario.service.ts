import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Inventario } from 'src/app/models/inventario/inventario';
import { Producto } from 'src/app/models/inventario/producto';

@Injectable({
  providedIn: 'root'
})
export class InventarioService {

  url :String = 'http://localhost:8083/inventario';

  constructor(private Http:HttpClient) { }

  getInventario(): Observable<Inventario[]>{
    return this.Http.get<Inventario[]>(this.url + '/listar');
  }
  getProducto(): Observable<Producto[]>{
    return this.Http.get<Producto[]>(this.url + '/producto');
  }

  crearInventario(inventario : Inventario) : Observable<Inventario>{
    return this.Http.post<Inventario>(this.url + '/agregar', inventario);
  }
  
  obtenerInventario(id_inventario: number) : Observable<Inventario>{
    return this.Http.get<Inventario>(this.url + '/' + id_inventario);
  }
  
  actualizarInventario(inventario : Inventario) : Observable<Inventario>{
    return this.Http.put<Inventario>(this.url + '/actualizar/' + inventario.id_inventario, inventario);
  }

  eliminarUsuario(id_inventario : number) : Observable<any>{
    return this.Http.delete<any>(this.url + '/eliminar/' + id_inventario);

  }

  }

