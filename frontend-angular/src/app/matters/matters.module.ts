import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatTableModule } from '@angular/material/table';

import { MattersRoutingModule } from './matters-routing.module';
import { MattersComponent } from './matters/matters.component';


@NgModule({
  declarations: [
    MattersComponent
  ],
  imports: [
    CommonModule,
    MattersRoutingModule,
    MatTableModule
  ]
})
export class MattersModule { }
