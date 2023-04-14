import { Component } from '@angular/core';
import { Reserva } from 'src/app/models/reserva';
import { ReservaService } from 'src/app/services/reserva/reserva.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-empleado-crud-reserva',
  templateUrl: './empleado-crud-reserva.component.html',
  styleUrls: ['./empleado-crud-reserva.component.scss']
})
export class EmpleadoCrudReservaComponent {

  reservas : Reserva[] = [];

  constructor(private reservaService : ReservaService) { }

  ngOnInit(): void {

    this.reservaService.getReserva()
    .subscribe(response => this.reservas = response)
  }

  eliminarReserva(id_reserva){
    this.reservaService.eliminarUsuario(id_reserva)
    .subscribe(response =>{
      if(response ===true){
        this.reservas.pop();
      }
      Swal.fire('Reserva Eliminada','Reserva eliminada con exito','success');
    })
  }

}
