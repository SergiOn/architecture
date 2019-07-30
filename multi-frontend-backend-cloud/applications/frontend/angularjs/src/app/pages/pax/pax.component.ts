import template from './pax.template.html';
import { PaxController } from './pax.controller';
import './pax.style.scss';

export const PaxComponent = {
  restrict: 'E',
  bindings: {},
  template,
  controller: PaxController
};
