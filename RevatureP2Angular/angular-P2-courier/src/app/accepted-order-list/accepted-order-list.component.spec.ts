import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcceptedOrderListComponent } from './accepted-order-list.component';

describe('AcceptedOrderListComponent', () => {
  let component: AcceptedOrderListComponent;
  let fixture: ComponentFixture<AcceptedOrderListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AcceptedOrderListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AcceptedOrderListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
