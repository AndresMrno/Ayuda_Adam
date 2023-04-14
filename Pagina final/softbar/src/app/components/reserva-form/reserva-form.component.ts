import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Cancha } from 'src/app/models/cancha';
import { Reserva } from 'src/app/models/reserva';
import { Usuario } from 'src/app/models/usuario';
import { ReservaService } from 'src/app/services/reserva/reserva.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-reserva-form',
  templateUrl: './reserva-form.component.html',
  styleUrls: ['./reserva-form.component.scss']
})
export class ReservaFormComponent implements OnInit {

  reserva : Reserva = new Reserva();
  canchas: Cancha[] = [];
  usuarios : Usuario[] = [];

  constructor(private reservaService: ReservaService, private snack: MatSnackBar, private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {

    this.reservaService.getCancha()
    .subscribe(response => this.canchas=response);

    this.reservaService.getUsuario()
    .subscribe(response => this.usuarios=response);

    this.activatedRoute.params
    .subscribe(params=>{
      let id_reserva : number = params['id_reserva'];
      if(id_reserva){
        this.reservaService.obtenerReserva(id_reserva)
        .subscribe(response =>this.reserva= response)
      }
    })
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


