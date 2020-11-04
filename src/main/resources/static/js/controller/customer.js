app.controller('customerCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";
        $scope.word = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;

        $scope.userRights = [];
        $scope.operation = 'Create';
        $scope.customer = 1;
        $scope.today = new Date();


        $scope.removeCustomerDetails = function () {
            $scope.customerId="";
            $scope.custNameText = "";
            $scope.customerEmailText = "";
            $scope.customerContactText = "";
            $scope.customerAddressText = "";
            $scope.creditLimitText = "";
            $scope.creditTermText = "";
            $scope.fromRegNo = "";
            $scope.gstText = "";
            $scope.accNoText = "";
            $scope.bankNameText = "";
            $scope.IFSCText = "";
            $scope.bankBranchText = "";
            $scope.personInchargeText = "";
            $scope.panNumberText = "";
            $scope.websiteText = "";
            $scope.custStatusText = "";
            $scope.countryId="";
            $scope.currencyId="";
            $scope.stateId="";

        };

        $scope.editcustomer=function(data){
            $scope.customerId=data.customerId;
            $scope.custNameText = data.customerName;
            $scope.customerEmailText = data.email;
            $scope.customerContactText =data.customerNumber ;
            $scope.customerAddressText = data.address;
            $scope.creditLimitText =data.creditedLimit;
            $scope.creditTermText = data.creditedTerm;
            // $scope.fromRegNo = "";
            $scope.gstText = data.gstCode;
            $scope.accNoText = data.accountNo;
            $scope.bankNameText = data.bankName;
            $scope.IFSCText = data.ifsc;
            $scope.bankBranchText = data.branchName;
            $scope.personInchargeText = data.personIncharge;
            $scope.panNumberText = data.panNO;
            $scope.websiteText = data.website;
            $scope.custStatusText = data.status;
            $scope.countryId=data.countryId;
            $scope.currencyId=data.currencyId;
            $scope.stateId=data.stateId;
            $scope.addNewCustomer();
            $scope.getCurrencyList();
            $scope.getstateList();

            $('#customer-title').text("Edit Customer");
            $("#add_new_Customer_modal").modal('show');

        }

        $scope.addNewCustomer = function () {
            // $scope.custNameText = "";
            // $scope.customerEmailText = "";
            // $scope.customerContactText = "";
            // $scope.customerAddressText = "";
            // $scope.creditLimitText = "";
            // $scope.creditTermText = "";
            // $scope.fromRegNo = "";
            // $scope.gstText = "";
            // $scope.accNoText = "";
            // $scope.bankNameText = "";
            // $scope.IFSCText = "";
            // $scope.bankBranchText = "";
            // $scope.personInchargeText = "";
            // $scope.panNumberText = "";
            // $scope.websiteText = "";
            $scope.custStatusText = "Active";
            $http.post("/services/getCountry").then(function (response) {
                var data = response.data.object;
                $scope.countryPojoList=data;
            },function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            });
            $('#customer-title').text("Add Customer");
            $("#add_new_Customer_modal").modal('show');

        };

        $scope.getCurrencyList = function () {
            $(".loader").css("display", "block");
            $http.post($scope.hiposServerURL  + "/getPaginatedCurrencyList").then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.currencyList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };
     $scope.getCurrencyList();


        $scope.getstateList = function () {
            $http.post($scope.hiposServerURL  + "/stateList").then(function (response) {
                var data = response.data.object;
                $scope.stateList= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };

        $scope.getstateList();

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


        $scope.saveCustomer=function () {
            if (angular.isUndefined($scope.custNameText) || $scope.custNameText == '') {
        Notification.warning({message: 'Customer Name can not be Empty', positionX: 'center', delay: 2000});}

            else if(angular.isUndefined($scope.gstText) || $scope.gstText == '') {
                Notification.warning({message: 'gst can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.customerEmailText) || $scope.customerEmailText == '') {
                Notification.warning({message: 'customerEmail can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.customerContactText) || $scope.customerContactText == '') {
                Notification.warning({message: 'customerContact can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.customerAddressText) || $scope.customerAddressText == '') {
                Notification.warning({message: 'customerAddress can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.personInchargeText) || $scope.personInchargeText == '') {
                Notification.warning({message: 'personIncharge can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.bankNameText) || $scope.bankNameText == '') {
                Notification.warning({message: 'bankName can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.accNoText) || $scope.accNoText == '') {
                Notification.warning({message: 'account Number can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.panNumberText) || $scope.panNumberText == '') {
                Notification.warning({message: 'panNumber can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.bankBranchText) || $scope.bankBranchText == '') {
                Notification.warning({message: 'bankBranch can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.IFSCText) || $scope.IFSCText == '') {
                Notification.warning({message: 'IFSC can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.websiteText) || $scope.websiteText == '') {
                Notification.warning({message: 'website can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.creditTermText) || $scope.creditTermText == '') {
                Notification.warning({message: 'creditTerm can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.creditLimitText) || $scope.creditLimitText == '') {
                Notification.warning({message: 'creditLimit can not be Empty', positionX: 'center', delay: 2000});}
        else{
        var saveCustomerDetails;
        saveCustomerDetails = {
            customerId:$scope.customerId,
            customerName: $scope.custNameText,
            customerNumber: $scope.customerContactText,
            email:$scope.customerEmailText,
            gstCode:$scope.gstText,
            bankName:$scope.bankNameText,
            accountNo:$scope.accNoText,
            ifsc:$scope.IFSCText,
            branchName:$scope.bankBranchText,
            personIncharge:$scope.personInchargeText,
            panNO:$scope.panNumberText,
            website:$scope.websiteText,
            address:$scope.customerAddressText,
            creditedLimit:$scope.creditLimitText,
            creditedTerm:$scope.creditTermText,
            status:$scope.custStatusText,
            countryId:$scope.countryId,
            currencyId:$scope.currencyId,
            stateId:$scope.stateId


        };


        $http.post("/services/saveNewCustomer",angular.toJson(saveCustomerDetails)).then(function (response) {
            var data = response.data;
            // if(data==""){
            //     Notification.error({message: 'Email Already exists', positionX: 'center', delay: 2000});
            // }

            if(data==""){
                $("#add_new_Customer_modal").modal('hide');
                Notification.success({message: 'Customer Created  successfully', positionX: 'center', delay: 2000});
                $scope.removeCustomerDetails();
                $scope.getCustomerList();
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
