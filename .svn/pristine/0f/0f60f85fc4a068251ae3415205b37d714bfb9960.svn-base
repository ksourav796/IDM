app.controller('permissionGroupCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";
        $scope.SassControlPanelService="/services";

        $scope.removepermissiongroup = function () {
            $scope.featuresNameText = "";
            $scope.descriptiont = "";
            $scope.pgkey = "";


        }
        // if ($rootScope.userPermission) {
        //     if ($rootScope.userPermission.inv_permission_group == "Restrict") {    //check if the user has permission -- This happens before the page loads
        //         $location.path('/dashboard');                //redirect user to home if it does not have permission.
        //         alert("You don't have access here");
        //     }
        // }
        $scope.getpermissiongroupList = function () {
            $http.post($scope.SassControlPanelService  + "/getPermissionLists").then(function (response) {
                var data=response.data.object;
                $scope.permissiongroupList=data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getpermissiongroupList();

        $scope.addpermissiongroup = function () {
            $scope.id = "";
            $scope.featuresNameText = "";
            $scope.descriptiont = "";
            $scope.pgkey = "";
            $scope.status = "Active";
            $('#permission-title').text("Add permission");
            $("#submit").text("Save");
            $("#add_new_permission_modal").modal('show');
            // $scope.searchText = $scope.itemSearchText;
        }, function (error) {
            Notification.error({
                message: 'Something went wrong, please try again',
                positionX: 'center',
                delay: 2000
            })
        }

        $scope.editgroup=function(data){
            $scope.id=data.pgId;
            $scope.featuresNameText=data.featureName;
            $scope.descriptiont=data.description;
            $scope.pgkey=data.pgkey;
            $scope.status=data.saasStatus;
            $('#permission-title').text("Edit permission");
            $("#add_new_permission_modal").modal('show');
        }


        // $scope.importPopup = function () {
        //     $("#import_group").modal('show');
        // }
        // $scope.saveImport = function () {
        //     var formElement = document.getElementById("itemDetails");
        //     var itemDetails = new FormData(formElement);
        //     $http.post($scope.hiposServerURL + "/" + $scope.customer + '/groupImport', itemDetails,
        //         {
        //             headers: {'Content-Type': undefined},
        //             transformRequest: angular.identity,
        //         }).then(function (response) {
        //             $scope.getpermissiongroupList();
        //             $("#import_group").modal('hide');
        //
        //         }, function (error) {
        //             Notification.error({
        //                 message: 'Something went wrong, please try again',
        //                 positionX: 'center',
        //                 delay: 2000
        //             });
        //         }
        //     )
        // }


        $scope.savepermisssion = function () {
            if ($scope.featuresNameText == '') {
                Notification.error({message: 'Features Name can not be empty', positionX: 'center', delay: 2000});
            } else {
                var permissionDetails;
                permissionDetails = {
                    pgId: $scope.id,
                    featureName: $scope.featuresNameText,
                    description: $scope.descriptiont,
                    saasStatus: $scope.status,
                    pgkey: $scope.pgkey
                };
                $http.post("/services/savepermissiongroup",angular.toJson(permissionDetails) ).then(function (response)   {
                    var data = response.data;
                    if (data == "") {
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removepermissiongroup();
                        $scope.getpermissiongroupList();
                        $("#add_new_permission_modal").modal('hide');
                        if (!angular.isUndefined(data) && data !== null) {
                            $scope.featureName = "";
                        }
                        Notification.success({
                            message: 'Feature Created  successfully',
                            positionX: 'center',
                            delay: 2000
                        });
                    }
                })
            }

        }
        $scope.deletegroup = function (data) {
            bootbox.confirm({
                title: "Alert",
                message: "Do you want to Continue ?",
                buttons: {
                    confirm: {
                        label: 'OK'
                    },
                    cancel: {
                        label: 'Cancel'
                    }

                },
                callback: function (result) {
                    if (result == true) {
                        $scope.pgId = data.pgId;


                        var deleteDetails = {
                            pgId: $scope.pgId

                        };
                        $http.post($scope.hiposServerURL  + '/deletepermissiongroup', angular.toJson(deleteDetails)).then(function (response) {
                            var data = response.data;
                            $scope.status = data.status;
                            if (data == "") {
                                $scope.getpermissiongroupList();
                                Notification.success({
                                    message: 'It Is Already In Use Cant be Deleted',
                                    positionX: 'center',
                                    delay: 2000
                                });
                            } else {
                                $scope.getpermissiongroupList();
                                Notification.success({
                                    message: 'Successfully Deleted',
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
        };



    });