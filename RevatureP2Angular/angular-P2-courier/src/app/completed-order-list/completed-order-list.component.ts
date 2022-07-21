import { Component, OnInit } from '@angular/core';
import { CompletedOrderService } from '../completed-order.service';
import { OrdersListService } from '../orders-list.service';

@Component({
  selector: 'app-completed-order-list',
  templateUrl: './completed-order-list.component.html',
  styleUrls: ['./completed-order-list.component.css']
})
export class CompletedOrderListComponent implements OnInit {

  completedOrders: any = {}

  constructor(
    private completedListService: CompletedOrderService
  ) { }

  ngOnInit(): void {
    this.completedListService.getOrders(3)
    .subscribe((requests: any) => {
      this.completedOrders = requests
    })
  }

}
