import { TestBed } from '@angular/core/testing';

import { VentaDomicilioService } from './venta-domicilio.service';

describe('VentaDomicilioService', () => {
  let service: VentaDomicilioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VentaDomicilioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
