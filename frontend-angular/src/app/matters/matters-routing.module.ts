import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MattersComponent } from './matters/matters.component';

const routes: Routes = [
  { path: '', component: MattersComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MattersRoutingModule { }
