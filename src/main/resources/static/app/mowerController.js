var mowerController = function ($scope, Instructions) {

    var main = this;

     $scope.submitInstructions = function(instructions) {
       new Instructions({
         instructions: instructions
       }).$submit(function(response) {
            $scope.mowerResponse = response;
       });
     };

};

//mowerController.$inject = ['$scope', 'Item'];

angular.module('mowerApp').controller('mowerController', mowerController);

