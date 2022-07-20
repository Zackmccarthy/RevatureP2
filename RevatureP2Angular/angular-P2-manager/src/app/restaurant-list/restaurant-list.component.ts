import { Component, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import { RestaurantService } from '../restaurant.service';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit {

  menus: any = {}

  // orders: any = {}

  // constructor(
  //   private orderListService: OrdersListService 
  // ) { }

  // ngOnInit(): void {
  //   // this.loadOrdersList()
  //   this.orderListService.getOrders("pending")
  //   .subscribe((requests: any) => {
  //     this.orders = requests
  //   })
  // }

  constructor(
    private menuService: MenuService
  ) { }

  ngOnInit(): void {
    this.menuService.getMenus(1)
    .subscribe({
      next:(response:any) => {
        this.menus = response
      },
      error: (err: any) => {
        console.log(err)
      }
    })
  }

  // loadRestaurants() {
  //   this.restaurantService.getRestaurants(2)
  //   .subscribe({
  //     next:(response:any) => {
  //       this.restaurants = response
  //     },
  //     error: (err: any) => {
  //       console.log(err)
  //     }
  //   })
  // }

}