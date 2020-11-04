app.controller('userCtrl',
    function ($scope, $rootScope, $http, $location, $filter,$timeout, Notification) {
        $scope.word = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
        $scope.customerId = 1;
        $scope.userRights = [];
        $scope.operation = 'Create';
        $scope.customer = 1;

        $scope.removeuserDetails = function () {
            $scope.user_loginId = "";
            $scope.AddressText = "";
            $scope.FullNameText = "";
            $scope.SecurityQuestionText = "";
            $scope.AnswerText = "";
            $scope.TelephoneNumberText = "";
            $scope.EmailAddressText = "";
            $scope.PasswordText = "";
            $scope.id = "";
        }

        $scope.saveuserDetails = function () {
            if ($scope.userText === '') {
                Notification.warning({message: 'User Name can not be empty', positionX: 'center', delay: 2000});
            } else if ($scope.PasswordText === '') {
                Notification.warning({message: 'password cannot be empty', positionX: 'center', delay: 2000});
            } else if ($scope.EmailAddressText === '') {
                Notification.warning({message: 'EmailId cannot be empty', positionX: 'center', delay: 2000});
            } else if (angular.isUndefined($scope.FullNameText) || $scope.FullNameText == '') {
                Notification.warning({message: 'FullName can not be Empty', positionX: 'center', delay: 2000});
            } else if (angular.isUndefined($scope.SecurityQuestionText) || $scope.SecurityQuestionText == '') {
                Notification.warning({message: 'SecurityQuestion can not be Empty', positionX: 'center', delay: 2000});
            } else if (angular.isUndefined($scope.AnswerText) || $scope.AnswerText == '') {
                Notification.warning({message: 'Answer can not be Empty', positionX: 'center', delay: 2000});
            } else if (angular.isUndefined($scope.TelephoneNumberText) || $scope.TelephoneNumberText == '') {
                Notification.warning({message: 'TelephoneNumber can not be Empty', positionX: 'center', delay: 2000});
            } else if (angular.isUndefined($scope.EmailAddressText) || $scope.EmailAddressText == '') {
                Notification.warning({message: 'EmailAddress can not be Empty', positionX: 'center', delay: 2000});
            } else {
                var saveUserDetails;
                saveUserDetails = {
                    useraccount_id: $scope.id,
                    userName: $scope.userText,
                    passwordUser: $scope.PasswordText,
                    currentPassword: $scope.currentPassword,
                    full_name: $scope.FullNameText,
                    securityQuestion: $scope.SecurityQuestionText,
                    securityAnswer: $scope.AnswerText,
                    phone: $scope.TelephoneNumberText,
                    email: $scope.EmailAddressText,
                    status: $scope.status
                };
                $http.post("/sass/saveLoginDetails", angular.toJson(saveUserDetails)).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        Notification.error({message: 'Email Already exists', positionX: 'center', delay: 2000});
                    } else {
                        $("#add_user_modal").modal('hide');
                        Notification.success({message: 'User Created  successfully', positionX: 'center', delay: 2000});
                        $scope.removeuserDetails();
                        $scope.getUserList();
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


        $scope.getUserList = function () {
            $(".loader").css("display", "block");
            $http.post("/sass/getUserDetailsList").then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.userList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };

        $scope.getUserList();

        $scope.editUserAccountSetupWithPermissions = function (id) {
            $scope.userId=id;
            $http.post("/sass/editUserAccountSetUpWithPermission?id=" + id).then(function (response) {
                var data = response.data;
                $scope.permission = data;
                $("#add_permissions_modal_1check").modal('show');
            })

        }
        $scope.permission = null;
        $scope.savePermission = function () {
            $scope.permission.userId=$scope.userId;
            $http.post("/sass/savepermission", angular.toJson($scope.permission)).then(function (response) {
                var data = response.data;
                if (data == "") {
                    Notification.error({message: 'Email Already exists', positionX: 'center', delay: 2000});
                } else {
                    $("#add_permissions_modal_1check").modal('hide');
                    Notification.success({message: 'User Created  successfully', positionX: 'center', delay: 2000});
                    $scope.removeuserDetails();
                    $rootScope.getAllPermission();
                    $rootScope.getLoggedInByUser();
                    $scope.getUserList();
                }
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            });
        }

        $scope.addUserDetails = function () {
            $scope.userText = "";
            $scope.useraccount_id = "";
            $scope.id = "";
            $scope.user_loginId = "";
            $scope.AddressText = "";
            $scope.FullNameText = "";
            $scope.SecurityQuestionText = "";
            $scope.AnswerText = "";
            $scope.TelephoneNumberText = "";
            $scope.EmailAddressText = "";
            $scope.PasswordText = "";
            $("#title").text("Add");
            $("#add_user_modal").modal('show');
        };

        $scope.edituser = function (data) {
            $scope.id = data.useraccount_id;
            $scope.userText = data.userName;
            $scope.PasswordText = data.passwordUser;

            $("#useredit-title").text("Edit");
            $("#edit_user_modal").modal('show');
        }
        $scope.saveEditDetails = function () {
            if ($scope.userText === '') {
                Notification.warning({message: 'User Name can not be empty', positionX: 'center', delay: 2000});
            } else if ($scope.PasswordText === '') {
                Notification.warning({message: 'password cannot be empty', positionX: 'center', delay: 2000});
            } else {
                var saveUserDetails;
                saveUserDetails = {
                    useraccount_id: $scope.id,
                    userName: $scope.userText,
                    passwordUser: $scope.PasswordText

                };
                $http.post("/sass/saveeditDetails", angular.toJson(saveUserDetails)).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        Notification.error({message: 'Email Already exists', positionX: 'center', delay: 2000});
                    } else {
                        $("#edit_user_modal").modal('hide');
                        Notification.success({message: 'User Created  successfully', positionX: 'center', delay: 2000});
                        $scope.removeuserDetails();
                        $scope.getUserList();
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

        $scope.changePassword=function (data) {
            $scope.id = data.useraccount_id;
            $scope.userText = data.userName;
            $scope.EmailAddressText=data.email;
            $scope.oldPassword = data.passwordUser;
            $scope.password="";
            $("#useredit-title").text("Change Password");
            $("#change_user_modal").modal('show');
        }

        $scope.savepassword=function () {
            var details;
            details={
                useraccount_id: $scope.id,
                userName: $scope.userText,
                passwordUser: $scope.newpassword
            };
            $http.post("/sass/saveeditDetails",angular.toJson(details)).then(function (response) {
                var data = response.data;
                if (data == "") {
                    Notification.error({message: 'Email Already exists', positionX: 'center', delay: 2000});
                } else {
                    $("#change_user_modal").modal('hide');
                    Notification.success({message: 'Password Updated successfully', positionX: 'center', delay: 2000});
                    $scope.removeuserDetails();
                    $scope.getUserList();
                }
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            });
        }
        $scope.passwordMatch=function () {
            if($scope.password!=$scope.oldPassword){
                Notification.error({message:'Password Not Matched',positionX: 'center', delay: 2000})
                $scope.newpassword=null;
            }
        }
        $scope.correctPassword=function () {
            if($scope.newpassword!=$scope.retypepassword){
                Notification.error({message:'NewPassword And RetypePassword Should Match',positionX: 'center', delay: 2000})
                // $scope.retypepassword=null;
            }
        }

    });
