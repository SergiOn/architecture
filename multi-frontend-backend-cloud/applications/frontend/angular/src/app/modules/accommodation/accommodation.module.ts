import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material';
import { AccommodationComponent } from './accommodation.component';

const routes: Route[] = [
  {
    path: '',
    component: AccommodationComponent,
  },
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    MatButtonModule,
  ],
  declarations: [
    AccommodationComponent,
  ],
})
export class AccommodationModule { }
