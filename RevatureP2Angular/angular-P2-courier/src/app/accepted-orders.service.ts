import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AcceptedOrdersService {

  apiUrl: string="http://localhost:8080/api/orders/courier"

  constructor(
    private httpClient: HttpClient
  ) { }

  getOrders(courier_id: number): any {
    return this.httpClient.get(`${this.apiUrl}/${courier_id}`)
  }
}
