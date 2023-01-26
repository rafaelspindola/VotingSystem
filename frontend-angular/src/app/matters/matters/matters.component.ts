import { Matter } from './../model/matter';
import { Component } from '@angular/core';

@Component({
  selector: 'app-matters',
  templateUrl: './matters.component.html',
  styleUrls: ['./matters.component.scss']
})
export class MattersComponent {

  matters: Matter[] = [
    { _id: "1", matter: 'Raise', author: 'Rafael'}
  ];
  displayedColumns = ['matter', 'author'];

}
