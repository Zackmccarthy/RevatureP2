import { Component, Input, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-restaurant-item',
  templateUrl: './restaurant-item.component.html',
  styleUrls: ['./restaurant-item.component.css']
})
export class RestaurantItemComponent implements OnInit {

  @Input("value")
  menu: any = {}

  constructor(
    private menuService: MenuService
  ) { }

  currentTab = 1

  handleTabChange(event: Event, tabIndex: number) {
    this.currentTab = tabIndex
    console.log(this.currentTab)
  }

  isTabSelected(tabIndex: number) {
    return this.currentTab === tabIndex
  }

  ngOnInit(): void {
    
  }

}
