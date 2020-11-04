/**
 * Created by azgar.h on 7/1/2017.
 */
app.controller('versionCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {

        $scope.hiposServerURL = "/services";

        $scope.removeProjectDetails = function () {

            $scope.ProjectTitleText = "0";
            $scope.ExchangeRateText = "0";
            $scope.itemStatusText="";

        };
$scope.editversion=function(data){
    $scope.projectId=data.id;
    $scope.ProjectTitleText=data.projectname;
    $scope.ExchangeRateText=data.description;
    $scope.itemStatusText=data.status;
    $('#project-title').text("Edit Project");
    $("#add_new_Project_modal").modal('show');
}

        $scope.addNewProject = function () {
                $scope.projectId="";
                $scope.ProjectTitleText="";
                $scope.ExchangeRateText="";
                $scope.itemStatusText="Active";
                $('#project-title').text("Add Project");
                $("#add_new_Project_modal").modal('show');
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});


        };
        $scope.getVersionControlList = function () {
            $(".loader").css("display", "block");
            $http.post($scope.hiposServerURL  + "/getVersionControlList").then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.projectList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };

        $scope.getVersionControlList();

        $scope.saveOrUpdateProject = function () {
            if ($scope.ProjectTitleText === '') {
                Notification.warning({message: 'Project Name can not be empty', positionX: 'center', delay: 2000});
            }
            else if(angular.isUndefined($scope.ProjectTitleText) || $scope.ProjectTitleText == '') {
                Notification.warning({message: 'ProjectTitle can not be Empty', positionX: 'center', delay: 2000});}
            else if(angular.isUndefined($scope.ExchangeRateText) || $scope.ExchangeRateText == '') {
                Notification.warning({message: 'ProjectDescription can not be Empty', positionX: 'center', delay: 2000});}
            else {
                var saveProjectDetails;
                saveProjectDetails = {
                    id:$scope.projectId,
                    projectname: $scope.ProjectTitleText,
                    description: $scope.ExchangeRateText,
                    status: $scope.itemStatusText
                };
            }
                $http.post("/services/saveVersionControl" , angular.toJson(saveProjectDetails)).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.removeProjectDetails();
                        $scope.getVersionControlList();
                        $("#add_new_Project_modal").modal('hide');

                        Notification.success({
                            message: 'Project Created  successfully',
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

    });