app.controller('operatorCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/pkt";


        $scope.removeOperator = function () {
            $scope.name="";
            $scope.description="";
            $scope.status="";
            $scope.id="";
        };

        // $scope.getOperatorList = function () {
        //
        //     $http.post($scope.hiposServerURL  + "/getOperatorList" ).then(function (response) {
        //         var data = response.data.object;
        //         $scope.operatortype= data;
        //     },function (error) {
        //         Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
        //     })
        // };
        // $scope.getOperatorList();



        $scope.editOperator=function(data){
            $scope.id=data.id;
            $scope.name=data.name;
            $scope.description=data.description;
            $scope.status=data.status;
            $('#cust-notif').text("Edit");
            $("#add_new_Operator_modal").modal('show');
        }

        $scope.addNewOperator = function () {
            $scope.status ="Active";
            $scope.name="";
            $scope.description="";
            $scope.id=null;
            $("#add_new_Operator_modal").modal('show');

        };

        $scope.getPaginatedOperatorLists = function (page) {
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
                    $scope.isNext = false;
                    $scope.isPrev = false;
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
                    $scope.isNext = false;
                    $scope.isPrev = false;
                    $scope.pageNo = 0;
            }
            var paginationDetails;
            paginationDetails = {
                firstPage: $scope.firstPage,
                lastPage: $scope.lastPage,
                pageNo: $scope.pageNo,
                prevPage: $scope.prevPage,
                prevPage: $scope.isPrev,
                nextPage: $scope.isNext
            }
            if (angular.isUndefined($scope.searchText)) {
                $scope.searchText = "";
            }
            $http.post($scope.hiposServerURL + '/getPaginatedOperatorLists?&searchText=' + $scope.searchText, angular.toJson(paginationDetails)).then(function (response) {
                var data = response.data;
                $scope.operatortype = data.list;
                $scope.first = data.firstPage;
                $scope.last = data.lastPage;
                $scope.prev = data.prevPage;
                $scope.next = data.nextPage;
                $scope.pageNo = data.pageNo;
                $scope.listStatus = true;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })
        };
        $scope.getPaginatedOperatorLists();


        $scope.saveOperator = function () {
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
                var saveOperator;
                saveOperator = {
                    id: $scope.id,
                    name: $scope.name,
                    description: $scope.description,
                    status: $scope.status

                };
                $http.post("/pkt/saveOperators", saveOperator).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removeOperator();
                        $scope.getPaginatedOperatorLists();
                        $("#add_new_Operator_modal").modal('hide');
                        Notification.success({
                            message: 'Operator Created  successfully',
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