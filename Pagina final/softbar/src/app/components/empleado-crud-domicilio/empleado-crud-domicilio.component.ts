import { Component } from '@angular/core';
import { Domicilio } from 'src/app/models/Domicilio/domicilio';
import { DomicilioService } from 'src/app/services/domicilio/domicilio.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-empleado-crud-domicilio',
  templateUrl: './empleado-crud-domicilio.component.html',
  styleUrls: ['./empleado-crud-domicilio.component.scss']
})
export class EmpleadoCrudDomicilioComponent {

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
      Swal.fire('Domicilio cancelado','Domicilio cancelado con exito en el sistema','success');
    })
  }

}
