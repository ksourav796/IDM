/**
 * Created by azgar.h on 7/1/2017.
 */

app.controller('paymentMethodCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification,$timeout) {
        $scope.hiposServerURL = "/services";
        $scope.customerId = 1;
        $scope.userRights = [];
        $scope.operation = 'Create';
        $scope.customer = 1;
        $scope.today = new Date();

        $scope.removePaymentMethodDetails = function () {
            $scope.paymentmethodId = "0";
            $scope.PaymentMethodText="0";
            $scope.DescriptionText="0";
            $scope.TypeText="0";
            $scope.accountTypeText="";
            $scope.defaultType=false;
        };
        $scope.editpayments=function(data){
            $scope.paymentmethodId = data.paymentmethodId;
            $scope.paymentmethodNameText = data.paymentmethodName;
            $scope.paymentmethodDescriptionText = data.paymentmethodDescription;
            $scope.paymentmethodTypeText = data.paymentmethodType;
            $scope.accountTypeText=data.accountType;
            $scope.statusText=data.status;

            $('#payment-title').text("Edit Payment Method");
            $("#add_new_PaymentMethod_modal").modal('show');

        }
        $scope.addNewPaymentMethodPopulate = function () {
            $scope.paymentmethodId = "";
            $scope.paymentmethodNameText = "";
            $scope.paymentmethodDescriptionText = "";
            $scope.paymentmethodTypeText = "";
            $scope.accountTypeText="";
            $scope.statusText="Active";
            $scope.account = "";
            $scope.defaultType=false;
            $scope.account_name="";
            $scope.paymentMethodText="Active";
            $('#payment-title').text("Add Payment Method");
            $("#add_new_PaymentMethod_modal").modal('show');

        };
        $scope.getPaymentMethodList = function () {
            $(".loader").css("display", "block");
            $http.post($scope.hiposServerURL  + "/getPayMethodList").then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.paymentMethodList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };

        $scope.getPaymentMethodList();

        $scope.saveOrUpdatePayment= function () {
            if (angular.isUndefined($scope.paymentmethodNameText) || $scope.paymentmethodNameText == '' ) {
                Notification.warning({message: 'payment Name can not be empty', positionX: 'center', delay: 2000});
            }
            else if (angular.isUndefined($scope.paymentmethodDescriptionText) || $scope.paymentmethodDescriptionText == '' ) {
                Notification.warning({message: 'payment Description  can not be empty', positionX: 'center', delay: 2000});
            }
            else if (angular.isUndefined($scope.accountTypeText) || $scope.accountTypeText == '' ) {
                Notification.warning({message: 'Account Type  can not be empty', positionX: 'center', delay: 2000});
            }
            else if (angular.isUndefined($scope.paymentmethodTypeText) || $scope.paymentmethodTypeText == '' ) {
                Notification.warning({message: 'payment Method Type can not be empty', positionX: 'center', delay: 2000});
            }
            else {
                var savePaymentMethodDetails;
                savePaymentMethodDetails = {
                    paymentmethodId: $scope.paymentmethodId,
                    paymentmethodName: $scope.paymentmethodNameText,
                    paymentmethodDescription: $scope.paymentmethodDescriptionText,
                    paymentmethodType: $scope.paymentmethodTypeText,
                    accountType: $scope.accountTypeText,
                    status: $scope.statusText,
                    defaultType: $scope.defaultType
                };
            }
                    $http.post("/services/savePaymentMethod",angular.toJson(savePaymentMethodDetails)).then(function (response) {
                    var data = response.data;
                    if(data==""){
                        Notification.success({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removePaymentMethodDetails();
                        $scope.getPaymentMethodList();
                        $("#add_new_PaymentMethod_modal").modal('hide');
                        Notification.success({
                            message: 'Payment Method Created  successfully',
                            positionX: 'center',
                            delay: 2000
                        });
                    }
                },function (error) {

                });

            };


    });
