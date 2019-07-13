import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material';
import { AccommodationSsrComponent } from './accommodation-ssr.component';

const routes: Route[] = [
  {
    path: '',
    component: AccommodationSsrComponent,
  },
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    MatButtonModule,
  ],
  declarations: [
    AccommodationSsrComponent,
  ],
})
export class AccommodationSsrModule { }
