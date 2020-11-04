app.controller('validatorCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/pkt";


        $scope.removeValidator = function () {
            $scope.name="";
            $scope.description="";
            $scope.status="";
        };

        $scope.getValidatorList = function () {

            $http.post($scope.hiposServerURL  + "/getValidatorLists" ).then(function (response) {
                var data = response.data.object;
                $scope.validatortype= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getValidatorList();



        $scope.editValidator=function(data){
            $scope.id=data.id;
            $scope.name=data.name;
            $scope.description=data.description;
            $scope.status=data.status;
            $('#cust-notif').text("Edit");
            $("#add_new_validator_modal").modal('show');
        }

        $scope.addNewValidator = function () {
            $scope.status ="Active";
            $scope.id=null;
            $scope.name="";
            $scope.description="";
            $("#add_new_validator_modal").modal('show');

        };
        $scope.saveValidator = function () {
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
                var saveValidator;
                saveValidator = {
                    id: $scope.id,
                    name: $scope.name,
                    description: $scope.description,
                    status: $scope.status

                };
                $http.post("/pkt/saveValidators", saveValidator).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removeValidator();
                        $scope.getValidatorList();
                        $("#add_new_validator_modal").modal('hide');
                        Notification.success({
                            message: 'Validator Created  successfully',
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