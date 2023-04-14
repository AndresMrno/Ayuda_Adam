import { Component } from '@angular/core';
import { Domicilio } from 'src/app/models/Domicilio/domicilio';
import { Pedido } from 'src/app/models/Domicilio/pedido';
import { Inventario } from 'src/app/models/inventario/inventario';
import { PedidoService } from 'src/app/services/domicilio/pedido.service';
import { ProductoService } from 'src/app/services/inventario/producto.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-empleado-crud-inventario',
  templateUrl: './empleado-crud-inventario.component.html',
  styleUrls: ['./empleado-crud-inventario.component.scss']
})
export class EmpleadoCrudInventarioComponent {

  domicilios : Domicilio[] = [];
  pedidos : Pedido[] = [];
  productos : [] = [];
 
  

  constructor(private pedidoService : PedidoService, private productoService:ProductoService) { }

  inventarios  : Inventario[] = [];

  ngOnInit(): void {

    

    this.pedidoService.getPedido()
    .subscribe(response => this.pedidos=response);
  }

  eliminarPedido(id_pedido){
    this.pedidoService.eliminarPedido(id_pedido)
    .subscribe(response=>{
      if(response===true){
        this.pedidos.pop();
      }
      Swal.fire('Pedido Eliminado','Pedido eliminado con exito','success');
    })
  }

}
