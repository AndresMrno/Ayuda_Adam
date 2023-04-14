import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Inventario } from 'src/app/models/inventario/inventario';
import { Producto } from 'src/app/models/inventario/producto';
import { InventarioService } from 'src/app/services/inventario/inventario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-inventario-form',
  templateUrl: './inventario-form.component.html',
  styleUrls: ['./inventario-form.component.scss']
})
export class InventarioFormComponent implements OnInit {

  inventario : Inventario = new Inventario();
  producto: Producto = new Producto();
  productos : Producto[] = [];

  constructor(private inventarioService: InventarioService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.inventarioService.getProducto()
  .subscribe(response => this.productos=response);

  this.activatedRoute.params
  .subscribe(params=>{
    let id_inventario : number = params['id_inventario'];
    if(id_inventario){
      this.inventarioService.obtenerInventario(id_inventario)
      .subscribe(response => this.inventario    = response)
    }
  })

  }

  crearInventario(){
    this.inventarioService.crearInventario(this.inventario)
    .subscribe(response =>
      Swal.fire('Inventario creado','Inventario creado con exito','success')
      )
  }

  actualizarInventario(){
    this.inventarioService.actualizarInventario(this.inventario)
    .subscribe(response =>{
      Swal.fire('Inventario actualizado','Inventario actualizado con exito','success');
    })
  }
}
