app.controller('tableCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/pkt";
        $scope.hiposServerURLS = "/services";
        $scope.number = /^[0-9]/;
        $scope.firstPage = true;
        $scope.lastPage = false;
        $scope.isNext = false;
        $scope.isPrev = false;

        $scope.removetableType = function () {
            $scope.subscriptionName = "";
            $scope.permission = "";
            $scope.validation = "";
            $scope.descriptor = "";
            $scope.placeHolder = "";
            $scope.action = "";
            $scope.priority = "";
            $scope.roundOff = "";
            $scope.sync = "";
            $scope.tableName = "";
            $scope.tableName = "";
            $scope.fieldName = "";
            $scope.keyReferenceText = "";
            $scope.keyVisibilityText = "";
            $scope.action= "";
            $scope.placeHolder= "";
            $scope.validation= "";
            $scope.priority =  "";
            $scope.sync= "";
            $scope.descriptor= "";
            $scope.status = "";
            $scope.nameo = "";
            $scope.isDisabled = false;
        };


        //getAllOpertorList
        $scope.getOperatorList = function () {

            $http.post($scope.hiposServerURL  + "/getOperatorLists" ).then(function (response) {
                var data = response.data.object;
                $scope.operatortype= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getOperatorList();


//Get
//         $scope.getPermissionList = function () {
//             $(".loader").css("display", "block");
//             $http.post('/services' + '/getPktPermisssionList').then(function (response) {
//                 var data = response.data.object;
//                 $scope.permissionList = data;
//
//             }, function (error) {
//                 Notification.error({
//                     message: 'Something went wrong, please try again',
//                     positionX: 'center',
//                     delay: 2000
//                 })
//             });
//         };
//         $scope.getPermissionList();

        $scope.getTableList = function (subscriptionName) {
            $(".loader").css("display", "block");
            $http.post('/pkt' + '/getPktTablepermissionMasters?subscriptionName=' + subscriptionName).then(function (response) {
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


        //Get PKT FieldsName In PKT Fields Table fieldName
        // $scope.getFieldsNameList = [];
        $scope.getFieldsNameList = function (tableName) {
            $(".loader").css("display", "block");
            $http.post('/pkt' + '/getPktFieldspermissionMasters?tableName=' + tableName).then(function (response) {
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
            $http.post($scope.hiposServerURLS + "/getSubscriptionList").then(function (response) {
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
        $scope.getApplicationList = function () {

            $http.post($scope.hiposServerURL  + "/getApplicationLists" ).then(function (response) {
                var data = response.data.object;
                $scope.applicationtype= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getApplicationList();
        // $scope.getPktPermisssionList = function () {
        //
        //     $http.post($scope.hiposServerURL + "/getPktPermisssionList").then(function (response) {
        //         var data = response.data.object;
        //         $scope.tabletype = data;
        //     }, function (error) {
        //         Notification.error({
        //             message: 'Something went wrong, please try again',
        //             positionX: 'center',
        //             delay: 2000
        //         });
        //     })
        // };
        // $scope.getPktPermisssionList();


        $scope.editTable = function (data) {
            $scope.pktPermissionId = data.pktPermissionId;
            $scope.subscriptionName = data.keySubscription;
            $scope.tableName = data.keyName;
            $scope.fieldName = data.keyValue;
            $scope.status=data.status;
            $scope.validation=data.keyValidation;
            $scope.descriptor=data.descriptor;
            $scope.nameo=data.operator;
            $scope.menu = data.menuKey;
            $scope.getmenulistbasedonapplication($scope.subscriptionName);
            $scope.placeHolder=data.keyPlaceHolder;
            $scope.operation1 = 'Edit';
            $scope.getTableList($scope.subscriptionName);
            $scope.getFieldsNameList($scope.tableName);
            $('#cust-notif').text("Edit Table");
            $('#submit').text("UpDate");
            $("#add_new_pkt_Table_modal").modal('show');
        }

        $scope.searchrow = function(type){
            $scope.tablecode=type.keyName;
            $http.post("/pkt/editSearch?id="+type.pktPermissionId).then(function (response) {
                $scope.codesList = [];
                var data = response.data;
                $scope.codesList = data;
                $http.post("/pkt/getPktFieldspermissionMasters?tableName="+type.keyName).then(function (response) {
                var data = response.data.object;
                $scope.codeslist = data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            });
            });
            $("#add_new_Table_fields_modal").modal('show');
        }


        $scope.codesList = [];
        $scope.addFooterValueOperation = function () {
            if ($scope.codesList == "") {
                $scope.codesList = [];
            }
            $scope.codesList.push({});
        };


        $scope.saveValue = function(data){
            $http.post("/pkt/saveSearch?tablecode="+$scope.tablecode,angular.toJson(data)).then(function (response) {
                var data = response.data.object;
                $scope.codes = data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
            $("#add_new_Table_fields_modal").modal('hide');
        };



        $scope.saveplus = function(data){
            $http.post("/pkt/saveplus?id="+$scope.pktPermissionId,angular.toJson(data)).then(function (response) {
                var data = response.data;
                $("#add_new_Table_pluskey_modal").modal('hide');
                Notification.success({
                    message: 'PlusKey Saved  Successfully',
                    positionX: 'center',
                    delay: 2000
                });
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        }
        $scope.createtableslist=[];
        $scope.addcreatetable = function(){
            $scope.createtableslist.push({})
        };


        $scope.createtables1list=[];
        $scope.addalltables = function(){
            $scope.createtables1list.push({})
        };

        $scope.updatetableslist=[];
        $scope.addupdatetable = function(){
            $scope.updatetableslist.push({
                'fromtable':$scope.fromtable
            });
           $scope.getfromcolumnlist($scope.fromtable);
        };


        $scope.createtable = function(type){
            $scope.keyname=null;
            $scope.keySubscription=type.keySubscription;
            $scope.pktPermissionId = type.pktPermissionId;
            $scope.getTableListOnApp();
            $("#add_new_Table_createtable_modal").modal('show');
        };
        $scope.updatetable = function(type){
            $scope.fromtable = type.keyName;
            $scope.keySubscription=type.keySubscription;
            $scope.pktPermissionId = type.pktPermissionId;
            $scope.getTableListOnApp();
            $("#add_new_Table_updatetable_modal").modal('show');
        };



    $scope.opentablelist = function(){

            $("#add_new_Table_createtable1_modal").modal('show');
        };


        $scope.getfromcolumnlist = function (data) {
            $http.post("/pkt/getPktFieldspermissionMasters?tableName=" + data).then(function (response) {
                var data = response.data.object;
                $scope.fromcolumnlist = data;
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            });
        };


        $scope.getTableListOnApp = function () {
            $http.post('/pkt' + '/getTablesListBasedOnApplication?name='+$scope.keySubscription).then(function (response) {
                var data = response.data.object;
                $scope.tableslist = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                })
            });
        };

        $scope.addNewPkt = function () {
            $scope.status="Active";
            $scope.pktPermissionId=null;
            $scope.operation1="Create";
            $scope.subscriptionName =null;
            $scope.tableName =null;
            $scope.fieldName = "";
            $scope.nameo =null;
            $scope.placeHolder = "";
            $scope.descriptor = ""
            $("#add_new_pkt_Table_modal").modal('show');

        };
        $scope.saveTable = function () {
            if (angular.isUndefined($scope.subscriptionName) || $scope.subscriptionName == ''){
                Notification.warning({
                    message: 'SubscriptionName  can not be empty',
                    positionX: 'center',
                    delay: 2000
                });
            }
            else if (angular.isUndefined($scope.tableName) || $scope.tableName == '') {
                Notification.warning({
                    message: 'Select Table  can not be empty',
                    positionX: 'center',
                    delay: 2000


                });
            }
            else if (angular.isUndefined($scope.fieldName) || $scope.fieldName == '') {
                Notification.warning({
                    message: 'Table Name  can not be empty',
                    positionX: 'center',
                    delay: 2000


                });
            }
            else {
                $scope.isDisabled = true;
                var savetable;
                savetable = {
                    pktPermissionId: $scope.pktPermissionId,
                    keySubscription: $scope.subscriptionName,
                    keyName: $scope.tableName,
                    keyValue: $scope.fieldName,
                    status:$scope.status,
                    keyReference: $scope.keyReferenceText,
                    keyVisibility: $scope.keyVisibilityText,
                    permission: $scope.pktpermission,
                    keyValidation: $scope.validation,
                    descriptor: $scope.descriptor,
                    keyPlaceHolder: $scope.placeHolder,
                    keyAction: $scope.action,
                    menuKey:$scope.menu,
                    keyPriority: $scope.priority,
                    roundOff: $scope.roundOff,
                    sync: $scope.sync,
                    operator:$scope.fieldName,
                    tableName:$scope.fieldName,
                    subMenuKey:$scope.child
                    // fieldName
                    // groupOf


                };
                $http.post("/pkt/savePktPermsissions", savetable).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        $scope.isDisabled = false;
                        Notification.error({message: 'Already exists ', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removetableType();
                        $scope.getpaginatedTableList();
                        $("#add_new_pkt_Table_modal").modal('hide');
                        Notification.success({
                            message: 'Table Created  successfully',
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
        $scope.getpaginatedTableList = function (page) {
            switch (page) {
                case 'firstPage':
                    $scope.firstPage = true;
                    $scope.lastPage = false;
                    $scope.isNext = false;
                    $scope.isPrev = false;
                    $scope.pageNo = 0;
                    break;
                case 'lastPage':
                    $scope.lastPage = true;
                    $scope.firstPage = false;
                    $scope.isPrev = false;
                    $scope. isNext = false;
                    $scope.pageNo = 0;
                    break;
                case 'nextPage':
                    $scope.isNext = true;
                    $scope.isPrev = false;
                    $scope.lastPage = false;
                    $scope.firstPage = false;
                    $scope.pageNo = $scope.pageNo + 1;
                    break;
                case 'prevPage':
                    $scope.isPrev = true;
                    $scope.lastPage = false;
                    $scope.firstPage = false;
                    $scope.isNext = false;
                    $scope.pageNo = $scope.pageNo - 1;
                    break;
                default:
                    $scope.firstPage = true;
                    $scope.lastPage = false;
                    $scope.isPrev = false;
                    $scope.isNext = false;
                    $scope.pageNo = 0;
            }
            var paginationDetails;
            paginationDetails = {
                firstPage: $scope.firstPage,
                lastPage: $scope.lastPage,
                pageNo: $scope.pageNo,
                prevPage: $scope.isPrev,
                nextPage: $scope.isNext
            }
            if (angular.isUndefined($scope.searchText)) {
                $scope.searchText = "";
            }
            if (angular.isUndefined($scope.searchText1)) {
                $scope.searchText1 = "";
            }
            if (angular.isUndefined($scope.searchText2)) {
                $scope.searchText2 = "";
            }


            $http.post($scope.hiposServerURL + '/getPaginatedtableLists?searchText=' + $scope.searchText+' &searchText1=' + $scope.searchText1
                +'&searchText2=' + $scope.searchText2, angular.toJson(paginationDetails)).then(function (response){
                var data = response.data;
                console.log(data);
                $scope.permissionList = data.list;
                $scope.first = data.firstPage;
                $scope.last = data.lastPage;
                $scope.prev = data.prevPage;
                $scope.next = data.nextPage;
                $scope.pageNo = data.pageNo;
                $scope.listStatus = true;
                if (data == "") {
                    Notification.error({message: 'Search Not Found', positionX: 'center', delay: 2000});
                }

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })
        };
        $scope.getpaginatedTableList();


        $scope.getMenuBuilderList = function () {
            $http.post($scope.hiposServerURL + "/getMenuBuilderList").then(function (response) {
                var data = response.data.object;
                $scope.menuList = data;
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })
        };
        $scope.getMenuBuilderList();

       $scope.getmenulistbasedonapplication= function(data){

            $http.post($scope.hiposServerURL + "/getMenuListBasedOnApplication?name="+data).then(function (response) {
                var data = response.data.object;
                $scope.menuListbasedonapp = data;
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })
        };
        $scope.getmenuchildbasedonchild= function(data){
            angular.forEach($scope.menuListbasedonapp,function (val,key) {
                if(val.menuName==data){
                    $scope.menuListbasedonchild = angular.fromJson(val.ParentId);
                }
            })

        };


        $scope.saveCreatedFields=function (data) {
            $scope.operation = angular.toJson(data);
            $("#add_new_Table_createtable1_modal").modal('hide');
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

        $scope.pluskey = function(data){
            $scope.keyName = data.keyName;
            $scope.pktPermissionId = data.pktPermissionId;
            // $http.post("/pkt/editPlus?id="+$scope.pktPermissionId).then(function (response) {
            //     var data = response.data;
            //     $scope.pluskeylist = data;
            //     angular.forEach($scope.pluskeylist,function (val,key) {
            //         // val.columnName = array[0];
            //     })
            $http.post("pkt/getPlusKeyList?name="+data.keyName).then(function (response) {
                $scope.pluskeylist=[];
                var data = response.data;
                $scope.pluskeylist1 = data;
            })
            // })

             $("#cust-notif").text('Plus Key');
            $("#add_new_Table_pluskey_modal").modal('show');
        }

        $scope.savekeyoperation = function () {
            var details;
            details={operation:$scope.operation
            };
            $scope.createtablePojoList=[];
            $scope.createtablePojoList.push(details);
            $http.post("/pkt/saveCreatedfields?id="+$scope.pktPermissionId,angular.toJson($scope.createtablePojoList)).then(function (response) {
                var data = response.data.object;
                $scope.codes = data;
                $("#add_new_Table_createtable_modal").modal('hide');
                Notification.success({
                    message: 'KeyOperation Saved  Successfully',
                    positionX: 'center',
                    delay: 2000
                });
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };

        $scope.removeAddNewUpdate = function(){
            $scope.updatetableslist.pop({
            })
        };

        $scope.removeAddNewCreateTable = function(){
            $scope.createtables1list.pop({
            })
        };
        $scope.removeaddnew = function(){
            $scope.createtableslist.pop({
            })
        };
        $scope.removeAddNewSearch = function(){
            $scope.codesList.pop({
            })
        };

        $scope.removeAddNewKey = function(){
            $scope.pluskeylist.pop({})
        };


        $scope.pluskeylist= [];
        $scope.adnewpluskey = function(){

            $scope.pluskeylist.push({});
        }


        $scope.saveUpdateTable = function (type) {
            $http.post("/pkt/saveUpdateFields?id="+$scope.pktPermissionId,angular.toJson(type)).then(function (response) {
                var data = response.data.object;
                $scope.codes = data;
                $("#add_new_Table_updatetable_modal").modal('hide');
                Notification.success({
                    message: 'UpdateTable Saved  Successfully',
                    positionX: 'center',
                    delay: 2000
                });
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        }

    });