app.controller('tablefieldsCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";


        $scope.removetableType = function () {
            $scope.id="";
            $scope.keyNameText="";
            $scope.keyValueText="";
            $scope.keyReferenceText="";
            $scope.keyVisibilityText="";
            $scope.keyPriorityText="";
            $scope.status="";
            $scope.keyName= ""

            // $scope.subscriptionName = "";
            // $scope.permission = "";
            // $scope.validation = "";
            // $scope.descriptor = "";
            // $scope.placeHolder = "";
            // $scope.action = "";
            // $scope.priority = "";
            // $scope.roundOff = "";
            // $scope.sync = "";
            // $scope.tableName = "";
            // $scope.tableName = "";
            // $scope.fieldName = "";
            // $scope.keyReferenceText = "";
            // $scope.keyVisibilityText = "";
            // $scope.action= "";
            // $scope.placeHolder= "";
            // $scope.validation= "";
            // $scope.priority =  "";
            // $scope.sync= "";
            // $scope.descriptor= "";
            // $scope.status = "";
        };

        //get tableNameIn Pkt Fields
        $scope.getTableList = function () {
            $(".loader").css("display", "block");
            $http.post('/services' + '/getPktTablepermissionMaster').then(function (response) {
                var data = response.data.object;
                $scope.tableNameList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                })
            });
        };
        $scope.getTableList();



        //Get PKT FieldsName In PKT Fields Table fieldName
        // $scope.getFieldsNameList = [];
        $scope.getFieldsNameList = function (tableName) {
            $(".loader").css("display", "block");
            $http.post('/services' + '/getPktpermissionMaster?tableName=' + tableName).then(function (response) {
                var data = response.data.object;
                $scope.tableFieldNameList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                })
            });
        };
        $scope.getFieldsNameList();


        $scope.getSubscriptionList = function () {
            $(".loader").css("display", "block");
            $http.post($scope.hiposServerURL + "/getSubscriptionList").then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.subscriptionList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };

        $scope.getSubscriptionList();
        $scope.getPktPermisssionList = function () {

            $http.post($scope.hiposServerURL  + "/getPktPermisssionList" ).then(function (response) {
                var data = response.data.object;
                $scope.tabletype= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getPktPermisssionList();



        $scope.editTable=function(data){
            $scope.pktPermissionId=data.pktPermissionId;
            $scope.keyNameText=data.keyName;
            $scope.keyValueText=data.keyValue;
            $scope.keyReferenceText=data.keyReference;
            $scope.keyVisibilityText=data.keyVisibility;
            $scope.keyPriorityText=data.keyPriority;
            $scope.status=data.status;
            $scope.keyName=data.keyName;
            $('#cust-notif').text("Edit");
            $('#submit').text("UpDate");
            $("#add_new_pkt_Table_modal").modal('show');
        }
        // $scope.editTable = function (data) {
        //     $scope.subscriptionName = data.keySubscription;
        //     $scope.tableName = data.keyName;
        //     $scope.keyValue = data.keyValue;
        //     $scope.keyReferenceText = data.keyReference;
        //     $scope.keyVisibilityText = data.keyVisibility;
        //     $scope.action=data.keyAction;
        //     $scope.placeHolder=data.keyPlaceHolder;
        //     $scope.validation=data.keyValidation;
        //     $scope.priority = data.keyPriority;
        //     $scope.sync=data.sync;
        //     $scope.descriptor=data.descriptor;
        //     $scope.pktpermission=data.permission;
        //     $scope.status = data.status;
        //     $scope.operation === 'Edit';
        //     $('#cust-notif').text("Edit Table");
        //     $('#submit').text("UpDate");
        //     $("#add_new_pkt_Table_modal").modal('show');
        // }

        $scope.addNewPkt = function () {
            $("#add_new_pkt_Table_modal").modal('show');

        };
        $scope.saveTable = function () {
            // if ($scope.keyNameText === '') {
            //     Notification.warning({
            //         message: 'keyName  can not be empty',
            //         positionX: 'center',
            //         delay: 2000
            //     });
            // }
            // else if($scope.keyValueText === ''){
            //     Notification.warning({
            //         message: 'keyValue  can not be empty',
            //         positionX: 'center',
            //         delay: 2000
            //
            //
            //     });
            // }
            // else {
                var savetable;
                savetable = {
                    pktPermissionId:$scope.pktPermissionId,
                    keyName:$scope.keyNameText,
                    keyValue:$scope.keyValueText,
                    keyReference:$scope.keyReferenceText,
                    keyVisibility:$scope.keyVisibilityText,
                    keyPriority:$scope.keyPriorityText,
                    status:$scope.status,
                    keyGroup:$scope.keyName

                };
                $http.post("/services/savePktFieldsPermission", savetable).then(function (response) {
                    var data = response.data;
                    if(data==""){
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removetableType();
                        $scope.getPktPermisssionList();
                        $("#add_new_pkt_Table_modal").modal('hide');
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

            };

        // };
        // $scope.saveTable = function () {
        //     // if ($scope.keyNameText === '') {
        //     //     Notification.warning({
        //     //         message: 'keyName  can not be empty',
        //     //         positionX: 'center',
        //     //         delay: 2000
        //     //     });
        //     // }
        //     // else if ($scope.keyValueText === '') {
        //     //     Notification.warning({
        //     //         message: 'keyValue  can not be empty',
        //     //         positionX: 'center',
        //     //         delay: 2000
        //     //
        //     //
        //     //     });
        //     // }
        //     // else {
        //     var savetable;
        //     savetable = {
        //         pktPermissionId: $scope.pktPermissionId,
        //         keySubscription: $scope.subscriptionName,
        //         keyName: $scope.tableName,
        //         keyValue: $scope.keyValue,
        //         KeyGroup:$scope.groupOf,
        //         keyReference: $scope.keyReferenceText,
        //         keyVisibility: $scope.keyVisibilityText,
        //         keyPriority: $scope.keyPriorityText,
        //         permission: $scope.pktpermission,
        //         keyValidation: $scope.validation,
        //         descriptor: $scope.descriptor,
        //         keyPlaceHolder: $scope.placeHolder,
        //         keyAction: $scope.action,
        //         keyPriority: $scope.priority,
        //         roundOff: $scope.roundOff,
        //         sync: $scope.sync
        //     };
        //     $http.post("/services/savePktPermsission", savetable).then(function (response) {
        //         var data = response.data;
        //         if (data == "") {
        //             Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
        //         }
        //         else {
        //             $scope.removetableType();
        //             $scope.getPktPermisssionList();
        //             $("#add_new_pkt_Table_modal").modal('hide');
        //             Notification.success({
        //                 message: 'Table Created  successfully',
        //                 positionX: 'center',
        //                 delay: 2000
        //             });
        //         }
        //     }, function (error) {
        //         Notification.error({
        //             message: 'Something went wrong, please try again',
        //             positionX: 'center',
        //             delay: 2000
        //         });
        //     });
        //
        // }


        // };
    });