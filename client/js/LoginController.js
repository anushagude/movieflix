/**
 * Created by Anusha on 8/13/2016.
 */
(function() {
    'use strict';

    angular
        .module('movieflix').controller('LoginController', LoginController);

    LoginController.$inject = ['$window','$scope'];

    function LoginController($window, $scope) {
        init();
        function init() {
            console.log('in logincontroller');
        };

        $scope.submit = function() {
            // $location.path('/movies-list');
            $window.location.href = '../movies-list.html';
        };
    }
})();
