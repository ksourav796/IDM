app.controller('PractitionerRegistrationCtrl', function ($scope, $rootScope, $http, $location, $filter, Notification){

    $scope.hiposServerURL="/services";
    $scope.word = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;

    $scope.removepregister = function () {
             $scope.practitionerId="";
             $scope.name="";
             $scope.companyName="";
             $scope.practitionernumber="";
             $scope.Phone="";
             $scope.Email="";
             $scope.Password="";
             $scope.subscriptionId="";
             $scope.SyncUrl="";
             $scope.status="";

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



    $scope.getsubscriptionList = function () {
        $http.post($scope.hiposServerURL  + "/getSubscriptionList").then(function (response) {
            var data = response.data.object;
            $scope.subscriptionList= data;
        },function (error) {
            Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
        })
    };

    $scope.getsubscriptionList();

$scope.editpractitionerreg=function(data){
    $scope.practitionerId=data.practitionerId;
    $scope.status=data.status;
    $scope.name=data.name;
    $scope.companyName=data.companyname;
    $scope.practitionernumber=data.practitionernumber;
    $scope.Phone=data.phone;
    $scope.Email=data.email;
    $scope.Password=data.password;
    $scope.subscriptionId=data.subscriptionId;
    $scope.SyncUrl=data.syncUrl;
    $scope.getsubscriptionList();
    $('#practitioner-title').text("Edit Practitionerregister");
    $("#add_new_practitionerreg_modal").modal('show');
}


    $scope.removepayments = function () {
        $scope.name="";
        $scope.companyName="";
        $scope.practitionernumber="";
        $scope.Phone="";
        $scope.Email="";
        $scope.Password="";
        $scope.subscriptionId="";
        $scope.SyncUrl="";
        $scope.operation = 'Create';
    };

    $scope.addpractitioner = function () {
        $scope.status="Active";
        $("#add_new_practitionerreg_modal").modal('show');

    };

    $scope.savepractitioner= function () {
        if ($scope.nameText === '') {
            Notification.warning({message: ' Name can not be empty', positionX: 'center', delay: 2000});
        }
        else {
            var saveDetails;
            saveDetails = {
                practitionerId: $scope.practitionerId,
                name: $scope.name,
                companyname: $scope.companyName,
                practitionernumber: $scope.practitionernumber,
                phone: $scope.Phone,
                email: $scope.Email,
                password: $scope.Password,
                subscriptionId: $scope.subscriptionId,
                syncUrl: $scope.SyncUrl,
                status: $scope.status

            };
            $http.post("/services/savepractitioner",angular.toJson(saveDetails)).then(function (response) {
                var data = response.data;
                if(data==""){
                    Notification.success({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else if(angular.isUndefined($scope.name) || $scope.name == '') {
                    Notification.warning({message: 'Name can not be Empty', positionX: 'center', delay: 2000});}
                else if(angular.isUndefined($scope.companyName) || $scope.companyName == '') {
                    Notification.warning({message: 'companyName can not be Empty', positionX: 'center', delay: 2000});}
                else if(angular.isUndefined($scope.practitionernumber) || $scope.practitionernumber == '') {
                    Notification.warning({message: 'practitionernumber can not be Empty', positionX: 'center', delay: 2000});}
                else if(angular.isUndefined($scope.Phone) || $scope.Phone == '') {
                    Notification.warning({message: 'Phone can not be Empty', positionX: 'center', delay: 2000});}
                else if(angular.isUndefined($scope.Email) || $scope.Email == '') {
                    Notification.warning({message: 'Email can not be Empty', positionX: 'center', delay: 2000});}
                else if(angular.isUndefined($scope.Password) || $scope.Password == '') {
                    Notification.warning({message: 'Password can not be Empty', positionX: 'center', delay: 2000});}
                else if(angular.isUndefined($scope.SyncUrl) || $scope.SyncUrl == '') {
                    Notification.warning({message: 'SyncUrl can not be Empty', positionX: 'center', delay: 2000});}
                else {
                    $("#add_new_practitionerreg_modal").modal('hide');
                    Notification.success({
                        message: 'Order Created  successfully',
                        positionX: 'center',
                        delay: 2000
                    });
                     $scope.getpractitionerReg();
                     $scope.removepregister();
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