import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpleadoCrudDomicilioComponent } from './empleado-crud-domicilio.component';

describe('EmpleadoCrudDomicilioComponent', () => {
  let component: EmpleadoCrudDomicilioComponent;
  let fixture: ComponentFixture<EmpleadoCrudDomicilioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpleadoCrudDomicilioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpleadoCrudDomicilioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
