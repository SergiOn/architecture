import angular from 'angular';
import { GreetingComponent } from './greeting.component';
import { GreetingService } from './greeting.service';

export const GreetingModule = angular.module('greeting', [])
    .component('greeting', GreetingComponent)
    .service('greetingService', GreetingService)
    .name;
