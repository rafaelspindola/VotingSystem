import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from './../shared/shared.module';
import { MatterFormComponent } from './matter-form/matter-form.component';
import { MattersRoutingModule } from './matters-routing.module';
import { MattersComponent } from './matters/matters.component';




@NgModule({
  declarations: [
    MattersComponent,
    MatterFormComponent
  ],
  imports: [
    CommonModule,
    MattersRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule
  ]
})
export class MattersModule { }
