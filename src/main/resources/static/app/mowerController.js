var mowerController = function ($scope, Instructions) {

     $scope.submitInstructions = function(instructions) {
       new Instructions({
         instructions: instructions
       }).$submit(function(response) {
            $scope.mowerResponse = response;
       });
     };

};

angular.module('mowerApp').controller('mowerController', mowerController);
