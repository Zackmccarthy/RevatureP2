import { NgModule } from "@angular/core";
import { RouterModule, Routes } from '@angular/router';
import { SidebarNavComponent } from './sidebar-nav/sidebar-nav.component';
import { HeaderComponent } from './header/header.component';
import { MenuListComponent } from './menu-list/menu-list.component';
import { MenuItemComponent } from './menu-item/menu-item.component';
import {HttpClientModule} from '@angular/common/http';
import { ItemsComponent } from './items/items.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { AppComponent } from "./app.component";
import {CommonModule} from "@angular/common";
import { ItemsListComponent } from "./items-list/items-list.component";
import { CartListComponent } from "./cart-list/cart-list.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

const routes: Routes=[
    {path:'',component:MenuListComponent,pathMatch:'full'},
    {path:'items/:id',component:ItemsListComponent},
    {path:'cart', component: CartListComponent},
    {path:'**',component:NotFoundComponent}
  ]

  @NgModule({
    declarations:[
        MenuItemComponent,
        MenuListComponent,
        ItemsComponent,
        NotFoundComponent,
        ItemsListComponent,
        CartListComponent
    ],
    imports: [RouterModule.forRoot(routes), CommonModule, ReactiveFormsModule, FormsModule],
    exports: [RouterModule]
  })

  export class AppRoutingModule {

  }