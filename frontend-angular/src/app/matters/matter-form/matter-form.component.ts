import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { MattersService } from './../services/matters.service';

@Component({
  selector: 'app-matter-form',
  templateUrl: './matter-form.component.html',
  styleUrls: ['./matter-form.component.scss']
})
export class MatterFormComponent {

  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private service: MattersService,
    private snackBar: MatSnackBar) {
    this.form = this.formBuilder.group({
      matter: [null],
      author: [null]
    });
  }

  onSubmit() {
    this.service.createMatter(this.form.value)
    .subscribe(data => console.log(data), error => this.onError());
  }

  onCancel() {

  }

  private onError() {
    this.snackBar.open('Error while trying to create new matter','', {duration: 5000});
  }

}
