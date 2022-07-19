import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SidebarNavComponent } from './sidebar-nav/sidebar-nav.component';
import { HeaderComponent } from './header/header.component';
import { MenuListComponent } from './menu-list/menu-list.component';
import { MenuItemComponent } from './menu-item/menu-item.component';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule, Routes} from "@angular/router";
import { ItemsComponent } from './items/items.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { AppRoutingModule } from './app-routing.module';
import { ItemsListComponent } from './items-list/items-list.component';
import { CartComponent } from './cart/cart.component';
import { CartListComponent } from './cart-list/cart-list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    SidebarNavComponent,
    HeaderComponent,
    CartComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
