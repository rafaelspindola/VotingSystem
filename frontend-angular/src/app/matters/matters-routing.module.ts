import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MatterFormComponent } from './matter-form/matter-form.component';
import { MattersComponent } from './matters/matters.component';

const routes: Routes = [
  { path: '', component: MattersComponent },
  { path: 'new', component: MatterFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MattersRoutingModule { }
