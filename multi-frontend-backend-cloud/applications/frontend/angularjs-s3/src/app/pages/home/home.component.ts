import template from './home.template.html';
import { HomeController } from './home.controller';
import './home.style.scss';

export const HomeComponent = {
  restrict: 'E',
  bindings: {},
  template,
  controller: HomeController
};
