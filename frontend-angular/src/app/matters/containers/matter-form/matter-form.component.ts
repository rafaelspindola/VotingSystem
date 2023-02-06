import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { MattersService } from '../../services/matters.service';

@Component({
  selector: 'app-matter-form',
  templateUrl: './matter-form.component.html',
  styleUrls: ['./matter-form.component.scss']
})
export class MatterFormComponent {

  form = this.formBuilder.group({
      matter: [''],
      author: ['']
    });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: MattersService,
    private snackBar: MatSnackBar,
    private location: Location
    ) {
  }

  onSubmit() {
    this.service.createMatter(this.form.value)
    .subscribe(data => this.onSuccess(), error => this.onError());
  }

  onCancel() {
    this.location.back();
  }

  private onSuccess() {
    this.snackBar.open('Matter created successfully','', {duration: 5000});
    this.onCancel();
  }

  private onError() {
    this.snackBar.open('Error while trying to create new matter','', {duration: 5000});
  }

}
