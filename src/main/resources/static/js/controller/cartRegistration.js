
app.controller('cartRegCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";
        $scope.customerId = 1;
        $scope.userRights = [];
        $scope.operation = 'Create';
        $scope.customer = 1;
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

        $scope.open2 = function() {
            $scope.popup2.opened = true;
        };

        $scope.isFilterApplied = false;
        $scope.popup2 = {
            opened: false
        };

        $scope.removeCartReg = function () {
            $scope.cartnameText = "";
            $scope.activDate = "";
            $scope.expiryDate = "";
            $scope.carttknText = "";
            $scope.authtknText = "";
            $scope.renewText = "";
            $scope.regidText = "";
            $scope.cmpnyidText = "";
            $scope.urlText = "";
            $scope.versionText = "";
            $scope.apiText = "";
            $scope.cartId="";
        };
        $scope.editCartReg = function (data) {
            $scope.cartId=data.cartId;
            $scope.cartnameText=data.cartName;
            $scope.urlText = data.url;
            $scope.versionText = data.version;
            $scope.apiText = data.api;
            $scope.statusText = data.status;
            $scope.operation = 'edit';
            $('#title').text("Edit CartRegistration");
            $("#add_new_cart_modal").modal('show');
        };

        $scope.getCartRegList = function () {
            $(".loader").css("display", "block");
            $http.post($scope.hiposServerURL  + "/getCartRegList").then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.cartRegList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };

        $scope.getCartRegList();



        $scope.addCartRegistration = function () {
            $scope.cartnameText = "";
            $scope.carttknText = "";
            $scope.authtknText = "";
            $scope.renewText = "";
            $scope.regidText = "";
            $scope.cmpnyidText = "";
            $scope.statusText = "Active";
            $scope.urlText = "";
            $scope.versionText = "";
            $scope.apiText = "";
            $scope.removeCartReg();
            $("#title").text("Add CartRegistration");
            $("#add_new_cart_modal").modal('show');
        };

        $scope.saveCartRegistration = function () {
            if (angular.isUndefined($scope.cartnameText) || $scope.cartnameText == '') {
                Notification.warning({message: 'AddOn Name can not be Empty', positionX: 'center', delay: 2000});
            }
            else if(angular.isUndefined($scope.cartnameText) || $scope.cartnameText == '') {
                Notification.warning({message: 'cartname can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.urlText) || $scope.urlText == '') {
                Notification.warning({message: 'url can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.versionText) || $scope.versionText == '') {
                Notification.warning({message: 'version can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.apiText) || $scope.apiText == '') {
                Notification.warning({message: 'api can not be Empty', positionX: 'center', delay: 2000});}
            else{
                var saveCartRegDetails;
                saveCartRegDetails = {
                    cartId:$scope.cartId,
                    cartName: $scope.cartnameText,
                    activationDate: $scope.activDate,
                    expiry_Date: $scope.expiryDate,
                    cartToken:$scope.carttknText,
                    authToken:$scope.authtknText,
                    renew:$scope.renewText,
                    regId:$scope.regidText,
                    companyId:$scope.cmpnyidText,
                    status:$scope.statusText,
                    url:$scope.urlText,
                    version:$scope.versionText,
                    api:$scope.apiText

                };
                $http.post("/services/saveCartRegistration",angular.toJson(saveCartRegDetails)).then(function (response) {
                    var data = response.data;
                    if(data==""){
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $("#add_new_cart_modal").modal('hide');
                        Notification.success({message: 'AddOn Created  successfully', positionX: 'center', delay: 2000});
                        $scope.removeCartReg();
                        $scope.getCartRegList();
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
