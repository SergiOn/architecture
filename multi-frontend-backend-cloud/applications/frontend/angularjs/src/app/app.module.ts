import angular from 'angular';
import AngularAnimate from 'angular-animate';
import AngularMaterial  from 'angular-material';
import 'angular-material/angular-material.css';
import { ComponentsModule } from './pages/components.module';
import { AppComponent } from './app.component';
import { AppConfigModule } from './app.config.module';
import { GreetingModule } from './greeting/greeting.module';

export const AppModule = angular.module('app' , [
    AppConfigModule,
    AngularMaterial,
    AngularAnimate,
    ComponentsModule,
    GreetingModule
])
.component('app', AppComponent)
.name;
