app.controller('positionCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/pkt";


        $scope.removePosition = function () {
            $scope.name="";
            $scope.description="";
            $scope.status="";
        };

        $scope.getPositionList = function () {

            $http.post($scope.hiposServerURL  + "/getPositionLists" ).then(function (response) {
                var data = response.data.object;
                $scope.positiontype= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getPositionList();



        $scope.editPosition=function(data){
            $scope.id=data.id;
            $scope.name=data.name;
            $scope.description=data.description;
            $scope.status=data.status;
            $('#cust-notif').text("Edit");
            $("#add_new_Position_modal").modal('show');
        }

        $scope.addNewPosition = function () {
            $scope.status ="Active";
            $("#add_new_Position_modal").modal('show');

        };
        $scope.savePosition = function () {
            // if ($scope.tableName === '') {
            //     Notification.warning({
            //         message: 'TableName  can not be empty',
            //         positionX: 'center',
            //         delay: 2000
            //     });
            // }
            // else if($scope.fieldName === ''){
            //     Notification.warning({
            //         message: 'FieldName  can not be empty',
            //         positionX: 'center',
            //         delay: 2000
            //
            //
            //     });
            // }
        // else
            {
                var savePosition;
                savePosition = {
                    id: $scope.id,
                    name: $scope.name,
                    description: $scope.description,
                    status: $scope.status

                };
                $http.post("/pkt/savePositions", savePosition).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removePosition();
                        $scope.getPositionList();
                        $("#add_new_Position_modal").modal('hide');
                        Notification.success({
                            message: 'Position Created  successfully',
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
        }




    });