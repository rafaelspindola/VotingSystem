import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';

import { ErrorDialogComponent } from './../../shared/components/error-dialog/error-dialog.component';
import { Matter } from './../model/matter';
import { MattersService } from './../services/matters.service';

@Component({
  selector: 'app-matters',
  templateUrl: './matters.component.html',
  styleUrls: ['./matters.component.scss']
})
export class MattersComponent {

  matters$: Observable<Matter[]>;
  displayedColumns = ['matter', 'author','actions'];

  constructor(
    public dialog: MatDialog,
    private mattersService: MattersService,
    private router: Router,
    private route: ActivatedRoute
    ) {
    this.matters$ = this.mattersService.findAllMatters()
    .pipe(
      catchError(error => {
        this.onError('Error loading matters.');
        return of([])
      })
    );
  }

  onError(errorMsg: string) {
      this.dialog.open(ErrorDialogComponent, {
        data: errorMsg
      });
    }

    onAdd() {
      this.router.navigate(['new'], {relativeTo: this.route});
    }
  }


