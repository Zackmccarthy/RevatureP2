import { Component, Input, OnInit } from '@angular/core';
import { OrdersListService } from '../orders-list.service';

@Component({
  selector: 'app-accepted-order',
  templateUrl: './accepted-order.component.html',
  styleUrls: ['./accepted-order.component.css']
})
export class AcceptedOrderComponent implements OnInit {

  @Input("value")
  acceptedOrders: any = {}

  courier_id = 3

  constructor(
    private orderListService: OrdersListService
  ) { }

  ngOnInit(): void {
    console.log(this.acceptedOrders)
  }

  completeOrder() {
    var id = this.acceptedOrders.order_id
    console.log("complete")
    this.orderListService.completeOrder(id, this.courier_id)
    .subscribe({
      next: (response: any) => {
        console.log(response)
      }
    })
  }

}
