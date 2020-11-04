
app.controller('addOnCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";
        $scope.customerId = 1;
        $scope.userRights = [];
        $scope.operation = 'Create';
        $scope.customer = 1;
        $scope.today = new Date();

        $scope.removeAddOn = function () {
            $scope.adoneId="";
            $scope.addonNameText="";
            $scope.addonPriceText="";
            $scope.addonPerText="";
            $scope.subscriptionText="";
        };

        $scope.getAddOnList = function () {
            $(".loader").css("display", "block");
            $http.post($scope.hiposServerURL  + "/getAddOnList").then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.addonList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };

        $scope.getAddOnList();

        $scope.getSubscriptionList = function () {
            $(".loader").css("display", "block");
            $http.post($scope.hiposServerURL  + "/getSubscriptionList").then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.subscriptionList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };
        $scope.getSubscriptionList();

        // $scope.getPaginatedSubscriptionList = function (page) {
        //     switch (page) {
        //         case 'firstPage':
        //             $scope.firstPage = true;
        //             $scope.lastPage = false;
        //             $scope.isNext = false;
        //             $scope.isPrev = false;
        //             $scope.pageNo = 0;
        //             break;
        //         case 'lastPage':
        //             $scope.lastPage = true;
        //             $scope.firstPage = false;
        //             $scope.isNext = false;
        //             $scope.isPrev = false;
        //             $scope.pageNo = 0;
        //             break;
        //         case 'nextPage':
        //             $scope.isNext = true;
        //             $scope.isPrev = false;
        //             $scope.lastPage = false;
        //             $scope.firstPage = false;
        //             $scope.pageNo = $scope.pageNo + 1;
        //             break;
        //         case 'prevPage':
        //             $scope.isPrev = true;
        //             $scope.lastPage = false;
        //             $scope.firstPage = false;
        //             $scope.isNext = false;
        //             $scope.pageNo = $scope.pageNo - 1;
        //             break;
        //         default:
        //             $scope.firstPage = true;
        //             $scope.lastPage = false;
        //             $scope.isNext = false;
        //             $scope.isPrev = false;
        //             $scope.pageNo = 0;
        //     }
        //     var paginationDetails;
        //     paginationDetails = {
        //         firstPage: $scope.firstPage,
        //         lastPage: $scope.lastPage,
        //         pageNo: $scope.pageNo,
        //         prevPage: $scope.prevPage,
        //         prevPage: $scope.isPrev,
        //         nextPage: $scope.isNext
        //     }
        //     if (angular.isUndefined($scope.searchText)) {
        //         $scope.searchText = "";
        //     }
        //     $http.post($scope.hiposServerURL + '/getPaginatedSubscriptionList?&searchText=' + $scope.searchText, angular.toJson(paginationDetails)).then(function (response) {
        //         var data = response.data;
        //         $scope.subscriptionList = data.list;
        //         $scope.first = data.firstPage;
        //         $scope.last = data.lastPage;
        //         $scope.prev = data.prevPage;
        //         $scope.next = data.nextPage;
        //         $scope.pageNo = data.pageNo;
        //         $scope.listStatus = true;
        //
        //     }, function (error) {
        //         Notification.error({
        //             message: 'Something went wrong, please try again',
        //             positionX: 'center',
        //             delay: 2000
        //         });
        //     })
        // };
        // $scope.getPaginatedSubscriptionList();

        $scope.editaddon=function(data){
            $scope.adoneId=data.adoneId;
            $scope.addonNameText=data.addonName;
            $scope.addonPriceText=data.addonPrice;
            $scope.addonPerText=data.addonPermission;
            $scope.itemStatusText=data.status;
            $scope.subscriptionText=data.subscriptionId;
            // $scope.subscriptionText=data.subscriptionId
            $scope.getSubscriptionList();
            $("#title").text("Edit");
            $("#add_new_addon_modal").modal('show');
        }

        $scope.addNewAddon = function () {

            $scope.addonNameText="";
            $scope.addonPriceText="";
            $scope.addonPerText="";
            $scope.itemStatusText="Active";
            $scope.removeAddOn();
            $("#title").text("Add");
            $("#add_new_addon_modal").modal('show');
        };

        ;
        $scope.saveAddOn = function () {
            if (angular.isUndefined($scope.addonNameText) || $scope.addonNameText == '') {
                Notification.warning({message: 'AddOn Name can not be Empty', positionX: 'center', delay: 2000});
            }
            else if(angular.isUndefined($scope.addonPriceText) || $scope.addonPriceText == '') {
                Notification.warning({message: 'addonPrice can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.addonPerText) || $scope.addonPerText == '') {
                Notification.warning({message: 'addonPermission can not be Empty', positionX: 'center', delay: 2000});}

            else{
                var saveAddOnDetails;
                saveAddOnDetails = {
                    adoneId:$scope.adoneId,
                    addonName: $scope.addonNameText,
                    addonPrice: $scope.addonPriceText,
                    addonPermission: $scope.addonPerText,
                    status:$scope.itemStatusText,
                    subscriptionId:$scope.subscriptionText
                };
                $http.post("/services/saveNewAddOn",angular.toJson(saveAddOnDetails)).then(function (response) {
                    var data = response.data;
                    if(data==""){
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $("#add_new_addon_modal").modal('hide');
                        Notification.success({message: 'AddOn Created  successfully', positionX: 'center', delay: 2000});
                        $scope.removeAddOn();
                        $scope.getAddOnList();
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
