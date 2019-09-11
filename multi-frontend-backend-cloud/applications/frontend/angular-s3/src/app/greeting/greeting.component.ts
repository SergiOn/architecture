import { Component } from '@angular/core';
import { GreetingService } from './greeting.service';
import { Observable } from 'rxjs';
import { Greetings } from 'src/app/greeting/greeting.interfaces';

@Component({
  selector: 'greeting',
  templateUrl: './greeting.component.html',
  styleUrls: ['./greeting.component.scss'],
})
export class GreetingComponent {

  public spinnerDiameter: number = 40;
  public greetings$: Observable<Greetings>;
  public loading$: Observable<boolean>;

  constructor(private greetingService: GreetingService) {
    this.greetings$ = this.greetingService.greetings$;
    this.loading$ = this.greetingService.loading$;
  }

  public getData(): void {
    this.greetingService.doRequest();
  }

}
