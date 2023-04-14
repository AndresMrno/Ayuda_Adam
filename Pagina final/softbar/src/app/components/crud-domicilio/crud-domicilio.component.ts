import { Component, OnInit } from '@angular/core';
import { DomicilioService } from 'src/app/services/domicilio/domicilio.service';
import { Domicilio } from 'src/app/models/Domicilio/domicilio';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-crud-domicilio',
  templateUrl: './crud-domicilio.component.html',
  styleUrls: ['./crud-domicilio.component.scss']
})
export class CrudDomicilioComponent implements OnInit {

  domicilios : Domicilio[] = [];
  snack: any;

  constructor(private domicilioService : DomicilioService) { }

  ngOnInit(): void {

    this.domicilioService.getDomicilio()
    .subscribe(response => this.domicilios=response);


  }

  eliminarDomicilio(id_domicilio){
    this.domicilioService.eliminarDomicilio(id_domicilio)
    .subscribe(response =>{
      if(response===true){
        this.domicilios.pop();
      }
      Swal.fire('Domicilio cancelado','Usuario registrado con exito en el sistema','success');
    })
  }

}
