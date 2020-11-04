
app.controller('countryListController', function ($scope, $rootScope, $http, $location, $filter, Notification) {


    $scope.SassControlPanelService="/services";
    $scope.CountryNameText = "";
    $scope.StatusText = "";
    $scope.operation = 'Create';
    //added for pagination purpose @rahul
    $scope.firstPage=true;
    $scope.lastPage=false;
    $scope.pageNo=1;
    $scope.prevPage=false;
    $scope.isPrev=false;
    $scope.isNext=false;
    $scope.customer=1;
    $scope.inactiveStatus="Active";
    $scope.removeCountryDetails = function () {
        $scope.CountryNameText = "";
        $scope.StatusText ="";
        $scope.operation = "";
    };
    $scope.getCountryList = function () {
        $http.post($scope.SassControlPanelService  + "/getCountry").then(function (response) {
            var data = response.data.object;
            $scope.countryList= data;
        },function (error) {
            Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
        })
    };

    $scope.getCountryList();

    $scope.editcountry=function(data){
        $scope.countryId=data.countryId;
        $scope.CountryNameText=data.countryName;
        $scope.StatusText=data.status;
        $('#country-title').text("Edit Country");

        $("#add_new_country_modal").modal('show');
    }

    $scope.addNewcountryPopulate = function () {
        $(".loader").css("display", "block");
        // $http.get($scope.SassControlPanelService + "/" + $scope.country + '/addCountry').then(function (response) {
        //     var data = response.data;
        //     $scope.countryDTOList = angular.copy(data);
            $scope.countryId="";
            $scope.CountryNameText="";
            $('#country-title').text("Add Country");
            $scope.StatusText="Active";
            $("#add_new_country_modal").modal('show');
            // $scope.searchText = $scope.itemSearchText;
        },function (error) {
            Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
        // })
    };

    $scope.saveCountry = function () {
        if ($scope.CountryNameText === '') {
            Notification.warning({message: 'Country Name can not be empty', positionX: 'center', delay: 2000});
        }
        else {
            var saveCountryDetails;
            saveCountryDetails = {
                countryId:$scope.countryId,
                countryName:$scope.CountryNameText,
                status:$scope.StatusText

            };
            $http.post("/services/saveCountry?saveCountryDetails=", saveCountryDetails).then(function (response) {
                var data = response.data;
                if(data==""){
                    Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else {
                    $scope.removeCountryDetails();
                    $scope.getCountryList();
                    $("#add_new_country_modal").modal('hide');
                    if (!angular.isUndefined(data) && data !== null) {
                        $scope.countrySearchText = "";
                    }
                    Notification.success({
                        message: 'Country Created  successfully',
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

});