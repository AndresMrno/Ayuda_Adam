import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/inventario/producto';
import { ProductoService } from 'src/app/services/inventario/producto.service';

@Component({
  selector: 'app-venta',
  templateUrl: './venta.component.html',
  styleUrls: ['./venta.component.scss']
})
export class VentaComponent implements OnInit {

  producto: Producto[]=[];

  constructor(private productoService: ProductoService) { }

  viewCart: boolean = false;

  ngOnInit(): void {

    this.productoService.getProducto()
    .subscribe((data)=>{this.producto = data})
    console.log(this.producto)
  }


  onToggleCart(){
    this.viewCart = !this.viewCart
  }

}
