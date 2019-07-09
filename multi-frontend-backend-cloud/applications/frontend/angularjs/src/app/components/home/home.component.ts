// @ts-ignore
import template from './home.html';
import { HomeController } from './home.controller';
import './home.scss';

export const HomeComponent = {
  restrict: 'E',
  bindings: {},
  template,
  controller: HomeController
};
