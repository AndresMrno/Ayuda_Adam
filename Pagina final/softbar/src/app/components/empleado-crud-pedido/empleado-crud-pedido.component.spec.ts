import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpleadoCrudPedidoComponent } from './empleado-crud-pedido.component';

describe('EmpleadoCrudPedidoComponent', () => {
  let component: EmpleadoCrudPedidoComponent;
  let fixture: ComponentFixture<EmpleadoCrudPedidoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpleadoCrudPedidoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpleadoCrudPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
