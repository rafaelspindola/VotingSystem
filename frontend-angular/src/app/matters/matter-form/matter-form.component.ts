import { Component } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup } from '@angular/forms';
import { Location } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';

import { MattersService } from './../services/matters.service';

@Component({
  selector: 'app-matter-form',
  templateUrl: './matter-form.component.html',
  styleUrls: ['./matter-form.component.scss']
})
export class MatterFormComponent {

  form: UntypedFormGroup;

  constructor(
    private formBuilder: UntypedFormBuilder,
    private service: MattersService,
    private snackBar: MatSnackBar,
    private location: Location
    ) {
    this.form = this.formBuilder.group({
      matter: [null],
      author: [null]
    });
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
    this.onCancel;
  }

  private onError() {
    this.snackBar.open('Error while trying to create new matter','', {duration: 5000});
  }

}
