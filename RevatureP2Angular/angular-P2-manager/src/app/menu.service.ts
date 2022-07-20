import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  apiUrl: string = "http://localhost:8080/api/menus"

  constructor(
    private httpClient: HttpClient
  ) { }

  getMenus(user_id: number) {
    return this.httpClient.get(`${this.apiUrl}/${user_id}`)
  }
}
