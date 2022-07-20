import { Component, OnInit } from '@angular/core';
import { AcceptedOrdersService } from '../accepted-orders.service';

@Component({
  selector: 'app-accepted-order-list',
  templateUrl: './accepted-order-list.component.html',
  styleUrls: ['./accepted-order-list.component.css']
})
export class AcceptedOrderListComponent implements OnInit {

  acceptedOrders = {}

  constructor(
    private acceptedOrdersService: AcceptedOrdersService
  ) { }

  ngOnInit(): void {
    this.acceptedOrdersService.getOrders(3)
    .subscribe((requests: any) => {
      this.acceptedOrders = requests
    })
  }

}
