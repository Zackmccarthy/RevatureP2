import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-completed-order',
  templateUrl: './completed-order.component.html',
  styleUrls: ['./completed-order.component.css']
})
export class CompletedOrderComponent implements OnInit {

  @Input("value")
  completedOrders: any = {}

  courier_id = 3

  price = 0

  constructor() { }

  ngOnInit(): void {
    console.log(this.completedOrders)
    console.log(this.completedOrders.price)
    this.price = this.completedOrders.price
    console.log(this.price)
  }

}
