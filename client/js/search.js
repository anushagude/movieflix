/**
 * Created by Anusha on 8/13/2016.
 */

var myApp = angular.module('movieflix', []);

myApp.controller('search', [ '$scope', '$http', function ($scope, $http) {
    $scope.title = "MovieFlix";
} ]);
