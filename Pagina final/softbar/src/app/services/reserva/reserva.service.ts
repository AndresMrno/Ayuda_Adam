import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cancha } from 'src/app/models/cancha';
import { Reserva } from 'src/app/models/reserva';
import { Usuario } from 'src/app/models/usuario';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {

  url: String = 'http://localhost:8083/reserva';

  constructor(private http: HttpClient) { }

    getReserva(): Observable<Reserva[]>{
      return this.http.get<Reserva[]>(this.url+'/listaReserva');
    }
    getUsuario(): Observable<Usuario[]>{
      return this.http.get<Usuario[]>(this.url+'/usuarios');
    }

    getCancha(): Observable <Cancha[]>{
      return this.http.get<Cancha[]>(this.url+'/cancha');
    }

    crearReserva(reserva : Reserva): Observable<Reserva>{
      return this.http.post<Reserva>(this.url+'/crear',reserva);
    }

    obtenerReserva(id_reserva:number): Observable<Reserva>{
      return this.http.get<Reserva>(this.url+'/'+id_reserva);
    }

    actualizarReserva(reserva : Reserva):Observable<Reserva>{
      return this.http.put<Reserva>(this.url+'/actualizar/'+reserva.id_reserva, reserva);
    }

    eliminarUsuario(id_reserva: number): Observable<any>{
      return this.http.delete<any>(this.url+'/eliminar/'+id_reserva);
    }
}
