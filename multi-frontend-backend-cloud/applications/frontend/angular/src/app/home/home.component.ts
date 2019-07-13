import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent {
  name = 'Home';

  constructor(private router: Router) {}

  goHome(): void {
    this.router.navigate(['/home']);
  }

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

  goRoot(): void {
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
