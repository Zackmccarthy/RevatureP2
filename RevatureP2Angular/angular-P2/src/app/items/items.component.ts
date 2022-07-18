import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Observable } from 'rxjs';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.scss']
})

export class ItemsComponent implements OnInit {

  @Input("value")
  items: any = {}

  @Output()
  buy = new EventEmitter()

  currentTab = 1

  cartQuantity = 0

  isZero = false

  handleCartQuantity(quantity: number) {
    this.cartService.addToCart(this.items, quantity)
  }

  handleBuy() {
    console.log("buy")
    // this.buy.emit({...this.items})
    this.cartService.addToCart(this.items, 1)
  }

  handleTabChange(event: Event, tabIndex: number) {
    this.currentTab = tabIndex
    console.log(this.currentTab)
  }

  isTabSelected(tabIndex: number) {
    return this.currentTab === tabIndex
  }

  constructor(private cartService : CartService) { }

  ngOnInit(): void {
    this.cartService.cartStream.subscribe({
      next:cart=> {
        let cartItems = cart[this.items.menu_id]
        if (cartItems) {
          this.cartQuantity = cartItems.quantity
          this.isZero = false
        }
        else {
          this.cartQuantity = 0
          this.isZero = true
        }
      }
    })
  }

}
