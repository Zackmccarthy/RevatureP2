import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdersListService {

  apiUrl: string="http://localhost:8080/api/orders"

  apiUrlChangeStatus: string="http://localhost:8080/change-status"

  constructor(
    private httpClient: HttpClient
  ) { }

  // cartStream = new BehaviorSubject<any>([])

  // private data$: Observable<string>

  getOrders(status: string): any {
      // return this.cartStream.next(this.httpClient.get(`${this.apiUrl}/${status}`))
      return this.httpClient.get(`${this.apiUrl}/${status}`)
    }

  acceptOrder(order_id: number, courier_id: number) {
    console.log("order_id" + order_id)
    return this.httpClient.patch(`${this.apiUrlChangeStatus}/${order_id}`, {"orderStatus": "ACCEPTED", "courier_id": courier_id})
  }

  completeOrder(order_id: number, courier_id: number) {
    return this.httpClient.patch(`${this.apiUrlChangeStatus}/${order_id}`, {"orderStatus": "COMPLETED", "courier_id": courier_id})
  }

}