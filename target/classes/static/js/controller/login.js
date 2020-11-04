
/**
 * Created by azgar.h on 6/22/2017.
 */
app.controller('loginController',
    function($scope, $http, $location, $filter, Notification, ngTableParams,  $timeout, $window, $rootScope) {
        console.log("aaaaaaaaaaaaa");
        $("#sidebar-menu").hide();
        $scope.word = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
        $scope.registrationFormData = {};
        $scope.loginFormData = {};
        $scope.forgetPwdFormData = {};
        // $scope.currentPage = PAGE_NAME.trim();
        $scope.loginId = $scope.currentPage == "license" ? "signup" : "signin";

        $scope.changeTab = function (tab) {
            $scope.loginId = tab;
        }

        $scope.changeLanguage = function (key) {

            $translate.use(key)
        };

        function createCookie(name, value, days) {
            if (days) {
                var date = new Date();
                date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
                var expires = "; expires=" + date.toGMTString();
            } else var expires = "";
            document.cookie = name + "=" + value + expires + ";";
        }

        $(document).ready(function () {
            $(".btn-login").click(function () {
                $(".bigicon").addClass("fa-spin");
            });
        });

        $rootScope.userStatus = null;
        $scope.login = function () {
            var loginData = {
                companyEmail: $scope.loginFormData.email,
                userName: $scope.loginFormData.name,
                password: $scope.loginFormData.password
            };
            $http.post("hipos/login", JSON.stringify(loginData)).then(function success(response) {
                console.log(response.data['accessToken']);
                var returnToken = response.data['accessToken'];
                if (returnToken == 'invalid') {
                    alert('Invalid credentials');
                    return false;
                } else if (returnToken == 'session-present') {
                    alert("User already logged in other system");
                    return false;
                }
                createCookie('accessToken', response.data['accessToken'], {});
                //window.location.href = '#!/dashboard';
                window.location.reload();
            }, function error() {
            });
        };

        $scope.register = function () {
            $rootScope.showFullPageLoading = true;

            $http.get("company/getCompanyRegistration?license_key=" + $scope.registrationFormData.license_key).then(
                function success() {
                    $rootScope.showFullPageLoading = false;
                    window.location.reload();
                }, function error(response) {
                    $rootScope.showFullPageLoading = false;
                    if (response.data) {
                        Notification.error({message: response.data['message'], positionX: 'center', delay: 2000});
                    }
                }
            );
        };

        $scope.forgetPwd = function () {
            $http.post("company/forgotPassword", JSON.stringify($scope.forgetPwdFormData)).then(
                function success() {
                    window.location.reload();
                }, function error(response) {
                    if (response.data) {
                        Notification.error({message: response.data['message'], positionX: 'center', delay: 2000});
                    }
                }
            );
        }

        $(".loginBody").css("background", "url('resource/posimages/hinext_new_op_bg.jpg') center center / cover no-repeat rgb(238, 238, 238)");
        $(".hinext_new, .bg_row_info, .bg_sub_row_info, .right_col").css("background", "transparent");

        $('#logoutButton').hide();

        $scope.saveuservalidate = function () {
            var saveUserDetails;
            saveUserDetails = {
                email: $scope.userEmailText,
                userName: $scope.userNameText,
                passwordUser: $scope.pswdText,
            };
            document.cookie = "email=" + $scope.userEmailText;
            $http.post("/sass/userValidate", angular.toJson(saveUserDetails)).then(function (response) {
                var data = response.data;
                console.log('validate user');

                if (data == "") {
                    document.cookie = "email=" + "";
                    $("#sidebar-menu").hide();
                    $scope.removeuserDetails();
                    Notification.error({
                        message: 'Invalid Authentication',
                        positionX: 'center',
                        delay: 2000
                    });
                } else {
                    if (data.validityStatus == 'Expired') {
                        document.cookie = "email=" + "";
                        Notification.error({
                            message: 'Your Subscription is Expired',
                            positionX: 'center',
                            delay: 2000
                        })
                        // window.location.reload();
                    } else {
                        $rootScope.userName = data.full_name;
                        $rootScope.email = data.email;
                        $rootScope.id = data.useraccount_id;
                        $rootScope.password = data.passwordUser;
                        $rootScope.userStatus = data.userStatus;
                        $rootScope.developerId = data.developerId;
                        $rootScope.customerId = data.customer;
                        $rootScope.getAllPermission();
                        $rootScope.getLoggedInByUser();
                        if ($rootScope.userStatus == "user") {
                            $window.location.href = '/home#!/controlPanel';
                        } else if ($rootScope.userStatus == "Application") {
                            $window.location.href = '/home#!/developer';
                        } else {
                            $window.location.href = '/home#!/dashboard';
                        }
                        $("#sidebar-menu").show();
                        $scope.removeuserDetails();
                        $('#logoutButton').show();
                        // window.location.reload();
                        Notification.success({
                            message: 'Sucess',
                            positionX: 'center',
                            delay: 2000
                        });
                    }

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
            $scope.useraccount_id="";
            $scope.user_loginId="";
            $scope.userText="";
            $scope.AddressText="";
            $scope.FullNameText="";
            $scope.SecurityQuestionText="";
            $scope.AnswerText="";
            $scope.TelephoneNumberText="";
            $scope.EmailAddressText="";
            $scope.PasswordText="";
            $("#title").text("Add");
            $("#add_user_modal").modal('show');
        };


        $scope.removeuserDetails = function () {
            $scope.userEmailText = "";
            $scope.userNameText = "";
            $scope.pswdText = "";
            $scope.userText="";
            $scope.AddressText="";
            $scope.FullNameText="";
            $scope.SecurityQuestionText="";
            $scope.AnswerText="";
            $scope.TelephoneNumberText="";
            $scope.EmailAddressText="";
            $scope.PasswordText="";
        }
        $scope.isDisabled=true;
        $scope.saveuserDetails = function () {
            if ($scope.userText === '') {
                Notification.warning({message: 'User Name can not be empty', positionX: 'center', delay: 2000});
            }
            else if ($scope.PasswordText === '') {
                Notification.warning({message: 'password cannot be empty', positionX: 'center', delay: 2000});
            }
            else if ($scope.EmailAddressText === '') {
                Notification.warning({message: 'EmailId cannot be empty', positionX: 'center', delay: 2000});
            }
            else {
                var saveUserDetails;
                saveUserDetails = {
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

    });
