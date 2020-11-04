
/**
 * Created by azgar.h on 6/22/2017.
 */
app.controller('emailDirectLinkController',
    function($scope, $http, $location, $rootScope,$filter, Notification, ngTableParams,  $timeout, $window, $cookies){
        $scope.hiposServerURL = "/services";
        $rootScope.userStatus=null;
         var  order=$window.location.href.split("?");
         var orderId = order[1].split("&");
        $scope.savepayment = function () {
            var saveDetails;
            saveDetails = {
                paymenetId: $scope.paymenetId,
                totalAmount: 0,
                transactionDate: new Date(),
                actualPrice:0,
                balanceAmount: 0,
                paymentMode: '',
                sassOrders: orderId[0],
                status:'approved',
                customerId: $scope.customerId,

            };
            $http.post("/services/savepayment", angular.toJson(saveDetails)).then(function (response) {
                var data = response.data;
                $scope.orders=data.object.licenseKey;
            });

        }
        $scope.savepayment();

    });