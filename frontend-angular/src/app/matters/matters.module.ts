import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from './../shared/shared.module';
import { MattersRoutingModule } from './matters-routing.module';
import { MattersComponent } from './matters/matters.component';




@NgModule({
  declarations: [
    MattersComponent
  ],
  imports: [
    CommonModule,
    MattersRoutingModule,
    AppMaterialModule,
    SharedModule
  ]
})
export class MattersModule { }
