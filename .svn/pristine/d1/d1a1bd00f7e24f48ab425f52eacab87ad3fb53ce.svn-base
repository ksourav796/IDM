app.controller('permissionMasterCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";
        $scope.SassControlPanelService="/services";
        // if ($rootScope.userPermission) {
        //     if ($rootScope.userPermission.inv_permission_master == "Restrict") {    //check if the user has permission -- This happens before the page loads
        //         $location.path('/dashboard');                //redirect user to home if it does not have permission.
        //         alert("You don't have access here");
        //     }
        // }
        $scope.removepermissionmaster = function () {
            $scope.pgId = "";
            $scope.pmId = "";
            $scope.descriptiont = "";
            $scope.level2 = "";
            $scope.featuresNameText = "";
            $scope.permissionMasterkey = "";
            $scope.perm3="";
            $scope.perm4="";
            $scope.permId="";
            $scope.id="";

        }
        $scope.editmaster=function(data){
            $scope.id=data.pmId;
            $scope.pgId =data.pgId;
            $scope.pmId=data.permId;
            $scope.permId=data.perm2;
            $scope.perm3=data.perm3;
            $scope.perm4=data.pmId;
            $scope.permissionMasterkey=data.permissionMasterkey;
            $scope.getpermissiongroupList();
            $scope.getFirstLevelmaster();
            if($scope.pmId!=null){
                $scope.getSecondLevelmaster($scope.pmId);
            }
            if($scope.permId!=null){
                $scope.getthirdLevelmaster($scope.permId);
            }
            if($scope.perm3!=null){
                $scope.getfourthLevelmaster($scope.perm3);
            }
            $scope.descriptiont=data.description;
            $scope.status=data.saasStatus;
            $('#permission-title').text("Edit permission");
            $("#add_new_master_modal").modal('show');
        }
        $scope.getpermissionmasterList = function () {
            $(".loader").css("display", "block");
            $http.post( $scope.SassControlPanelService  + "/getPermissionmasterLists").then(function (response)  {
                var data =response.data.object;
                console.log(data);
                $scope.permissionmaster = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };

        $scope.getpermissionmasterList();

        // $scope.getpermissiongroupList = function () {
        //
        //     $http.get($scope.hiposServerURL + "/" + $scope.customer + "/addpermissiongroupValue").then(function (response) {
        //         var data = response.data;
        //         $scope.permissiongroupList = angular.copy(data);
        //     }, function (error) {
        //         Notification.error({
        //             message: 'Something went wrong, please try again',
        //             positionX: 'center',
        //             delay: 2000
        //         });
        //     });
        // };
        // $scope.getpermissiongroupList();
        $scope.getpermissiongroupList = function () {
            $http.post($scope.SassControlPanelService  + "/getPermissionLists").then(function (response) {
                var data=response.data.object;
                $scope.permissiongroupList=data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getpermissiongroupList();



        $scope.getLevel1PermissionMaster = [];
        $scope.getFirstLevelmaster = function () {
            $http.post($scope.hiposServerURL + '/getFirstLevelpermissionMaster').then(function (response) {
                var data = response.data;
                $scope.firstLevelPermissionList=data.object;
                $scope.PMasterIdNotNull = data.level2List;
                $scope.level2 = "";

            });
        };




        $scope.getLevel2PermissionMaster = [];
        $scope.getSecondLevelmaster = function (permissionmasterID) {
            if ($scope.pmId == null) {
                $scope.level2 = "";
            }
            else {
                $http.post($scope.hiposServerURL  + '/getsecondLevelpermissionMaster2?pmasterId=' + permissionmasterID).then(function (response) {
                    $scope.SecondLevelPermissionList = response.data.object;


                    $scope.level2 = "";
                });
            }
            ;
        }
        $scope.getLevel3PermissionMaster = [];



        $scope.getthirdLevelmaster = function (permissionmasterID) {
            if ($scope.pmId == null) {
                $scope.level2 = "";
            }
            else {
                $http.post($scope.hiposServerURL  + '/getsecondLevelpermissionMaster2?pmasterId=' + permissionmasterID).then(function (response) {
                    $scope.thirdLevelPermissionList = response.data.object;

                    $scope.level2 = "";
                });
            }
            ;
        }
        $scope.getLevel4PermissionMaster = [];
        $scope.getfourthLevelmaster = function (permissionmasterID) {
            if ($scope.pmId == null) {
                $scope.level2 = "";
            }
            else {
                $http.post($scope.hiposServerURL  + '/getsecondLevelpermissionMaster2?pmasterId=' + permissionmasterID).then(function (response) {
                    $scope.fourthLevelPermissionList = response.data.object;

                    $scope.level2 = "";
                });
            }
            ;
        }
        // $scope.implortpermissionmasterpopup = function () {
        //     $("#import_permission").modal('show');
        // }

        // $scope.downloadSheet = function () {
        //     var permissionmaster = "Permissionmaster";
        //     $http({
        //         url: $scope.hiposServerURL + "/" + $scope.customer + '/permissionmasterSheet' + "/" + permissionmaster,
        //         method: "POST",
        //         responseType: 'arraybuffer'
        //     }).success(function (data) {
        //         var blob = new Blob([data], {type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"});
        //         var objectUrl = url.createObjectURL(blob);
        //         window.open(objectUrl);
        //     }).error(function (data, status, headers, config) {
        //         //upload failed
        //     });
        //
        // }

        // $scope.savepermissionmasterImport = function () {
        //     var formElement = document.getElementById("permissionDetails");
        //     var permissionDetails = new FormData(formElement);
        //     $http.post($scope.hiposServerURL + "/" + $scope.customer + '/importpermissionmaster', permissionDetails,
        //         {
        //             headers: {'Content-Type': undefined},
        //             transformRequest: angular.identity,
        //         }).then(function (response) {
        //             $("#import_permission").modal('hide');
        //             $scope.getpermissionmasterList();
        //         }, function (error) {
        //             Notification.error({
        //                 message: 'Something went wrong, please try again',
        //                 positionX: 'center',
        //                 delay: 2000
        //             });
        //         }
        //     )
        // }


        $scope.addpermissionmaster= function () {
            // $scope.featurename = "";
            // $scope.pmId = "";
            // $scope.descriptiont = "";
            // $scope.level2 = "";
            // $scope.permissionMasterkey = "";
            $scope.status = "Active";
            $scope.removepermissionmaster();
            $('#permission-title').text("Add permission");
            $("#submit").text("Save");
            $("#add_new_master_modal").modal('show');
            $scope.getFirstLevelmaster();
        }, function (error) {
            Notification.error({
                message: 'Something went wrong, please try again',
                positionX: 'center',
                delay: 2000
            })
        }

        $scope.savepermisssionmaster = function () {
            var permissionmaster;
            permissionmaster = {
                id:$scope.id,
                pmId: $scope.pmId,
                level2: $scope.level2,
                permId:$scope.permId,
                perm3:$scope.perm3,
                perm4:$scope.perm4,
                description: $scope.descriptiont,
                pgId: $scope.pgId,
                saasStatus: $scope.status,
                permissionMasterkey: $scope.permissionMasterkey
            };
            $http.post($scope.hiposServerURL + '/savepermissionmaster',angular.toJson(permissionmaster) ).then(function (response) {
                var data = response.data;
                if (data == "") {
                    Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else {

                    $scope.removepermissionmaster();
                    $scope.getpermissionmasterList();
                    $("#add_new_master_modal").modal('hide');
                    if (!angular.isUndefined(data) && data !== null) {
                        $scope.featureName = "";
                    }
                    Notification.success({
                        message: 'permission Created  successfully',
                        positionX: 'center',
                        delay: 2000
                    });
                }
            })
        }
        $scope.saveeditpermisssionmaster = function () {
            var permissionmaster;
            permissionmaster = {
               pmId:$scope.id,
                   description:$scope.descriptiont,
                permissionMasterkey:$scope.permissionmasterkey
            };
            $http.post($scope.hiposServerURL + '/saveeditpermissionmaster',angular.toJson(permissionmaster) ).then(function (response) {
                var data = response.data;
                if (data == "") {
                    Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else {

                    $scope.removepermissionmaster();
                    $scope.getpermissionmasterList();
                    $("#edit_new_master_modal").modal('hide');
                    if (!angular.isUndefined(data) && data !== null) {
                        $scope.featureName = "";
                    }
                    Notification.success({
                        message: 'permission Created  successfully',
                        positionX: 'center',
                        delay: 2000
                    });
                }
            })
        }
        $scope.deletemaster = function (data) {
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
                        $scope.pmId = data.pmId;


                        var deleteDetails = {
                            pmId: $scope.pmId

                        };
                        $http.post($scope.hiposServerURL  + '/deletepermission', angular.toJson(deleteDetails)).then(function (response) {
                            var data = response.data;
                            $scope.status = data.status;
                            if (data == "") {
                                $scope.getpermissionmasterList();
                                Notification.success({
                                    message: 'It Is Already In Use Cant be Deleted',
                                    positionX: 'center',
                                    delay: 2000
                                });
                            } else {
                                $scope.getpermissionmasterList();
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