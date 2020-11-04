app.controller('pktuserCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/pkt";
        $scope.hiposServerURL = "/services";





        $scope.getPktUserList = function () {

            $http.post("pkt/getPktuserList" ).then(function (response) {
                var data = response.data.object;
                $scope.pktuserlist= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getPktUserList();
        $scope.getApplicationList = function () {

            $http.post($scope.hiposServerURL  + "/getApplicationList" ).then(function (response) {
                var data = response.data.object;
                $scope.applicationlist= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.getApplicationList();

        $scope.editPktUser=function(data){
            $scope.id=data.id;
            $scope.username=data.userName;
            $scope.password=data.password;
            $scope.email=data.email;
            $scope.application=data.application;
            $scope.roles=data.roles;
            $('#pktuser').text("Edit PktUser");

            $("#add_new_pktuser_modal").modal('show');
        }



        $scope.addpktuser = function () {
            $scope.id ="";
            $scope.username ="";
            $scope.password ="";
            $scope.email ="";
            $scope.roles ="";
            $scope.application =null;
            $("#add_new_pktuser_modal").modal('show');

        };
        $scope.savePktUser = function () {


                var savePktUser;
                savePktUser = {
                    id: $scope.id,
                    userName: $scope.username,
                    password: $scope.password,
                    email: $scope.email,
                    application: $scope.application,
                    roles: $scope.roles

                };
                $http.post("pkt/savePktUser",angular.toJson(savePktUser)).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.getPktUserList();
                        $("#add_new_pktuser_modal").modal('hide');
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




    });