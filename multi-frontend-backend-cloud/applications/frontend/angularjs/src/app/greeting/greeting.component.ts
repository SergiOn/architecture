import template from './greeting.template.html';
import { GreetingController } from './greeting.controller';
import './greeting.style.scss';

export const GreetingComponent = {
  restrict: 'E',
  bindings: {},
  template,
  controller: GreetingController
};
