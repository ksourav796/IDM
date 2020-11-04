app.controller('visibilityCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";


        $scope.removeVisibility = function () {
            $scope.visible="";
            $scope.description="";
            $scope.status="";
        };

        $scope.getVisibleList = function () {

            $http.post($scope.hiposServerURL  + "/getVisibleList" ).then(function (response) {
                var data = response.data.object;
                $scope.visibilitytype= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getVisibleList();



        $scope.editVisibility=function(data){
            $scope.id=data.id;
            $scope.visible=data.vs1;
            $scope.description=data.vs2;
            $scope.status=data.vs3;
            $('#cust-notif').text("Edit");
            $("#add_new_Visible_modal").modal('show');
        }

        $scope.addNewVisibility = function () {
            $scope.status ="Active";
            $("#add_new_Visible_modal").modal('show');

        };
        $scope.saveVisibilty = function () {
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
                var saveVisibilty;
                saveVisibilty = {
                    id: $scope.id,
                    vs1: $scope.visible,
                    vs2: $scope.description,
                    vs3: $scope.status

                };
                $http.post("/services/saveVisibility", saveVisibilty).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removeVisibility();
                        $scope.getVisibleList();
                        $("#add_new_Visible_modal").modal('hide');
                        Notification.success({
                            message: 'Visibility Created  successfully',
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