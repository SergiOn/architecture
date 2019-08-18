import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NotFoundComponent } from './not-found/not-found.component';

const routes: Routes = [
  {
    path: 'accommodation',
    loadChildren: 'src/app/pages/accommodation/accommodation.module#AccommodationModule',
  },
  {
    path: 'accommodation-ssr',
    loadChildren: 'src/app/pages/accommodation-ssr/accommodation-ssr.module#AccommodationSsrModule',
  },
  {
    path: 'payment',
    loadChildren: 'src/app/pages/payment/payment.module#PaymentModule',
  },
  {
    path: 'confirmation',
    loadChildren: 'src/app/pages/confirmation/confirmation.module#ConfirmationModule',
  },
  {
    path: 'not-found',
    component: NotFoundComponent,
  },
  {
    path: '**',
    redirectTo: 'not-found',
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
