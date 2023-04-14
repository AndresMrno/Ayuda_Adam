import { Component, OnInit,  EventEmitter, Output } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Cancha } from 'src/app/models/cancha';
import { Reserva } from 'src/app/models/reserva';
import { Usuario } from 'src/app/models/usuario';

import { ReservaService } from 'src/app/services/reserva/reserva.service';
import Swal from 'sweetalert2';






@Component({
  selector: 'app-reserva',
  templateUrl: './reserva.component.html',
  styleUrls: ['./reserva.component.scss']
})


export class ReservaComponent implements OnInit {

  reserva : Reserva = new Reserva();
  canchas: Cancha[] = [];
  usuarios : Usuario[] = [];



  
  constructor(private reservaService: ReservaService, private snack: MatSnackBar, private activatedRoute:ActivatedRoute) { }
  ngOnInit(): void {

  }

  crearReserva(){
    this.reservaService.crearReserva(this.reserva)
    .subscribe(Response =>{
      Swal.fire('Reserva agregada','Reserva agregada con exito','success')
    })
  }

  actualizarReserva(){
    this.reservaService.actualizarReserva(this.reserva)
    .subscribe(response =>{
      
      Swal.fire('Reserva Actualizada','Reserva actualizada con exito','success');
      })
      
    }
}
