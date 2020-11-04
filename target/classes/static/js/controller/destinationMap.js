app.controller('destinationMapCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";


        $scope.removedestMap = function () {
            $scope.sourceName="";
            $scope.destination="";
            $scope.sourcetype="";
            $scope.id="";
        };

        $scope.getdestinationList = function (sourceType) {
            $http.post($scope.hiposServerURL  + "/detinationtypeList" + sourceType).then(function (response) {
                var data = response.data.object;
                $scope.descriptiontype= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getdestinationList();
        $scope.popUp = function(){
            $("#destinationType").modal('show');
        }
        $scope.closePopup = function(){
            $("#destinationType").modal('hide');
        }
        $scope.editdestMap = function (data) {
            $scope.id=data.id
            $scope.sourceName=data.sourceName;
            $scope.sourcetype=data.sourceType;
            $scope.status=data.status;
            $scope.addData=function (status,name) {
                $scope.selectedList[name]=status;
            }
            $scope.operation = 'Edit';
            $('#title').text("Edit DestinationMap");
            $("#add_new_dest_map_modal").modal('show');
        }

        $scope.adddestinationmap = function () {
            $scope.status="Active";
            $scope.removedestMap();
            $('#title').text("Add DestinationMap");
            $("#add_new_dest_map_modal").modal('show');

        };
        $scope.getdestinationMapList = function () {
            $http.post($scope.hiposServerURL  + "/detinationtypeMapList").then(function (response) {
                var data = response.data.object;
                $scope.descriptionmap= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };

        $scope.getdestinationMapList();
        $scope.selectedList={};
        $scope.addData=function (status,name) {
            $scope.selectedList[name]=status;
        }

        $scope.savedestMap = function () {
            angular.forEach($scope.descriptiontype,function(value,key){
                $scope.selectedList[value.destinationName]=value.status;
            })
            if ($scope.sourceName === '') {
                Notification.warning({message: 'Destination Name can not be empty', positionX: 'center', delay: 2000});
            }
            else {
                var savedestinationmap;
                savedestinationmap = {
                    id:$scope.id,
                    sourceName:$scope.sourceName,
                    destinationmap:angular.toJson($scope.selectedList),
                    sourceType:$scope.sourcetype,
                    status:$scope.status

                };
                $http.post("/services/savedestinationmap", savedestinationmap).then(function (response) {
                    var data = response.data;
                    if(data==""){
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removedestMap();
                        $scope.getdestinationMapList();

                        $("#destinationType").modal('hide');
                        $("#add_new_dest_map_modal").modal('hide');
                        Notification.success({
                            message: 'destinationMap Created  successfully',
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

        };
    });