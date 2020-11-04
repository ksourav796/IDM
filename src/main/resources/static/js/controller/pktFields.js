app.controller('pktfieldsCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/pkt";


        $scope.removefieldType = function () {
            $scope.tableName="";
            $scope.fieldName="";
            $scope.groupOf="";
            $scope.status="";
        };

        $scope.getpermissionfieldList = function () {

            $http.post($scope.hiposServerURL  + "/permissionfieldLists" ).then(function (response) {
                var data = response.data.object;
                $scope.fieldtype= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getpermissionfieldList();


        $scope.editField=function(data){
            $scope.id=data.id;
            $scope.tableName=data.tableName;
            $scope.fieldName=data.fieldName;
            $scope.groupOf=data.groupOf;
            $scope.status=data.status;
            $('#cust-notif').text("Edit");
            $("#add_new_pkt_Field_modal").modal('show');
        }

        $scope.addNewPktField = function () {
            $scope.status ="Active";
            $("#add_new_pkt_Field_modal").modal('show');

        };

        $scope.importPopup = function(){
            $("#import_pkt").modal('show');
        }

        $scope.savepktImport = function(){
            $scope.isDisabled= true;
            var formElement = document.getElementById("pktDetails");
            var pktDetails = new FormData(formElement);
            $http.post($scope.hiposServerURL + '/pktImportSaves',pktDetails,
                { headers: {'Content-Type': undefined},
                    transformRequest: angular.identity,
                }).then(function (response) {
                    $("#import_pkt").modal('hide');
                    $scope.getpermissionfieldList();
                    $scope.isDisabled= false;
                }, function (error) {
                    Notification.error({
                        message: 'Something went wrong, please try again',
                        positionX: 'center',
                        delay: 2000
                    });
                    $scope.isDisabled= false;
                }
            )
        }

        $scope.saveFields = function () {
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
                var savefields;
                savefields = {
                    id: $scope.id,
                    tableName: $scope.tableName,
                    fieldName: $scope.fieldName,
                    groupOf: $scope.groupOf,
                    status: $scope.status

                };
                $http.post("/pkt/savePktFieldsPermissions", savefields).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removefieldType();
                        $scope.getpermissionfieldList();
                        $("#add_new_pkt_Field_modal").modal('hide');
                        Notification.success({
                            message: 'Fields Created  successfully',
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