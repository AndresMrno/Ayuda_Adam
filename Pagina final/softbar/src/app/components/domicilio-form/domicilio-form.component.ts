import { Component, OnInit } from '@angular/core';
import { DomicilioService } from 'src/app/services/domicilio/domicilio.service';
import { Domicilio } from 'src/app/models/Domicilio/domicilio';
import { Rol } from 'src/app/models/rol';
import { ActivatedRoute } from '@angular/router';
import { Pedido } from 'src/app/models/Domicilio/pedido';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-domicilio-form',
  templateUrl: './domicilio-form.component.html',
  styleUrls: ['./domicilio-form.component.scss']
})
export class DomicilioFormComponent implements OnInit {

  domicilio : Domicilio = new Domicilio();
  pedidos: Pedido[] = []
  snack: any;

  constructor(private domicilioService: DomicilioService, private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {

    this.domicilioService.getPedido()
    .subscribe(response => this.pedidos=response);


    this.activatedRoute.params
    .subscribe(params=>{
      let id_domicilio : number = params['id_domicilio'];
      if(id_domicilio){
        this.domicilioService.obtenerDomicilio(id_domicilio)
        .subscribe(response =>this.domicilio = response)
      }
    })
  }

  crearDomicilio(){
    this.domicilioService.crearDomicilio(this.domicilio)
    .subscribe(response =>
      Swal.fire('Usuario creado','Usuario creado con exito','success')
    
    )
  }

  actualizarDomicilio(){
    this.domicilioService.actualizarDomicilio(this.domicilio)
    .subscribe(response =>{
      Swal.fire('Domicilio Actualizado','Domicilio actualizado con exito','success');
    })
  }

  

}
