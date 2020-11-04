app.controller('personalCtrl', function ($scope, $rootScope, $http, $location, $filter, Notification,$timeout) {


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
});
