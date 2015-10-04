var InstructionsFactory = function($resource) {
    return $resource('/submitInstructions/', {
    }, {
     submit: {
       method: "POST"
     }
    });
};

angular.module("mowerApp").factory("Instructions", InstructionsFactory);
