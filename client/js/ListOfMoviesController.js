/**
 * Created by Anusha on 8/13/2016.
 */
(function(){
    'use strict';
    angular.module('movieflix')
        .controller('ListOfMoviesController', ListOfMoviesController);
    ListOfMoviesController.$inject= ['MoviesService','$location'];

    function ListOfMoviesController(MoviesService,$location) {
      var moviesListVm = this;
        init();
        function init() {
            console.log("ListOfMoviesController");

            MoviesService.getMovies()
                .then(function (data) {
                    moviesListVm.movies = data;
                    console.log(moviesListVm.movies)
                })
                .catch(function (error) {
                    console.log(error);
                });
        };
        moviesListVm.hoverIn = function(){
            this.hoverEdit = true;

            // $location.path('/movie-detail')
        };

        moviesListVm.hoverOut = function(){
                       this.hoverEdit = false;
        };
    }
})();