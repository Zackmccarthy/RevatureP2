import { TestBed } from '@angular/core/testing';

import { CompletedOrderService } from './completed-order.service';

describe('CompletedOrderService', () => {
  let service: CompletedOrderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompletedOrderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
