import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RestaurantService } from '../restaurant.service';

export class Restaurant {
  constructor(
    public id: number,
    public restaurantName: string
  ) {
  }
}

@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.scss']
})
export class MenuListComponent implements OnInit {

  restaurants: Restaurant[] = [];
  constructor(
    private restaurantService: RestaurantService
  ) { }

  ngOnInit(): void {
    this.getRestaurant();
  }

  getRestaurant() {
    this.restaurantService.getRestaurants()
    .subscribe({
      next:(response:any) => {
        this.restaurants = response
      },
      error: (err: any) => {
        console.log(err)
      }
    })
  }

}
