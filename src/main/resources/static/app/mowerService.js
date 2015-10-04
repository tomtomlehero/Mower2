var InstructionsFactory = function($resource) {
    return $resource('/submitInstructions/', {
    }, {
     submit: {
       method: "POST"
     }
    });
};

InstructionsFactory.$inject = ['$resource'];

angular.module("mowerApp").factory("Instructions", InstructionsFactory);
