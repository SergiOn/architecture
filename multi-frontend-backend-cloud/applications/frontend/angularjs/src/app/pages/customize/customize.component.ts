import template from './customize.template.html';
import { CustomizeController } from './customize.controller';
import './customize.style.scss';

export const CustomizeComponent = {
  restrict: 'E',
  bindings: {},
  template,
  controller: CustomizeController
};
