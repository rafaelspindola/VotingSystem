import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MatterFormComponent } from './containers/matter-form/matter-form.component';
import { MattersComponent } from './containers/matters/matters.component';

const routes: Routes = [
  { path: '', component: MattersComponent },
  { path: 'new', component: MatterFormComponent },
  { path: 'vote/:id', component: MatterFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MattersRoutingModule { }
