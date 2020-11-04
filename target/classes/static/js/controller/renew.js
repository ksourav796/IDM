
app.controller('renewCtrl', function ($scope, $rootScope, $http, $location, $filter, Notification) {


    $scope.SassControlPanelService="/services";
    $scope.CountryNameText = "";
    $scope.StatusText = "";
    $scope.operation = 'Create';
    //added for pagination purpose @rahul
    $scope.firstPage=true;
    $scope.lastPage=false;
    $scope.pageNo=1;
    $scope.prevPage=false;
    $scope.isPrev=false;
    $scope.isNext=false;
    $scope.customer=1;
    $scope.inactiveStatus="Active";
    $scope.removeCountryDetails = function () {
        $scope.CountryNameText = "";
        $scope.StatusText ="";
        $scope.operation = "";
    };
    $scope.getRenewList = function () {
        $http.post($scope.SassControlPanelService  + "/getRenewList").then(function (response) {
            var data = response.data.object;
            $scope.renewlist= data;
        },function (error) {
            Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
        })
    };

    $scope.getRenewList();




    $scope.saverenew = function () {
        var saveDetails;
        saveDetails = {
            sassOrdersId:$scope.sassOrdersId,
            subscriptionName: $scope.subscriptionNameText,
            validity: $scope.validityText,
            renewDate:$scope.renewaldate
            // companies:$scope.companies
        }
        $http.post("/services/saveOrdersrenew" , angular.toJson(saveDetails)).then(function (response) {
            var data = response.data;
            if(data==""){
                Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
            }
            else {
                $("#add_new_renew_modal").modal('hide');
                $scope.getSubscriptionList();
                Notification.success({message: 'Renew Created  successfully', positionX: 'center', delay: 2000});
            }
        },function (error) {
            Notification.error({
                message: 'Something went wrong, please try again',
                positionX: 'center',
                delay: 2000
            });
        });
    }

});