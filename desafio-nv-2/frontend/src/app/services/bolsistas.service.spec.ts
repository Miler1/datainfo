import { TestBed } from '@angular/core/testing';

import { BolsistasService } from './bolsistas.service';

describe('BolsistasService', () => {
  let service: BolsistasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BolsistasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
