app.controller('rtrSyncSettingsCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";
        // $scope.today = new Date();
        $scope.today = function() {
            $scope.createdAtText = new Date();
            $scope.updatedAtText = new Date();
        };
        $scope.today();
        $scope.format = 'dd/MM/yyyy';

        $scope.open1 = function() {
            $scope.popup1.opened = true;
        };

        $scope.popup1 = {
            opened: false
        };

        $scope.open2 = function() {
            $scope.popup2.opened = true;
        };


        $scope.popup2 = {
            opened: false
        };


        $scope.removertrdetails=function(){
            $scope.rtrSyncID="";
            $scope.companyKeyWordText="";
            $scope.rtrSyncTypeText="";
            $scope.rtrSyncOptionText="";
            $scope.rtrSyncSchedulePeriodText="";
        };
        $scope.removertrdetails();

        $scope.addNewrtrSyncSettings = function () {
            $scope.rtrSyncStatusText="Active";
            $scope.removertrdetails();
             $("#rtr-title").text("Add RTRSyncSettings");
            $("#rtr_sync_Settings").modal('show');
        };

        $scope.editrtrSync=function(data){
            $scope.rtrSyncID=data.rtrSyncID;
            $scope.companyKeyWordText=data.companyKeyWord;
            $scope.rtrSyncTypeText=data.rtrSyncType;
            $scope.rtrSyncOptionText=data.rtrSyncOption;
            $scope.rtrSyncSchedulePeriodText=data.rtrSyncSchedulePeriod;
            $scope.createdAtText=new Date(data.createdAt);
            $scope.updatedAtText=new Date(data.updatedAt);
            $scope.rtrSyncStatusText=data.rtrSyncStatus;
            $("#rtr-title").text("Edit RTRSyncSettings");
            $("#rtr_sync_Settings").modal('show');

        };

        $scope.getrtrsyncSettingsList = function (val) {
            if (angular.isUndefined(val)) {
                val = "";
            }
            $http.post($scope.hiposServerURL  + "/getRTRSyncList?SearchText=" + val).then(function (response) {
                var data = response.data.object;
                $scope.rtrsyncSettingsList= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };

        $scope.getrtrsyncSettingsList();

        $scope.saveRTRSyncSettings= function () {
            if ($scope.companyKeyWordText === '') {
                Notification.warning({message: 'State Name can not be empty', positionX: 'center', delay: 2000});
            }
            else if(angular.isUndefined($scope.companyKeyWordText) || $scope.companyKeyWordText == '') {
                Notification.warning({message: 'companyKeyWord can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.rtrSyncTypeText) || $scope.rtrSyncTypeText == '') {
                Notification.warning({message: 'rtrSyncType can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.rtrSyncOptionText) || $scope.rtrSyncOptionText == '') {
                Notification.warning({message: 'rtrSyncOption can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.rtrSyncSchedulePeriodText) || $scope.rtrSyncSchedulePeriodText == '') {
                Notification.warning({message: 'rtrSyncSchedulePeriod can not be Empty', positionX: 'center', delay: 2000});}

            else {
                var saveRTRSyncDetails;
                saveRTRSyncDetails = {
                    rtrSyncID:$scope.rtrSyncID,
                    companyKeyWord:$scope.companyKeyWordText,
                    rtrSyncType:$scope.rtrSyncTypeText,
                    rtrSyncOption:$scope.rtrSyncOptionText,
                    rtrSyncSchedulePeriod:$scope.rtrSyncSchedulePeriodText,
                    createdAt:$scope.createdAtText,
                     updatedAt:$scope.updatedAtText,
                    rtrSyncStatus:$scope.rtrSyncStatusText

                };
                $http.post("/services/saveRTRSyncDetails",angular.toJson(saveRTRSyncDetails) ).then(function (response)  {
                    var data = response.data;
                    if(data==""){
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {

                        $scope.getrtrsyncSettingsList();
                        $scope.removertrdetails();
                        $("#rtr_sync_Settings").modal('hide');
                        // if (!angular.isUndefined(data) && data !== null) {
                        //     $scope.stateNameText = "";
                        // }
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