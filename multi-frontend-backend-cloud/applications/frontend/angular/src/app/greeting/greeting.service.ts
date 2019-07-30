import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Greetings } from './greeting.interfaces';
import { EMPTY, merge, Observable, Subject } from 'rxjs';
import { catchError, delay, mapTo, shareReplay, startWith, switchMap } from 'rxjs/operators';

@Injectable()
export class GreetingService {

  private readonly url: string = '/api/greetings';
  private doRequestSink: Subject<void> = new Subject();
  private doRequestSink$: Observable<void> = this.doRequestSink.asObservable();

  public greetings$: Observable<Greetings> = this.doRequestSink$.pipe(
    switchMap(() => this.getData().pipe(
      catchError(() => EMPTY)),
    ),
    delay(3000),
    shareReplay(1),
  );

  public loading$: Observable<boolean> = merge(
    this.doRequestSink$.pipe(mapTo(true)),
    this.greetings$.pipe(mapTo(false)),
  ).pipe(
    startWith(false),
  );

  constructor(private httpClient: HttpClient) {}

  public doRequest(): void {
    this.doRequestSink.next();
  }

  private getData(): Observable<Greetings> {
    return this.httpClient.get<Greetings>(this.url);
  }

}
