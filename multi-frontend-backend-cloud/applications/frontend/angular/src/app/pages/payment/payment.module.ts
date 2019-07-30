import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material';
import { PaymentComponent } from './payment.component';
import { GreetingModule } from 'src/app/greeting/greeting.module';

const routes: Route[] = [
  {
    path: '',
    component: PaymentComponent,
  },
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    MatButtonModule,
    GreetingModule,
  ],
  declarations: [
    PaymentComponent,
  ],
})
export class PaymentModule { }
