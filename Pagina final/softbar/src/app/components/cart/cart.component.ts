import { Component, OnInit } from '@angular/core';
import { PedidoService } from 'src/app/services/domicilio/pedido.service';
import { ProductoService } from 'src/app/services/inventario/producto.service';



@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  myCart$= this.productoService.myCart$

  constructor(private productoService: ProductoService, private pedidoService:PedidoService) { }

  ngOnInit(): void {
  }

  totalProducto(precio:number, units:number){
    return precio * units;
  }

  deleteProducto(id_producto:number){
    this.productoService.deleteProducto(id_producto);
  }

  updateProducto(operation:string, id_producto:number){
    const producto = this.productoService.findProductoById(id_producto)
    if(producto){
      if(operation === 'minus' && producto.cantidad > 0){
        producto.cantidad = producto.cantidad-1;
      }if(operation === 'add' ){
        producto.cantidad = producto.cantidad+1;
      }if(producto.cantidad ===0){
        this.deleteProducto(id_producto);
      }
      
    }
  }

  totalCart(){
    const result = this.productoService.totalCart();
    return result
  }
}
