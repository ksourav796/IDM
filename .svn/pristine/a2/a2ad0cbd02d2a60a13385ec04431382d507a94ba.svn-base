app.controller('ticketsCtrl', function ($scope, $rootScope, $http, $location, $filter, Notification,$timeout) {


    $scope.SassControlPanelService = "/services";
    $scope.getSubscriptionListbasedonUser = function () {
        $http.post($scope.SassControlPanelService + '/getSubscriptionListbasedonUser?email='+$rootScope.email).then(function (response) {
            var data = response.data;
            $scope.subscriptionListUser = data;
            // window.location.reload();
            console.log(data);
        }, function (error) {
            Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
        })
    };

    $scope.getSubscriptionListbasedonUser();

    $scope.addNewTickets = function () {
        $scope.ticketid=0;
        $scope.name="";
        $scope.email="";

        $("#add_new_tickets_modal").modal('show');
    }


    $scope.addNewTickets1 = function(){
        $("#add_new_tickets1_modal").modal('show');
    }

   $scope.saveTicket = function () {
       var ticketdetails;
       ticketdetails = {
           name: $scope.name,
           email: $scope.email

       }
       $http.post($scope.SassControlPanelService + '/saveTicket', angular.toJson(ticketdetails)).then(function (response) {
           var data = response.data;
           if (data == "") {
               Notification.error({message: 'Already Exists', positionX: 'center', delay: 2000});
           } else {
               $("#add_new_tickets_modal").modal('hide');
               if ($scope.operation == 'Edit') {
                   Notification.success({message: 'Ticket is Updated Successfully', positionX: 'center', delay: 2000});
               } else {
                   Notification.success({
                       message: 'Ticket is Saved Successfully',
                       positionX: 'center',
                       delay: 2000
                   });
               }
           }
       }, function (error) {
           Notification.error({message: 'Something Went Wrong', positionX: 'center', delay: 2000});
       });

   }

});
