/**
 * Created by azgar.h on 7/1/2017.
 */
app.controller('currencyCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";
        $scope.customerId = 1;
        $scope.userRights = [];
        $scope.operation = 'Create';
        $scope.customer = 1;
        $scope.today = new Date();

        $scope.removeCurrencyDetails = function () {
            $scope.CurrencyWordText="";
            $scope.currencyId="";
            $scope.CurrencyCodeText="";
            $scope.CurrencysymbolText="";
            $scope.currencyDescription="";
            $scope.CurrencysymbolplaceText="";
            $scope.AccountCodeText="";
            $scope.SelectedCountryObj="";
            $scope.operation = 'Create';
        };

        $scope.getCurrencyList = function () {
            $(".loader").css("display", "block");
            $http.post($scope.hiposServerURL  + "/getPaginatedCurrencyList").then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.currencyList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };

$scope.getCurrencyList();
        $http.post("/services/getCurrencyPrerequisite").then(function (response) {
            var data = response.data.object;
            $scope.countryPojoList=data.sassCountryPojoList;
            console.log(data.sassCountryPojoList);
        },function (error) {
            Notification.error({
                message: 'Something went wrong, please try again',
                positionX: 'center',
                delay: 2000
            });
        });
$scope.editcurrency=function(data){

    $scope.currencyId =data.currencyId;
    $scope.CurrencyWordText = data.currencyName;
    $scope.CurrencyCodeText = data.currencyCode;
    $scope.CurrencysymbolText = data.currencySymbol;
    $scope.CurrencyDescriptionText = data.currencyDescription;
    $scope.StatusText=data.status;
    $scope.SelectedCountryObj=data.country;
    $('#title').text("Edit currency");
    $("#add_new_Currency_modal").modal('show');

}


        $scope.addNewCurrency = function () {
            $scope.currencyId = "";
            $scope.CurrencyWordText = "";
            $scope.CurrencyCodeText = "";
            $scope.CurrencysymbolText = "";
            $scope.CurrencyDescriptionText = "";
            $scope.CurrencysymbolplaceText = "";
            $scope.AccountCodeText = "";
            $scope.StatusText="Active";
            $scope.removeCurrencyDetails();


            $("#title").text("Add Currency");
            $("#add_new_Currency_modal").modal('show');
        };



        $scope.populateCurrencyData = function () {
            var data = {
                CurrencyCode: $scope.CurrencyCode,
                CurrencyWord: $scope.CurrencyWord,
                AccountCode: $scope.AccountCode,
                CurrencyDescription: $scope.CurrencyDescription,
                Currencysymbol: $scope.Currencysymbol
            };

            console.log(data);
            return data;
        };
        $scope.saveNewCurrency = function () {
            if (angular.isUndefined($scope.CurrencyCodeText) || $scope.CurrencyCodeText == '') {
                Notification.warning({message: 'Currency code can not be Empty', positionX: 'center', delay: 2000});
            }
            else if (angular.isUndefined($scope.CurrencyWordText) || $scope.CurrencyWordText =='' ) {
                Notification.warning({message: 'Currency Word  can not be Empty', positionX: 'center', delay: 2000});
            }
            else if (angular.isUndefined($scope.CurrencyDescriptionText) || $scope.CurrencyDescriptionText =='' ) {
                Notification.warning({message: 'CurrencyDiscription  can not be Empty', positionX: 'center', delay: 2000});
            }
            else if (angular.isUndefined($scope.CurrencysymbolText) || $scope.CurrencysymbolText =='' ) {
                Notification.warning({message: 'Currency symbol Text can not be Empty', positionX: 'center', delay: 2000});
            }
            else{
            var saveCurrencyDetails;
            saveCurrencyDetails = {
                currencyId:$scope.currencyId,
                currencyName: $scope.CurrencyWordText,
                currencyCode: $scope.CurrencyCodeText,
                currencySymbol: $scope.CurrencysymbolText,
                currencyDescription:$scope.CurrencyDescriptionText,
                sassCountryPojoId:$scope.SelectedCountryObj,
                status:$scope.StatusText
            };
                $http.post("/services/saveNewCurrency",angular.toJson(saveCurrencyDetails)).then(function (response) {
                    var data = response.data;
                    if(data==""){
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $("#add_new_Currency_modal").modal('hide');
                        Notification.success({message: 'Currency Created  successfully', positionX: 'center', delay: 2000});
                        $scope.removeCurrencyDetails();
                        $scope.getCurrencyList();
                    }
                },function (error) {
                    Notification.error({
                        message: 'Something went wrong, please try again',
                        positionX: 'center',
                        delay: 2000
                    });
                });
            }

        };

    });
