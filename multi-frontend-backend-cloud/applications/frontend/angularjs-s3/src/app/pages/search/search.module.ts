import angular from 'angular';
import { SearchComponent } from './search.component';

export const SearchModule = angular.module('search', [])
    .component('search', SearchComponent)
    .name;
