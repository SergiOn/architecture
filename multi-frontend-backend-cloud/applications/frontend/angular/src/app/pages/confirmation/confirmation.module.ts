import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material';
import { ConfirmationComponent } from './confirmation.component';
import { GreetingModule } from 'src/app/greeting/greeting.module';

const routes: Route[] = [
  {
    path: '',
    component: ConfirmationComponent,
  },
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    MatButtonModule,
    GreetingModule,
  ],
  declarations: [
    ConfirmationComponent,
  ],
})
export class ConfirmationModule { }
