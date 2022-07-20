import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundComponent } from './not-found/not-found.component';
import { OrdersListComponent } from './orders-list/orders-list.component';
import { OrdersComponent } from './orders/orders.component';
import { AcceptedOrderComponent } from './accepted-order/accepted-order.component';
import { OrdersDeliveredComponent } from './orders-delivered/orders-delivered.component';
import { AcceptedOrderListComponent } from './accepted-order-list/accepted-order-list.component';


const routes: Routes=[
  {path:'',component:OrdersListComponent,pathMatch:'full'},
  {path:'accepted-order-list', component: AcceptedOrderListComponent},
  {path:'delivered-orders', component: OrdersDeliveredComponent},
  {path:'**',component:NotFoundComponent}
]

@NgModule({
  declarations:[
    OrdersListComponent,
    OrdersComponent,
    NotFoundComponent,
    AcceptedOrderListComponent,
    AcceptedOrderComponent,
    OrdersDeliveredComponent
  ],
  imports: [RouterModule.forRoot(routes), CommonModule, ReactiveFormsModule, FormsModule],
  exports: [RouterModule]
})

export class AppRoutingModule { }
