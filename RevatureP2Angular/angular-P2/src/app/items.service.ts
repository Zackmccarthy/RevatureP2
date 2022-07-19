import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  apiUrl: string = "http://localhost:8080/api/menus"

  constructor(
    private httpClient:HttpClient
  ) { }

  getItems(id: number) {
    return this.httpClient.get(`${this.apiUrl}/${id}`)
  }
}
