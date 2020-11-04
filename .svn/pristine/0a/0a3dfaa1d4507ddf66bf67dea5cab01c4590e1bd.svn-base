app.controller('StateListController', function ($scope, $rootScope, $http, $location, $filter, Notification){

    $scope.hiposServerURL="/services";

    $scope.getremoveStateDetails=function(){
        $scope.stateNameText="";
        $scope.id="";
        $scope.countryId="";
    }
    $scope.getremoveStateDetails();

    $scope.getstateList = function () {
        $http.post($scope.hiposServerURL  + "/stateList").then(function (response) {
            var data = response.data.object;
            $scope.stateList= data;
        },function (error) {
            Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
        })
    };

    $scope.getstateList();

    $scope.editstate=function(data){
        $scope.id=data.id;
        $scope.stateNameText=data.stateName;
        $scope.StatusText=data.status;
        $scope.countryId=data.countryId;
        $scope.getCountryList();
        $('#state-title').text("Edit New State");
        $("#add_new_State_modal").modal('show');

    }

    $scope.addNewState= function () {
        $scope.StatusText="Active";
        $scope.getremoveStateDetails();
        $('#state-title').text("Add New State");
        $("#add_new_State_modal").modal('show');

    };

      $scope.getCountryList = function () {
        $http.post($scope.hiposServerURL  + "/getCountry").then(function (response) {
            var data = response.data.object;
            $scope.countryPojoList= data;
        },function (error) {
            Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
        })
    };

    $scope.getCountryList();

    $scope.saveState= function () {
        if ($scope.stateNameText === '') {
            Notification.warning({message: 'State Name can not be empty', positionX: 'center', delay: 2000});
        }else {
            var saveStateDetails;
            saveStateDetails = {
                id:$scope.id,
                status:$scope.StatusText,
                stateName:$scope.stateNameText,
                countryId:$scope.countryId

            };
            $http.post("/services/saveStateDetails",angular.toJson(saveStateDetails) ).then(function (response)  {
                var data = response.data;
                if(data==""){
                    Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else {
                    $scope.getremoveStateDetails();
                    $scope.getstateList();
                    $("#add_new_State_modal").modal('hide');
                    if (!angular.isUndefined(data) && data !== null) {
                        $scope.stateNameText = "";
                    }
                    Notification.success({
                        message: 'State  Created  successfully',
                        positionX: 'center',
                        delay: 2000
                    });
                }
            },function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            });

        };
    };
});