import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpleadoCrudUsuarioComponent } from './empleado-crud-usuario.component';

describe('EmpleadoCrudUsuarioComponent', () => {
  let component: EmpleadoCrudUsuarioComponent;
  let fixture: ComponentFixture<EmpleadoCrudUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpleadoCrudUsuarioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpleadoCrudUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
