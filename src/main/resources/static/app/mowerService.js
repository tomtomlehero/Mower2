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

// TODO : make a service to avoid return of the sent instructions
//angular.module("mowerApp").service("mowerService", InstructionsFactory);
