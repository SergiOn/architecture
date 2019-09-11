import { GreetingService } from './greeting.service';
import { Greetings } from './greeting.interfaces';

export class GreetingController {

  public greetings: Greetings;
  public loading: boolean = false;
  public spinnerDiameter: number = 40;

  constructor(private greetingService: GreetingService) {
    'ngInject';
  }

  public loadData(): void {
    this.loading = true;

    this.greetingService.getData().then((data: Greetings) => {
      this.greetings = data;
      console.log(data);
    }).finally(() => {
      this.loading = false;
    });
  }

}
