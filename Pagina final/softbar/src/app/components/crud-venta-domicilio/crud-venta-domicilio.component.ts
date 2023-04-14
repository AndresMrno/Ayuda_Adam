import { Component, OnInit } from '@angular/core';
import { VentaDomicilio } from 'src/app/models/venta/venta-domicilio';
import { VentaDomicilioService } from 'src/app/services/venta/venta-domicilio.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-crud-venta-domicilio',
  templateUrl: './crud-venta-domicilio.component.html',
  styleUrls: ['./crud-venta-domicilio.component.scss']
})
export class CrudVentaDomicilioComponent implements OnInit {

  ventaDomicilios : VentaDomicilio[] = [];

  constructor(private ventaDomicilioService : VentaDomicilioService) { }

  ngOnInit(): void {

    this.ventaDomicilioService.getVentaDomicilio()
    .subscribe(response => this.ventaDomicilios=response);

  }

  eliminarVentaDomicilio(id_venta_domicilio){
    this.ventaDomicilioService.eliminarVentaDomicilio(id_venta_domicilio)
    .subscribe(response =>{
      if(response===true){
        this.ventaDomicilios.pop();
      }
      Swal.fire('Venta Eliminada','Venta eliminada con exito','success');
    })
  }

}
