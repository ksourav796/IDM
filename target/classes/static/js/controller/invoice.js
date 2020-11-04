app.controller('invoiceCtrl', function ($scope, $rootScope, $http, $location, $filter, Notification,$timeout) {


    $scope.SassControlPanelService = "/services";

    $scope.getSubscriptionListbasedonUser = function () {
            $http.post($scope.SassControlPanelService + '/getSubscriptionListbasedonUser').then(function (response) {
                var data = response.data;
                $scope.subscriptionListUser = data;
                // window.location.reload();
                console.log(data);
            }, function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
    };

    $scope.getSubscriptionListbasedonUser();

    $scope.format = 'dd/MM/yyyy';
    $scope.dateOptions = {
        minDate : new Date()
    };
    $scope.open11 = function() {
        $scope.popup11.opened = true;
    };
    $scope.popup11 = {
        opened: false
    };

    $scope.renewsubscription = function (data) {
        $scope.subscriptionId = data.subscriptionId;
        $scope.subscriptionNameText = data.subscriptionName;
        if(data.renewValidity!=null){
            $scope.validityText = data.renewValidity;
        }else {
            $scope.validityText = data.validity;
        }
        if(data.renewDate!=null) {
            $scope.renewaldate = new Date(data.renewDate);
        }else {
            $scope.renewaldate = new Date();
        }
        // $scope.companies = data.companies;
        $("#add_new_renew_modal").modal('show');
    }


    $scope.saverenew = function () {
        var saveDetails;
        saveDetails = {
            sassOrdersId:$scope.subscriptionId,
            // userAccountId:$scope.userAccountId,
            subscriptionName: $scope.subscriptionNameText,
            validity: $scope.validityText,
            renewDate:$scope.renewaldate
            // companies:$scope.companies
        }
        $http.post("/services/saveOrdersrenew" , angular.toJson(saveDetails)).then(function (response) {
            var data = response.data;
            window.location.reload();
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
