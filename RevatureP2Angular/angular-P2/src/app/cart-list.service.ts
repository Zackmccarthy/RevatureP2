import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartListService {

  items = []


  constructor() { }

  getItems() {
    return this.items
  }
}
