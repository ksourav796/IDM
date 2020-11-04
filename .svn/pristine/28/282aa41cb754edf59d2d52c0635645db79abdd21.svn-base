app.controller('columnTypeCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/pkt";
        $scope.number = /^[0-9]/;


        $scope.removetableType = function () {
            $scope.description = "";
            $scope.name = "";
            $scope.status = "Active";
            // $scope.id = null;


        };

        $scope.getAllColumnTypeList = function () {
            $(".loader").css("display", "block");
            $http.post('/pkt' + '/getAllColumnTypeLists').then(function (response) {
                var data = response.data.object;
                $scope.columnTypeList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                })
            });
        };
        $scope.getAllColumnTypeList();



        $scope.editTable = function (data) {
            $scope.id = data.id;
            $scope.name = data.name;
            $scope.description = data.description;
            $scope.status = data.status;
            $scope.operation === 'Edit';
            $('#cust-notif').text("Edit Column Type");
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
                    Id:$scope.id,
                    name: $scope.name,
                    description: $scope.description,
                    status: $scope.status
                };
                $http.post("/pkt/saveColumnTypes", savetable).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removetableType();
                        $scope.getAllColumnTypeList();
                        $("#add_new_pkt_Table_modal").modal('hide');
                        Notification.success({
                            message: 'Column Type Created  successfully',
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