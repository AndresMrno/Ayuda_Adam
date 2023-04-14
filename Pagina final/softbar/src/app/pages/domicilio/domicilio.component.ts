import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Producto } from 'src/app/models/inventario/producto';
import { ProductoService } from 'src/app/services/inventario/producto.service';

@Component({
  selector: 'app-domicilio',
  templateUrl: './domicilio.component.html',
  styleUrls: ['./domicilio.component.scss']
})
export class DomicilioComponent implements OnInit {

  @ViewChild ('divMap') divMap!: ElementRef;
  @ViewChild ('inputPlaces') inputPlaces!: ElementRef;

  myCart$= this.productoService.myCart$
  producto: Producto [] = [];

  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
  }

  totalCart(){
    const result = this.productoService.totalCart();
    return result
  }

}
