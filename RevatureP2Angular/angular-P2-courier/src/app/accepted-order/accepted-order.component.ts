import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-accepted-order',
  templateUrl: './accepted-order.component.html',
  styleUrls: ['./accepted-order.component.css']
})
export class AcceptedOrderComponent implements OnInit {

  @Input("value")
  acceptedOrders = {}

  constructor() { }

  ngOnInit(): void {
  }

}
