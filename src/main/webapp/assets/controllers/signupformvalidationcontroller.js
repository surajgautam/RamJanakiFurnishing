angular.module('RamJanakiApp')
.controller('SignupFormValidationController',['SignupService',SignupFormValidationController]);


function SignupFormValidationController(SignupService) {

    var vm = this;

    vm.userName= "";
    vm.email = "";
    vm.password = "";
    vm.mobileNumber = "";
    vm.address= "";


    vm.submit = function (){
        SignupService.signupService(vm.userName,vm.email,vm.password,vm.mobileNumber,vm.address);
    };

}