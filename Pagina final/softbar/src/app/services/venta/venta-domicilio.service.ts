import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Domicilio } from 'src/app/models/Domicilio/domicilio';
import { FormaPago } from 'src/app/models/venta/forma-pago';
import { VentaDomicilio } from 'src/app/models/venta/venta-domicilio';

@Injectable({
  providedIn: 'root'
})
export class VentaDomicilioService {

  url: String = 'http://localhost:8083/ventaDomicilio';

  constructor(private http: HttpClient) { }

  getVentaDomicilio(): Observable<VentaDomicilio[]>{
    return this.http.get<VentaDomicilio[]>(this.url + '/listar' );
  }

  getDomicilio(): Observable<Domicilio[]>{
    return this.http.get<Domicilio[]>(this.url + '/domicilio' );
  } 


  getForma(): Observable<FormaPago[]>{
    return this.http.get<FormaPago[]>(this.url + '/forma' );
  } 

  crearVentaDomicilio(ventaDomicilio : VentaDomicilio): Observable<VentaDomicilio> {
    return this.http.post<VentaDomicilio>(this.url + '/agregar', ventaDomicilio);
  }

  obtenerVentaDomicilio(id_venta_domicilio: number): Observable<VentaDomicilio> {
    return this.http.get<VentaDomicilio>(this.url + '/' + id_venta_domicilio);
  }

  actualizarVentaDomicilio(ventaDomicilio: VentaDomicilio): Observable<VentaDomicilio> {
    return this.http.put<VentaDomicilio>(this.url + '/actualizar/' + ventaDomicilio.id_venta_domicilio, ventaDomicilio)
  }

  eliminarVentaDomicilio(id_venta_domicilio: number): Observable<any> {
    return this.http.delete<any>(this.url + '/eliminar/' + id_venta_domicilio);
  }


}
