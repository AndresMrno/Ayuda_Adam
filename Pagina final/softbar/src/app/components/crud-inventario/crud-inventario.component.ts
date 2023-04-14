import { Component, OnInit } from '@angular/core';
import { Inventario } from 'src/app/models/inventario/inventario';
import { InventarioService } from 'src/app/services/inventario/inventario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-crud-inventario',
  templateUrl: './crud-inventario.component.html',
  styleUrls: ['./crud-inventario.component.scss']
})
export class CrudInventarioComponent implements OnInit {

  inventarios  : Inventario[] = [];
  

  constructor(private inventarioService: InventarioService) { }

  ngOnInit(): void {

    this.inventarioService.getInventario()
    .subscribe(response => this.inventarios=response);
  }

  eliminarInventario(id_inventario){
    this.inventarioService.eliminarUsuario(id_inventario)
    .subscribe(response =>{
      if(response ===true){
        this.inventarios.pop();
      }
      Swal.fire('Inventario Eliminado','Inventario eliminado con exito','success');
    })
  }

}
