import angular from 'angular';
import { PaxComponent } from './pax.component';

export const PaxModule = angular.module('pax', [])
    .component('pax', PaxComponent)
    .name;
