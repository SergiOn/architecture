import {
  IHttpPromise,
  IHttpResponse,
  IHttpService,
  IPromise,
  IQResolveReject,
  IQService,
  ITimeoutService
} from 'angular';
import { Greetings } from './greeting.interfaces';

export class GreetingService {

  private readonly url: string = '/api/greetings';

  constructor(private $http: IHttpService, private $q: IQService, private $timeout: ITimeoutService) {
    'ngInject';
  }

  public getData(): IPromise<Greetings> {
    return this.$http.get<Greetings>(this.url).then((data: IHttpResponse<Greetings>) => {
      return this.$q((resolve: IQResolveReject<Greetings>) => {
        this.$timeout(() => {
            resolve(data.data);
        }, 2000);
      });
    });
  }

}
