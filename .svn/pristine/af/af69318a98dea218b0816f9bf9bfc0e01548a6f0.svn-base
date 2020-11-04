app.controller('emailCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";

        $scope.addemail=function () {

            $('#title').text("Add Emaildetails");
            $("#add_new_email_modal").modal('show');

        };

$scope.removeemail=function(){
    $scope.emaillistenerId="";
    $scope.url="";
    $scope.userName="";
    $scope.emailId="";
    $scope.password="";
    $scope.smtp="";
    $scope.pop3="";
    $scope.imap="";
    $scope.host="";
    $scope.Folder="";
    $scope.Fromemail="";
    $scope.visibility="";
    $scope.subject="";
    $scope.Name="";
    $scope.port="";
};
$scope.editemail=function(data){
    $scope.emaillistenerId=data.emaillistenerId;
    $scope.url=data.url;
    $scope.userName=data.username;
    $scope.emailId=data.emailId;
    $scope.password=data.password;
    $scope.smtp=data.smtp;
    $scope.pop3=data.pop3;
    $scope.imap=data.imap;
    $scope.host=data.host;
    $scope.Folder=data.folderRead;
    $scope.Fromemail=data.fromEmail;
    $scope.visibility=data.visibility;
    $scope.subject=data.subject;
    $scope.Name=data.name;
    $scope.Port=data.port;
    $('#cust-notif').text("Edit Emaildetails");
    $("#add_new_email_modal").modal('show');
}

 $scope.getemailList=function () {
    $http.post($scope.hiposServerURL  + "/getemailList").then(function (response) {
        var data = response.data.object;
        $scope.emailList= data;
    },function (error) {
        Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
    })

};
        $scope.getemailList();


 $scope.saveemail=function () {
    var emaildetails;
    emaildetails={
        emaillistenerId:$scope.emaillistenerId,
     url:$scope.url,
     username:$scope.userName,
     emailId:$scope.emailId,
     password:$scope.password,
     smtp: $scope.smtp,
     pop3: $scope.pop3,
     imap: $scope.imap,
     host:$scope.host,
     folderRead: $scope.Folder,
     fromEmail: $scope.Fromemail,
     subject:$scope.subject,
     visibility: $scope.visibility,
     name:$scope.Name,
        port:$scope.port
    };

     $http.post("/services/saveemaildetails",angular.toJson(emaildetails)).then(function (response) {
        var data = response.data;
        if(data==""){
            Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
        }
        else {
            $scope.removeemail();
            $scope.getemailList();

            $("#add_new_email_modal").modal('hide');
            Notification.success({
                message: 'emaildetails Created  successfully',
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




    });