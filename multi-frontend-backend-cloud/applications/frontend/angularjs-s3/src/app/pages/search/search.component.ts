import template from './search.template.html';
import { SearchController } from './search.controller';
import './search.style.scss';

export const SearchComponent = {
  restrict: 'E',
  bindings: {},
  template,
  controller: SearchController
};
