import angular from 'angular';
import AngularAnimate from 'angular-animate';
import AngularMaterial  from 'angular-material';
import { ComponentsModule } from './pages/components.module';
import { AppComponent } from './app.component';
import { AppConfigModule } from './app.config.module';
import 'angular-material/angular-material.css';

export const AppModule = angular.module('app' , [
    AppConfigModule,
    AngularMaterial,
    AngularAnimate,
    ComponentsModule
])
.component('app', AppComponent)
.name;
