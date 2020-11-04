app.controller('permissionCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";
        $scope.number = /^[0-9]/;


        $scope.removetableType = function () {
            $scope.description = "";
            $scope.name = "";
            $scope.status = "Active";


        };

        $scope.getAllPermissionList = function () {
            $(".loader").css("display", "block");
            $http.post('/services' + '/getAllPermissionList').then(function (response) {
                var data = response.data.object;
                $scope.permissionList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                })
            });
        };
        $scope.getAllPermissionList();



        $scope.editTable = function (data) {
            $scope.permissionId=data.permissionId;
            $scope.name = data.name;
            $scope.description = data.description;
            $scope.status = data.status;
            $scope.operation === 'Edit';
            $('#cust-notif').text("Edit Permission");
            $('#submit').text("UpDate");
            $("#add_new_pkt_Table_modal").modal('show');
        }

        $scope.addNewPkt = function () {
            $scope.status = "Active";
            $("#add_new_pkt_Table_modal").modal('show');

        };
        $scope.saveTable = function () {
            if ($scope.name === '') {
                Notification.warning({
                    message: 'name  can not be empty',
                    positionX: 'center',
                    delay: 2000
                });
            }
            else {
                var savetable;
                savetable = {
                    permissionId:$scope.permissionId,
                    name: $scope.name,
                    description: $scope.description,
                    status: $scope.status
                };
                $http.post("/services/savePermsission", savetable).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removetableType();
                        $scope.getAllPermissionList();
                        $("#add_new_pkt_Table_modal").modal('hide');
                        Notification.success({
                            message: 'Permission Created  successfully',
                            positionX: 'center',
                            delay: 2000
                        });
                    }
                }, function (error) {
                    Notification.error({
                        message: 'Something went wrong, please try again',
                        positionX: 'center',
                        delay: 2000
                    });
                });

            }
            ;

        };
    });