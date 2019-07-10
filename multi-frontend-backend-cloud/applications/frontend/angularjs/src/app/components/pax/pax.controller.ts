import { IWindowService } from 'angular';
import { StateService } from 'angular-ui-router';

export class PaxController {
  name: string;

  constructor(private $state: StateService, private $window: IWindowService) {
    this.name = 'Pax';
  }

  goHome(): void {
    this.$state.go('home');
  }

  goSearch(): void {
    this.$state.go('search');
  }

  goCustomize(): void {
    this.$state.go('customize');
  }

  goPax(): void {
    this.$state.go('pax');
  }

  goAccommodation(): void {
    this.$window.location.href = 'accommodation';
  }

  goAccommodationSSR(): void {
    this.$window.location.href = 'accommodation-ssr';
  }

  goPayment(): void {
    this.$window.location.href = 'payment';
  }

  goConfirmation(): void {
    this.$window.location.href = 'confirmation';
  }
}
