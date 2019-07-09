import angular from 'angular';
import { CustomizeComponent } from './customize.component';

export const CustomizeModule = angular.module('customize', [])
    .component('customize', CustomizeComponent)
    .name;
