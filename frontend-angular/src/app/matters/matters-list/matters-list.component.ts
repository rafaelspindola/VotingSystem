import { Component, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Matter } from '../model/matter';

@Component({
  selector: 'app-matters-list',
  templateUrl: './matters-list.component.html',
  styleUrls: ['./matters-list.component.scss']
})
export class MattersListComponent {

  @Input() matters: Matter[] = [];

  displayedColumns = ['matter', 'author','actions'];

  constructor(
    private router: Router,
    private route: ActivatedRoute
  ) {}

  onAdd() {
    this.router.navigate(['new'], {relativeTo: this.route});
  }
}
