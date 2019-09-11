import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material';
import { AccommodationComponent } from './accommodation.component';
import { GreetingModule } from 'src/app/greeting/greeting.module';

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
    GreetingModule,
  ],
  declarations: [
    AccommodationComponent,
  ],
})
export class AccommodationModule { }
