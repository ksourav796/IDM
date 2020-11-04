app.controller('transdataCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";


        $scope.addtransdata = function () {
            $("#add_new_trans_data_modal").modal('show');

        };
        $scope.gettransactiondataList = function () {
            $http.post($scope.hiposServerURL  + "/transdataList").then(function (response) {
                var data = response.data.object;
                $scope.transdata= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };

        $scope.gettransactiondataList();


    });
