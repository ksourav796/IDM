app.controller('headerCtrl',
    function($rootScope, $scope, $window,$timeout,$http,Notification,$interval) {
        $scope.status=null;
        $rootScope.getLoggedInByUser = function () {
           if($scope.status!="Already Expired") {
               $http.post('/sass/getLoggedInByUser').then(function (response) {
                   var data = response.data;
                   $scope.logged = data;
                   console.log(data);
                   $rootScope.userName = data.full_name;
                   $rootScope.email = data.email;
                   $rootScope.userStatus = data.userStatus;
                   $rootScope.developerId = data.developerId;
                   $rootScope.password = data.passwordUser;
                   $rootScope.customerId = data.customer;
                   $rootScope.getSubscriptionListByDeveloperId();
                   if (data.validityStatus == 'Expired') {
                       bootbox.confirm({
                           title: "Alert",
                           message: "Your Subscription is Expired " +"\n"+
                           "and You can Renew now ?",
                           buttons: {
                               confirm: {
                                   label: 'OK'
                               }
                           },
                           callback: function (result) {
                               if (result == true) {
                                   Notification.error({
                                       message: 'Your Subscription is Expired',
                                       positionX: 'center',
                                       delay: 2000
                                   })
                                   $scope.status = "Already Expired";
                                   // $rootScope.logout();
                                   $window.location.href = '/home#!/invoice';
                               }
                           }
                       });
                   }
               });
           }

        };

        $rootScope.logout = function(){
            document.cookie = "email=" + "";
            $rootScope.userName = "";
            $window.location.href = '/home#!/login';
        }

        $rootScope.getAllPermission = function () {
            $http.post('/sass/getAllPermission').then(function (response) {
                var data = response.data;
                console.log(data);
                $rootScope.userPermission = data;
            });
        };
        $rootScope.getAllPermission();
        $rootScope.getLoggedInByUser();

        $rootScope.subscription =[];
        // $rootScope.InActiveList =[];
        // $rootScope.ActiveList =[];
        $rootScope.getSubscriptionListByDeveloperId = function () {
            $(".loader").css("display", "block");
            $http.post('/services'  + "/getSubscriptionListByDeveloperId?code="+$rootScope.developerId).then(function (response) {
                var data = response.data.object;
                console.log(data);
                $rootScope.subscription = data;
                $rootScope.InActiveList =[];
                $rootScope.ActiveList =[];
                angular.forEach( $rootScope.subscription,function (val,key) {
                    if(val.status=="Active"){
                        $rootScope.ActiveList.push(val);
                    }else {
                        $rootScope.InActiveList.push(val);
                    }
                })

            })

        };
        $rootScope.getSubscriptionListByDeveloperId();

        $interval(function () {
            $rootScope.getLoggedInByUser();
        }, 10000);

    });