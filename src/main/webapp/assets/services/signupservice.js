angular.module('RamJanakiApp')
.factory('SignupService',SignupService);

SignupService.$inject = [
    '$http'
]

function SignupService($http,$location) {

    return {
        signupService :function(userName,email,password,mobileNumber,address){

            var data = {
                userName: userName,
                password: password,
                address: address,
                email: email,
                mobileNumber: mobileNumber
            };
            var url = "http://localhost:8080/signup";
            console.log(url)
            $http.post(url,data).then(function (response) {
                console.log(response)
            },function (error) {

            })
    }
    }
}