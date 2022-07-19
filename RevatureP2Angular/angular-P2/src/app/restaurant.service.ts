import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  apiUrl: string="http://localhost:8080/api/restaurants"

  constructor(
    private httpClient:HttpClient
  ) { }

  getRestaurants() {
    return this.httpClient.get(`${this.apiUrl}`)
  }
}
