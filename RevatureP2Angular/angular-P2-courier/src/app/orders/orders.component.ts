import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OrdersListService } from '../orders-list.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  @Input("value")
  orders: any = {}

  constructor(
    private route: ActivatedRoute,
    private orderListService: OrdersListService
  ) { }

  currentTab = 1

  courier_id = 3

  handleTabChange(event: Event, tabIndex: number) {
    this.currentTab = tabIndex
    console.log(this.currentTab)
  }

  isTabSelected(tabIndex: number) {
    return this.currentTab === tabIndex
  }

  acceptOrder() {
    var id = this.orders.order_id
    console.log("approve")
    this.orderListService.acceptOrder(id, this.courier_id)
    .subscribe({
      next: (response: any) => {
        console.log(response)
      }
    })
  }

  ngOnInit(): void {
  }

}
