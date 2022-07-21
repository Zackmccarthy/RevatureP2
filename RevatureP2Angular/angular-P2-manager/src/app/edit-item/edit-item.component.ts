import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EditItemService } from '../edit-item.service';

@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.css']
})
export class EditItemComponent implements OnInit {

  @Output()
  edit = new EventEmitter();

  editItemForm! : FormGroup

  menu = {}

  newMenu:any = []

  id: number = 0

  constructor(
    private fb: FormBuilder,
    private editItemService: EditItemService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.loadItems(),
    this.editItemForm = this.fb.group({
      dishName: [],
      description: [],
      ingredients: [],
      price: [],
      image_url: [],
      availability: [],
    })
  }

  handleSubmit() {
    if (this.editItemForm.valid) {
      let itemModel = this.editItemForm.value
      console.log(itemModel)
      this.edit.emit(itemModel)
      this.editItemService.saveItem(this.id, itemModel)
      .subscribe({
        next: (response: any) => {
          console.log(response)
        }
      })
      this.router.navigate(['']);
    }
  }

  loadItems() {
    this.id = this.route.snapshot.params['id']
    console.log(this.id)
    this.editItemService.getItem(this.id)
    .subscribe({
      next: (response: any) => {
        this.menu = response
        console.log(this.menu)
        this.newMenu.push(this.menu)
        console.log(this.newMenu)
      }
    })
  }

}
