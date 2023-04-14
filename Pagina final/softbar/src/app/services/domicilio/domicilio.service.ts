import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Domicilio } from 'src/app/models/Domicilio/domicilio';
import { Pedido } from 'src/app/models/Domicilio/pedido';
import baserUrl from '../helper';

@Injectable({
  providedIn: 'root'
})
export class DomicilioService {

  url: String = 'http://localhost:8083/domicilio';


  constructor(private http: HttpClient) { }

  getDomicilio(): Observable<Domicilio[]>{
    return this.http.get<Domicilio[]>(this.url + '/listar');
  }

  getPedido(): Observable<Pedido[]> {
    return this.http.get<Pedido[]>(this.url + '/pedido')
  }

  public CancelarDomicilio(domicilio ){
    return this.http.post(`${baserUrl}/domicilio/cancelado`,domicilio);
  }

  crearDomicilio(domicilio: Domicilio): Observable<Domicilio> {
    return this.http.post<Domicilio>(this.url + '/agregar', domicilio);
  }

  obtenerDomicilio(id_domicilio: number): Observable<Domicilio> {
    return this.http.get<Domicilio>(this.url + '/' + id_domicilio);
  }

  actualizarDomicilio(domicilio: Domicilio): Observable<Domicilio> {
    return this.http.put<Domicilio>(this.url + '/actualizar/' + domicilio.id_domicilio, domicilio)
  }

  eliminarDomicilio(id_domicilio: number): Observable<any> {
    return this.http.delete<any>(this.url + '/eliminar/' + id_domicilio);
  }

}
