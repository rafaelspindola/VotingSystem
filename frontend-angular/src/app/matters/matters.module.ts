import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MattersRoutingModule } from './matters-routing.module';
import { MattersComponent } from './matters/matters.component';


@NgModule({
  declarations: [
    MattersComponent
  ],
  imports: [
    CommonModule,
    MattersRoutingModule
  ]
})
export class MattersModule { }
