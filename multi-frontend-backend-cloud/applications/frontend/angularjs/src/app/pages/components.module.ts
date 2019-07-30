import angular from 'angular';
import { HomeModule } from './home/home.module';
import { SearchModule } from './search/search.module';
import { CustomizeModule } from './customize/customize.module';
import { PaxModule } from './pax/pax.module';

export const ComponentsModule = angular.module('components', [
    HomeModule,
    SearchModule,
    CustomizeModule,
    PaxModule
]).name;
