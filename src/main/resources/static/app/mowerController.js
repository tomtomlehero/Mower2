var mowerController = function ($scope, Instructions) {

    var main = this;

     $scope.submitInstructions = function(instructions) {
       new Instructions({
         instructions: instructions
       }).$submit(function(instructions) {
            $scope.mowerResponse = instructions.response;
       });
     };

};

//mowerController.$inject = ['$scope', 'Item'];

angular.module('mowerApp').controller('mowerController', mowerController);

