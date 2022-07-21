import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EditItemService {

  apiUrl: string="http://localhost:8080/edit-menu-item"

  apiUrlGet: string = "http://localhost:8080/api/menu"

  constructor(
    private httpClient: HttpClient
  ) { }

  getItem(menuId: number) {
    return this.httpClient.get(`${this.apiUrlGet}/${menuId}`)
  }

  saveItem(menuId: number, menuItem: any) {
    return this.httpClient.patch(`${this.apiUrl}/${menuId}`, menuItem)
  }
}
