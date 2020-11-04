app.controller('devapplicationCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";


        $scope.removeApplication = function () {
            $scope.name="";
            $scope.status="";
        };

        $scope.getdevApplicationList = function () {

            $http.post($scope.hiposServerURL  + "/getdevApplicationList?code="+$rootScope.developerId ).then(function (response) {
                var data = response.data.object;
                $scope.actiontype= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getdevApplicationList();


        $scope.editApplication=function(data){
            $scope.id=data.id;
            $scope.name=data.name;
            $scope.status=data.status;
            $('#country-title').text("Edit Application");

            $("#add_new_Application_modal").modal('show');
        }




        $scope.addNewApplication = function () {
            $scope.status ="Active";
            $("#add_new_Application_modal").modal('show');

        };
        $scope.saveApplication = function () {

            {
                var saveApplication;
                saveApplication = {
                    id: $scope.id,
                    name: $scope.name,
                    status: $scope.status,
                    developerId:$rootScope.developerId

                };
                $http.post("/services/saveApplication", saveApplication).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removeApplication();
                        $scope.getdevApplicationList();
                        $("#add_new_Application_modal").modal('hide');
                        Notification.success({
                            message: 'Application Created  successfully',
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