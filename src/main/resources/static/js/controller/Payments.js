
/**
 * Created by azgar.h on 6/22/2017.
 */
app.controller('paymentListController',
    function($scope, $http, $location, $filter,$rootScope, Notification, ngTableParams,  $timeout, $window, $cookies){
        $scope.hiposServerURL = "/services";
        $scope.word = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;

        $scope.today = function() {
            $scope.activDate = new Date();
            $scope.expiryDate = new Date();
        };
        $scope.today();
        $scope.format = 'dd/MM/yyyy';

        $scope.open1 = function() {
            $scope.popup1.opened = true;
        };

        $scope.popup1 = {
            opened: false
        };


        $scope.removepayments = function () {
            $scope.paymenetId="";
            $scope.totalAmount="";
            $scope.transactionDate="";
            $scope.customerId="";
            $scope.SassOrdersId="";

        };
        $scope.getPaymentList = function () {
            $http.post($scope.hiposServerURL  + "/paymentList").then(function (response) {
                var data = response.data.object;
                $scope.paymentList= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };

        $scope.getPaymentList();

        $scope.editpaymentList=function(data){
            $scope.paymenetId=data.paymenetId;
             $scope.totalAmount=data.totalAmount;
                 $scope.transactionDate=new Date(data.transactionDate);
                 $scope.customerId=data.customerId;
                 $scope.SassOrdersId=data.orderId;
            $('#payment-title').text("Edit payments");

            $("#add_new_payment_modal").modal('show');
        }

        $scope.addPayments = function () {
            $("#add_new_payment_modal").modal('show');

        };
        $scope.getCustomerList = function (val) {
            $(".loader").css("display", "block");
            if (angular.isUndefined(val)) {
                val = "";
            }
            $http.post($scope.hiposServerURL  + "/getCustomerList?SearchText=" + val).then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.customerList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };

        $scope.getCustomerList();
        $scope.savepayment= function () {
            if ($scope.nameText === '') {
                Notification.warning({message: ' Name can not be empty', positionX: 'center', delay: 2000});
            }
            else {
                var saveDetails;
                saveDetails = {
                    paymenetId:$scope.paymenetId,
                    totalAmount: $scope.totalAmount,
                    transactionDate: $scope.transactionDate,
                    customerId: $scope.customerId,
                    orderId:$scope.SassOrdersId

                };
                $http.post("/services/savepayment",angular.toJson(saveDetails)).then(function (response) {
                    var data = response.data;
                    if(data==""){
                        Notification.success({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $("#add_new_payment_modal").modal('hide');
                        Notification.success({
                            message: 'Order Created  successfully',
                            positionX: 'center',
                            delay: 2000
                        });
                        $scope.getPaymentList();
                        $scope.removepayments();
                    }
                },function (error) {
                    Notification.error({
                        message: 'Something went wrong, please try again',
                        positionX: 'center',
                        delay: 2000
                    });
                });

            }
        };
        $scope.getOrderList = function () {
            $(".loader").css("display", "block");
            $http.post($scope.hiposServerURL  + "/getOrderList").then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.orderList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };
        $scope.getOrderList();

    });