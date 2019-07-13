import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: 'accommodation',
    loadChildren: 'src/app/modules/accommodation/accommodation.module#AccommodationModule',
  },
  {
    path: 'accommodation-ssr',
    loadChildren: 'src/app/modules/accommodation-ssr/accommodation-ssr.module#AccommodationSsrModule',
  },
  {
    path: 'payment',
    loadChildren: 'src/app/modules/payment/payment.module#PaymentModule',
  },
  {
    path: 'confirmation',
    loadChildren: 'src/app/modules/confirmation/confirmation.module#ConfirmationModule',
  },
  {
    path: '**',
    redirectTo: 'accommodation',
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
