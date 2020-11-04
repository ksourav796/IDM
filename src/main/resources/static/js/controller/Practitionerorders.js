app.controller('PractitionerordersCtrl', function ($scope, $rootScope, $http, $location, $filter, Notification) {

    $scope.hiposServerURL = "/services";
    $scope.today = function() {
        $scope.date = new Date();
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
        $scope.practitionerOrdersId="";
        $scope.voucher="";
        $scope.cdkey="";
        $scope.svkey="";
        $scope.registrationKey="";
        $scope.activationKey="";
        $scope.status="";
        $scope.practitionerId="";
        $scope.orderId="";

    }
    $scope.getpractitionerReg = function (val) {
        $(".loader").css("display", "block");
        if (angular.isUndefined(val)) {
            val = "";
        }
        $http.post($scope.hiposServerURL  + "/practitionerReg?SearchText=" + val).then(function (response) {
            var data = response.data.object;
            $scope.pregisterList= data;
            $scope.searchText = val;
        },function (error) {
            Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
        })
    };

    $scope.getpractitionerReg();

    $scope.getordersList = function () {
        $http.post($scope.hiposServerURL  + "/getOrderList").then(function (response) {
            var data = response.data.object;
            $scope.orderList= data;
        },function (error) {
            Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
        })
    };

    $scope.getordersList();

    $scope.getpractitionerordersList = function () {
        $http.post($scope.hiposServerURL  + "/pracorderList").then(function (response) {
            var data = response.data.object;
            $scope.pregisterorderList= data;
        },function (error) {
            Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
        })
    };

    $scope.getpractitionerordersList();


    $scope.editpractitionerorder=function(data){
        $scope.practitionerOrdersId=data.practitionerOrdersId;
        $scope.voucher=data.voucher;
        $scope.date=new Date(data.date);
        $scope.cdkey=data.cdkey;
        $scope.svkey=data.svkey;
        $scope.registrationKey=data.registrationKey;
        $scope.activationKey=data.activationKey;
        $scope.status=data.status;
        $scope.practitionerId=data.practitionerId;
        $scope.orderId=data.orderId;

        $scope.getpractitionerReg();
        $scope.getordersList();
        $('#practitionerorder-title').text("Edit Practitionerorder");
        $("#add_new_practitionerorder_modal").modal('show');

    }

    $scope.addpractitionerorder = function () {
        $scope.status="Active";
        $("#add_new_practitionerorder_modal").modal('show');

    };
    $scope.savepractitionerorders= function () {
        if ($scope.nameText === '') {
            Notification.warning({message: ' Name can not be empty', positionX: 'center', delay: 2000});
        }
        else if(angular.isUndefined($scope.voucher) || $scope.voucher == '') {
            Notification.warning({message: 'voucher can not be Empty', positionX: 'center', delay: 2000});}
        else if(angular.isUndefined($scope.cdkey) || $scope.cdkey == '') {
            Notification.warning({message: 'cdkey can not be Empty', positionX: 'center', delay: 2000});}
        else if(angular.isUndefined($scope.svkey) || $scope.svkey == '') {
            Notification.warning({message: 'svkey can not be Empty', positionX: 'center', delay: 2000});}
        else if(angular.isUndefined($scope.registrationKey) || $scope.registrationKey == '') {
            Notification.warning({message: 'registrationKey can not be Empty', positionX: 'center', delay: 2000});}
        else if(angular.isUndefined($scope.activationKey) || $scope.activationKey == '') {
            Notification.warning({message: 'activationKey can not be Empty', positionX: 'center', delay: 2000});}

        else {
            var saveDetails;
            saveDetails = {
                practitionerOrdersId:$scope.practitionerOrdersId,
                practitionerId: $scope.practitionerId,
                voucher: $scope.voucher,
                date: $scope.date,
                cdkey: $scope.cdkey,
                svkey: $scope.svkey,
                registrationKey: $scope.registrationKey,
                activationKey: $scope.activationKey,
                orderId: $scope.orderId,
                status: $scope.status

            };
            $http.post("/services/savepractitionerorders",angular.toJson(saveDetails)).then(function (response) {
                var data = response.data;
                if(data==""){
                    Notification.success({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else {
                    $("#add_new_practitionerorder_modal").modal('hide');
                    Notification.success({
                        message: 'Order Created  successfully',
                        positionX: 'center',
                        delay: 2000
                    });
                    $scope.removepregisterorde();
                     $scope.getpractitionerordersList();
                    // $scope.removepregisterorde();
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


});
