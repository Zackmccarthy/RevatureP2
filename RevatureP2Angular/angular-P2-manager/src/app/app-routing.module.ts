import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AddItemComponent } from './add-item/add-item.component';
import { EditItemComponent } from './edit-item/edit-item.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { RestaurantItemComponent } from './restaurant-item/restaurant-item.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';

const routes: Routes = [
  {path:'', component: RestaurantListComponent, pathMatch:'full'},
  {path:'add-item', component: AddItemComponent},
  {path:'edit-item/:id',component:EditItemComponent},
  {path:'**', component: NotFoundComponent}
];

@NgModule({
  declarations: [
    RestaurantListComponent,
    RestaurantItemComponent,
    AddItemComponent,
    EditItemComponent,
    NotFoundComponent
  ],
  imports: [RouterModule.forRoot(routes), CommonModule, ReactiveFormsModule, FormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
