
/**
 * Created by azgar.h on 6/22/2017.
 */
app.controller('permissionListController',
    function($scope, $http, $location, $filter, Notification, ngTableParams,  $timeout, $window, $cookies){
        $scope.hiposServerURL = "/services";
        console.log("ddddddddddddd");
        $scope.getPageLoadData = function () {
            $http.post($scope.hiposServerURL + '/getPermissionList').then(function (response) {
                var data = response.data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getPageLoadData();
    });