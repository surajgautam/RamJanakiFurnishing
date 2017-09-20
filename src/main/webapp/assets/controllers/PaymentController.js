angular.module('RamJanakiApp').controller('PaymentController',PaymentController);

PaymentController.$inject=['$http'];

function PaymentController($http) {

    var vm = this;


    vm.url = "http://localhost:8080/ecommerce/accept/payment";


    vm.acceptPayment = acceptPayment;


    function acceptPayment() {
        vm.price = angular.element(document.getElementsByName('amt')[0]).val();
        vm.taxamount=angular.element(document.getElementsByName('txAmt')[0]).val();
        vm.totalprice = angular.element(document.getElementsByName('tAmt')[0]).val();
        vm.id = angular.element(document.getElementsByName('id')[0]).val();

        vm.data = {
            price: vm.price,
            taxamount:vm.taxamount,
            totalprice:vm.totalprice,
            id : vm.id
        };

        $http.post(vm.url,JSON.stringify(vm.data)).then(function (response) {
            console.log(response.data)
        },function (error) {

        });
    }

}