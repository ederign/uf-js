var myapp = angular.module('myapp');

myapp.config(function($routeProvider) {
    $routeProvider

        .when('/', {
                templateUrl : 'pages/home.html',
                controller  : 'mainController'
        })

        .when('/perspectiveEditor', {
                templateUrl : 'pages/perspectiveEditor.html',
                controller  : 'perspectiveEditorController'
        })

        .when('/dynamicPerspective', {
        templateUrl : 'pages/dynamicPerspective.html',
        controller  : 'dynamicPerspectiveController'
        })

        .when('/nestedControllers', {
            templateUrl : 'pages/nestedControllers.html',
            controller  : 'nestedControllers'
        });
    });

myapp.controller('mainController', function($scope, $location) {
        $scope.message = 'Here is the Main Controller';
        
});

myapp.controller('perspectiveEditorController', function($scope) {
        $scope.message = 'Perspective Editor Controller!';
});

myapp.controller('dynamicPerspectiveController', function($scope) {
        $scope.message = 'Dynamic Perspective Controller.';
});

myapp.controller('nestedControllers', function($scope) {
    $scope.message = 'Nested Controllers.';
});

myapp.controller('firstControllerScope', function($scope) {
    $scope.firstName = "John";
});
myapp.controller('secondControllerScope', function($scope) {
    $scope.lastName = "Connor's";

    $scope.getFullName = function ()
    {
        return $scope.firstName + " " + $scope.lastName;
    };
});

myapp.controller('thirdControllerScope', function($scope) {
    $scope.lastName = "Connor's";

    $scope.getFullName = function ()
    {
        return $scope.firstName + " " + $scope.lastName;
    };
});



