app.controller('destinationTypeCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";


        $scope.removedestType = function () {
            $scope.id="";
            $scope.destName="";
            $scope.docType="";
            $scope.description="";


        };

        $scope.getdestinationList = function () {

            $http.post($scope.hiposServerURL  + "/detinationtypeList" ).then(function (response) {
                var data = response.data.object;
                $scope.descriptiontype= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getdestinationList();



        $scope.editdestinationtype=function(data){
            $scope.id=data.id;
            $scope.destName=data.destinationName;
                $scope.docType=data.docType;
                $scope.description=data.description;
                $scope.status=data.status;
            $('#cust-notif').text("Edit");
            $("#add_new_dest_type_modal").modal('show');
        }

        $scope.adddestination = function () {
            $("#add_new_dest_type_modal").modal('show');

        };
        $scope.savedestType = function () {
            if ($scope.destName === '') {
                Notification.warning({message: 'Destination Name can not be empty', positionX: 'center', delay: 2000});
            }
            else {
                var savedestination;
                savedestination = {
                    id:$scope.id,
                    destinationName:$scope.destName,
                    docType:$scope.docType,
                    description:$scope.description,
                    status:$scope.status

                };
                $http.post("/services/savedestination", savedestination).then(function (response) {
                    var data = response.data;
                    if(data==""){
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removedestType();
                        $scope.getdestinationList();
                        $("#add_new_dest_type_modal").modal('hide');
                        Notification.success({
                            message: 'destination Created  successfully',
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