import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material';
import { AccommodationSsrComponent } from './accommodation-ssr.component';
import { GreetingModule } from 'src/app/greeting/greeting.module';

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
    GreetingModule,
  ],
  declarations: [
    AccommodationSsrComponent,
  ],
})
export class AccommodationSsrModule { }
