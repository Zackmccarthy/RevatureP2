import { keyframes } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.scss']
})
export class CartListComponent implements OnInit {

  cart: any={}

  cartIds: any = [{}]

  newCartIds: any = []

  total = 0

  itemForm!: FormGroup

  constructor(private cartService : CartService,
    private fb:FormBuilder
    ) { }

  ngOnInit(): void {
    this.cartService.cartStream.subscribe({
      next: cart => {
        this.cart = this.cartService.cart
        this.total = this.cartService.total
        this.cartIds = Object.keys(this.cartService.cart)
      }
    })
    this.itemForm = this.fb.group({
      type: ['']
    })
  }

  clearItems() {
    console.log(this.cartIds)
    this.cartService.clearCart()
    console.log(this.cartIds)
  }

  // var data = {total: this.total, selected: this.selected}

  handleSubmit() {
    for (let key of this.cartIds) {
      this.newCartIds.push({"menu_id" : key})
    }
    this.cartService.postNewOrder(this.total, this.selected, this.newCartIds)
    .subscribe({
      next: (response:any) => {
        console.log(response)
      }
    })
  }

  paymentTypes = ['CREDIT', 'DEBIT', 'PAY AT STORE']

  selected: string = "CREDIT"

}
