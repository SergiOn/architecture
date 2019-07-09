import angular, { ILocationProvider } from 'angular';
import uiRouter, { StateProvider, UrlRouterProvider } from 'angular-ui-router';

export const AppConfigModule = angular.module('appConfig' , [
    uiRouter,
])
.config(($locationProvider: ILocationProvider, $stateProvider: StateProvider, $urlRouterProvider: UrlRouterProvider) => {
    'ngInject';

    $locationProvider.html5Mode(true);

    $urlRouterProvider.otherwise('/');

    $stateProvider
        .state('home', {
            url: '/',
            component: 'home'
        })
        .state('search', {
            url: '/search',
            component: 'search'
        })
        .state('customize', {
            url: '/customize',
            component: 'customize'
        })
        .state('pax', {
            url: '/pax',
            component: 'pax'
        });
})
.name;
