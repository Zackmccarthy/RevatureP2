import { TestBed } from '@angular/core/testing';

import { AcceptedOrdersService } from './accepted-orders.service';

describe('AcceptedOrdersService', () => {
  let service: AcceptedOrdersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AcceptedOrdersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
