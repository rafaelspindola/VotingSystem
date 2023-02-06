import { Component, EventEmitter, Input, Output } from '@angular/core';

import { Matter } from '../../model/matter';

@Component({
  selector: 'app-matters-list',
  templateUrl: './matters-list.component.html',
  styleUrls: ['./matters-list.component.scss']
})
export class MattersListComponent {

  @Input() matters: Matter[] = [];
  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);

  displayedColumns = ['matter', 'author','actions'];

  constructor() {}

  onAdd() {
    this.add.emit(true);
  }

  onEdit(matter: Matter) {
    this.edit.emit(matter)
  }
}
