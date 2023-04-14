import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rol } from '../../models/rol';
import { Usuario } from '../../models/usuario';
import { baserUrl } from '../helper';


@Injectable({
  providedIn: 'root',
})
export class UsuariosService {
  
  urlS: string = 'http://localhost:8083/usuario';

  urlN : string = baserUrl;

  constructor(private http: HttpClient) {}

  registrarUsuario(user) {
    return this.http.post(`${this.urlN + '/auth/register'}`, user);
  }

  getUsuario(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.urlS+'/listar');
  }

  getRol(): Observable<Rol[]> {
    return this.http.get<Rol[]>(`${this.urlS + '/rol'}`);
  }

  crearUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(this.urlS + '/agregar', usuario);
  }

  obtenerUsuario(id_usuario: number): Observable<Usuario> {
    return this.http.get<Usuario>(this.urlS + '/' + id_usuario);
  }

  actualizarUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(this.urlS + '/actualizar/' +usuario.id_usuario, usuario);
  }

  eliminarUsuario(id_usuario: number): Observable<any> {
    return this.http.delete<any>(this.urlS + '/eliminar/' + id_usuario);
  }
}
