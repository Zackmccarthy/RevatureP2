import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CompletedOrderService {

  apiUrl: string="http://localhost:8080/api/orders/courier-completed"

  constructor(
    private httpClient: HttpClient
  ) { }

  getOrders(courier_id: number): any {
    return this.httpClient.get(`${this.apiUrl}/${courier_id}`)
  }
}
