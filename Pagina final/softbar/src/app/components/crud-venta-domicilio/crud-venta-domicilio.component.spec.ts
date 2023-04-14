import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudVentaDomicilioComponent } from './crud-venta-domicilio.component';

describe('CrudVentaDomicilioComponent', () => {
  let component: CrudVentaDomicilioComponent;
  let fixture: ComponentFixture<CrudVentaDomicilioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrudVentaDomicilioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CrudVentaDomicilioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
