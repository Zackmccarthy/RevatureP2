import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

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

  menuItems = [
    {
      name: "VEG",
      price: 100.00,
      currencyCode: 'USD',
      description: 'Veg is always yummy',
      isAvailable: true,
      imgPath: "assets/veg.png",
      makeDate: Date.now()
    },
    {
      name: "Non-VEG",
      price: 200.00,
      offPrice: 10,
      description: 'Non-veg is not always yummy',
      isAvailable: true,
      imgPath: "assets/non-veg.jpg",
      makeDate: Date.now()
    },
  ]

  restaurants: Restaurant[] = [];
  constructor(
    private httpClient: HttpClient
  ) { }

  ngOnInit(): void {
    this.getRestaurant();
  }

  getRestaurant() {
    this.httpClient.get<any>('http://localhost:8080/api/restaurants').subscribe(
      response => {
        console.log(response);
        this.restaurants = response;
      }
    );
  }

}
