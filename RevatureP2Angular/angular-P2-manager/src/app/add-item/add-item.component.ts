import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AddItemService } from '../add-item.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  @Output()
  save = new EventEmitter();

  addItemForm!: FormGroup

  constructor(
    private fb: FormBuilder,
    private addItemService: AddItemService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.addItemForm = this.fb.group({
      dishName: [],
      description: [],
      ingredients: [],
      price: [],
      image_url: [],
      availability: [],
      restaurant_id: 1
    })
  }

  handleSubmit() {
    if (this.addItemForm.valid) {
      let itemModel = this.addItemForm.value
      this.save.emit(itemModel)
      this.addItemService.saveItem(itemModel)
      .subscribe({
        next: (response:any) => {
          console.log(response)
        }
      })
      this.router.navigate(['']);
    }
  }

}
