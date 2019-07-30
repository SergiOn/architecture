import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss'],
})
export class PaymentComponent {
  name = 'Payment';

  constructor(private router: Router) {}

  goAccommodation(): void {
    this.router.navigate(['/accommodation']);
  }

  goAccommodationSSR(): void {
    this.router.navigate(['/accommodation-ssr']);
  }

  goPayment(): void {
    this.router.navigate(['/payment']);
  }

  goConfirmation(): void {
    this.router.navigate(['/confirmation']);
  }

  goHome(): void {
    window.location.href = '';
  }

  goSearch(): void {
    window.location.href = 'search';
  }

  goCustomize(): void {
    window.location.href = 'customize';
  }

  goPax(): void {
    window.location.href = 'pax';
  }

}
