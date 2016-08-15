/**
 * Created by Anusha on 8/14/2016.
 */
(function() {
    'use strict';

    angular
        .module('movieflix')
        .service('MoviesService', MoviesService);

    MoviesService.$inject = ['$http', '$q'];

    function MoviesService($http, $q) {
        var self = this;

        self.getMovies = getMovies;
        self.getMovieId = getMovieId;
        self.createMovies = createMovies;

        function getMovies() {
            return $http.get('http://localhost:8686/movies')
                .then(resolve, reject);
        }

        function getMovieId(id) {
            return $http.get('http://localhost:8686/movies/' + id)
                .then(resolve, reject);
        }

        function createMovies(movie) {
            return $http.post('http://localhost:8686/movies', movie)
                .then(resolve, reject);
        }

        function resolve(response) {
            return response.data;
        }

        function reject(response) {
            return $q.reject(error.status);
        }
    }
})();