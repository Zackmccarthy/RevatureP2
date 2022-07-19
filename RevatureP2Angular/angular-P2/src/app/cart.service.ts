import { HttpClient } from '@angular/common/http';
import { ConstantPool } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartStream = new BehaviorSubject<any>([])

  apiUrl: string="http://localhost:8080/add-new-order/"

  cart: any = {}

  total = 0

  cartIds: any[] = []

  addToCart(item : any, qty: number): void {
    let {menu_id} = item
    let {price} = item
    let cartItems = this.cart[menu_id]
    if (!cartItems) {
      cartItems = {item, quantity: qty}
      this.total += price
    }
    else {
      cartItems = {...cartItems, quantity:cartItems.quantity + qty}
      this.total += price * qty
    }
    if(cartItems.quantity === 0) {
      delete this.cart[menu_id];
      this.total = 0
    }
    else {
      this.cart[menu_id] = cartItems;
    }
      console.log(this.cart)
      console.log(this.total)
      this.cartStream.next(this.cart)
  }

  clearCart() {
    this.cart = {}
    this.total = 0
    return this.cartStream.next(this.cart)
  }

  getTotal() {
    return this.cartStream.next(this.total)
  }

  // postNewOrder(newOrder: any) {
  //   return this.httpClient.post(this.apiUrl, newOrder)
  // }

  postNewOrder(total: number, selected: string, cartIds: [{}]) {
    console.log("selected" + selected)
    return this.httpClient.post(this.apiUrl, {"price":total, "payment_type": selected, "menus": cartIds})
  }

  constructor(
    private httpClient: HttpClient
  ) { }
}
