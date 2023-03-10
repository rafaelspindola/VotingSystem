import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from './../shared/shared.module';
import { MatterFormComponent } from './containers/matter-form/matter-form.component';
import { MattersRoutingModule } from './matters-routing.module';
import { MattersComponent } from './containers/matters/matters.component';
import { MattersListComponent } from './components/matters-list/matters-list.component';




@NgModule({
  declarations: [
    MattersComponent,
    MatterFormComponent,
    MattersListComponent
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
