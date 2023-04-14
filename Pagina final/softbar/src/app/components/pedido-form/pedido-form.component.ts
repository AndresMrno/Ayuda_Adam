import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Pedido } from 'src/app/models/Domicilio/pedido';
import { Producto } from 'src/app/models/inventario/producto';
import { Usuario } from 'src/app/models/usuario';
import { PedidoService } from 'src/app/services/domicilio/pedido.service';
import { ProductoService } from 'src/app/services/inventario/producto.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-pedido-form',
  templateUrl: './pedido-form.component.html',
  styleUrls: ['./pedido-form.component.scss']
})
export class PedidoFormComponent implements OnInit {

  myCart$= this.productoService.myCart$

  pedido : Pedido = new Pedido();
  usuarios : Usuario[] = [];
  productos : Producto[] = [];

  constructor(private pedidoService : PedidoService, private activatedRoute: ActivatedRoute, private productoService: ProductoService) { }



  ngOnInit(): void {

    this.pedidoService.getUsuario()
    .subscribe(response => this.usuarios=response);

    this.pedidoService.getProducto()
    .subscribe(response => this.productos = response)

    this.activatedRoute.params
    .subscribe(params=>{
      let id_pedido : number = params ['id_pedido'];
      if(id_pedido){
        this.pedidoService.obtenerPedido(id_pedido)
        .subscribe(response => this.pedido = response)
      }
    })
  }

  crearPedido(){
    this.pedidoService.crearPedido(this.pedido)
    .subscribe(response =>
      Swal.fire('Pedido creado','Pedido creado con exito','success')
      )
  }

  actualizarPedido(){
    this.pedidoService.actualizarPedido(this.pedido)
    .subscribe(response =>{
      Swal.fire('Pedido Actualizado','Pedido actualizado con exito','success');
    })
  }




}
