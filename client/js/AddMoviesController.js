/**
 * Created by Anusha on 8/13/2016.
 */
(function() {
    'use strict';

    angular
        .module('movieflix').controller('AddMoviesController', AddMoviesController);

    AddMoviesController.$inject = ['MoviesService', '$location'];

    function AddMoviesController(MoviesService, $location) {
        var addMoviesVm = this;
        addMoviesVm.addMovies = addMovies;
        init();
        function init() {
            console.log('in AddMoviesController');
            // console.log(data);
        }

        function addMovies() {
            MoviesService.createMovies(addMoviesVm.newMovie)
                .then(function(data) {
                    $location.path('/movies-list');
                }, function(error) {
                    console.log(error);
                })
        }
    }
})();