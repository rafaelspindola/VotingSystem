import { Component } from '@angular/core';
import { Observable } from 'rxjs';

import { Matter } from './../model/matter';
import { MattersService } from './../services/matters.service';

@Component({
  selector: 'app-matters',
  templateUrl: './matters.component.html',
  styleUrls: ['./matters.component.scss']
})
export class MattersComponent {

  matters$: Observable<Matter[]>;
  displayedColumns = ['matter', 'author'];

  constructor(private mattersService: MattersService) {
    this.matters$ = this.mattersService.findAllMatters();
  }

}
