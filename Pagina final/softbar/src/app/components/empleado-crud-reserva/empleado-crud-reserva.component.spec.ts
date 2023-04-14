import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpleadoCrudReservaComponent } from './empleado-crud-reserva.component';

describe('EmpleadoCrudReservaComponent', () => {
  let component: EmpleadoCrudReservaComponent;
  let fixture: ComponentFixture<EmpleadoCrudReservaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpleadoCrudReservaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpleadoCrudReservaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
