(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['MovieService', '$routeParams','$scope'];

    function MovieDetailController(MovieService, $routeParams, $scope) {
        var movieDetailsVm = this;
        console.log("in moviedetailscontroller");
        init();

        function init() {
            MovieService
                .getMovieId($routeParams.id)
                .then(function(data) {
                    movieDetailsVm.movie = data;
                }, function(error) {
                    console.log(error);
                });
        }
    }
})();