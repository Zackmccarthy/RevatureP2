import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  cartSize = 0

  constructor(private cartService : CartService) {
  }

  ngOnInit(): void {
    this.cartService.cartStream.subscribe({
      next:cart=> {
        this.cartSize = Object.keys(cart).length
      }
    })
  }

}
