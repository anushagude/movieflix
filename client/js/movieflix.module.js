/**
 * Created by Anusha on 8/13/2016.
 */
(function() {
    'use strict';

    angular
        .module('movieflix', ['ngRoute'])//deleted ng-messages
        .config(moviesConfig)
        .run(moviesRun);

    moviesConfig.$inject = ['$routeProvider'];

    function moviesConfig($routeProvider) {
        $routeProvider
            .when('/movies-list', {
                templateUrl: 'movies-list.html',
                controller: 'ListOfMoviesController',
                controllerAs: 'moviesListVm'
            })
            .when('/movies-detail/:id', {
                templateUrl: 'movie-detail.html',
                controller: 'MovieDetailController',
                controllerAs: 'movieDetailsVm'
            })
            .when('/add-movies', {
                templateUrl: 'add-movies.html',
                controller: 'AddMoviesController',
                controllerAs: 'addMoviesVm'
            })
            .when('/login', {
                templateUrl: 'login.html',
                controller: 'LoginController',
                controllerAs: 'loginVm'

            });
    }

    moviesRun.$inject = [];

    function moviesRun() {
        console.log('MovieFlix Application Started');
    }
})();