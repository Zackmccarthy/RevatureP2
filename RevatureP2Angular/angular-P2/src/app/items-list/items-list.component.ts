import { HttpClient } from '@angular/common/http';
import { Location } from '@angular/common';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemsService } from '../items.service';

export class Item {
  constructor(
    public dishName: number,
    public description: string
  ) {
  }
}

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.scss']
})

export class ItemsListComponent implements OnInit {

  items: Array<any> = []

  // cart: Array<any> = []

  // cartSize = 0

  // @Output()
  // buy = new EventEmitter()

  // handleBuy(event: any) {
  //   console.log("buy-list")
  //   console.log(event)
  //   this.buy.emit(event)
  //   this.cart.push(event)
  //   this.cartSize = this.cart.length
  // }

  constructor(
    private httpClient : HttpClient,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    private itemsService : ItemsService
  ) { }

  ngOnInit(): void {
    this.loadItems();
  }

  loadItems() {
    var id = this.route.snapshot.params['id']
    this.itemsService.getItems(id)
    .subscribe({
      next: (response: any) => {
        this.items = response
      }
    })
  }
}

