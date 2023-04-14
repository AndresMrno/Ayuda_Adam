import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpleadoCrudInventarioComponent } from './empleado-crud-inventario.component';

describe('EmpleadoCrudInventarioComponent', () => {
  let component: EmpleadoCrudInventarioComponent;
  let fixture: ComponentFixture<EmpleadoCrudInventarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpleadoCrudInventarioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpleadoCrudInventarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
