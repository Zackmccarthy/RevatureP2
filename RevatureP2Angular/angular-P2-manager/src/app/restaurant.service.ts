import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  apiUrl: string="http://localhost:8080/api/manager-restaurant"

  constructor(
    private httpClient: HttpClient
  ) { }

  getRestaurants(user_id: number) {
    return this.httpClient.get(`${this.apiUrl}/${user_id}`)
  }

}
