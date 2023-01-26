import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';


import { MattersRoutingModule } from './matters-routing.module';
import { MattersComponent } from './matters/matters.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';



@NgModule({
  declarations: [
    MattersComponent
  ],
  imports: [
    CommonModule,
    MattersRoutingModule,
    AppMaterialModule
  ]
})
export class MattersModule { }
