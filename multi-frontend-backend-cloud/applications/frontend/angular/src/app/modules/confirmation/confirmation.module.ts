import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material';
import { ConfirmationComponent } from './confirmation.component';

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
  ],
  declarations: [
    ConfirmationComponent,
  ],
})
export class ConfirmationModule { }
