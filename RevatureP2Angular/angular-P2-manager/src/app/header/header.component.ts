import { Component, OnInit } from '@angular/core';
import { RestaurantService } from '../restaurant.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  restaurant: any = {}

  constructor(
    private restaurantService: RestaurantService
  ) { }

  ngOnInit(): void {
    this.restaurantService.getRestaurants(2)
    .subscribe((requests: any) => {
      this.restaurant = requests
    })
  }

}
