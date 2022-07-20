import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddItemService {

  apiUrl: string="http://localhost:8080/add-menu-item"

  constructor(
    private httpClient: HttpClient
  ) { }

  saveItem(menuItem: any) {
    return this.httpClient.post(`${this.apiUrl}/${menuItem.restaurant_id}`, menuItem)
  }
}
