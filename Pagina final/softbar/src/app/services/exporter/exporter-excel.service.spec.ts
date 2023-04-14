import { TestBed } from '@angular/core/testing';

import { ExporterExcelService } from './exporter-excel.service';

describe('ExporterExcelService', () => {
  let service: ExporterExcelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExporterExcelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
