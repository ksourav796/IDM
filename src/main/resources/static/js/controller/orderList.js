
/**
 * Created by azgar.h on 6/22/2017.
 */
app.controller('orderListController',
    function($scope, $http, $location, $rootScope,$filter, Notification, ngTableParams,  $timeout, $window, $cookies){
        $scope.hiposServerURL = "/services";
        $scope.word = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
        $scope.dateOptions = {
            minDate : new Date()
        };

        $scope.getPageLoadData = function () {
            $http.post($scope.hiposServerURL + '/getRegistration?license_key=' + "hhhh").then(function (response) {
                var data = response.data;
            },function (error) {
                // Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };
        $scope.firstPage = true;
        $scope.lastPage = false;
        $scope.isNext = false;
        $scope.isPrev = false;
        $scope.today = new Date();
        $scope.today = function() {
            $scope.incorpdate = new Date();
            $scope.gstregstereddate = new Date();
            $scope.transactionDate=new Date();
            };
        $scope.today();
        $scope.format = 'dd/MM/yyyy';

        $scope.open1 = function() {
            $scope.popup1.opened = true;
        };
        $scope.open2 = function() {
            $scope.popup2.opened = true;
        };
        $scope.open11 = function() {
            $scope.popup11.opened = true;
        };

        $scope.popup1 = {
            opened: false
        };
        $scope.popup2 = {
            opened: false
        };
        $scope.popup11 = {
            opened: false
        };
        $scope.getPageLoadData();

        $scope.removeOrderListDetails = function () {
            $scope.SassOrdersId = "0";
            $scope.addressText="0";
            $scope.cmpnynameText="0";
            $scope.deliveryTypeText="0";
            $scope.emailText="";
            $scope.nameText="";
            $scope.newsLetterText="";
            $scope.pkgsassidText="";
            $scope.phoneNoText="";
            $scope.subidText="";
            $scope.userText="";
            $scope.pwdText="";
            $scope.subscriptionNameId="";
            $scope.companyno="";
            $scope.Pan="";
            $scope.incorpdate="";
            $scope.faxno="";
            $scope.language="";
            $scope.website="";
            $scope.countryId="";
            $scope.currencyId="";
            $scope.stateId="";
            $scope.gstregstered="";
        };

        $scope.addOrderListPopulate = function () {
            $scope.SassOrdersId = "";
            $scope.addressText = "";
            $scope.cmpnynameText = "";
            $scope.deliveryTypeText = "";
            $scope.emailText="";
            $scope.nameText="";
            $scope.newsLetterText = "";
            $scope.phoneNoText="";
            $scope.pkgsassidText="";
            $scope.subidText="";
            $scope.pwdText="";
            $scope.userText="";
            $('#order-title').text("Add Order List");
            $("#add_new_orderlist_modal").modal('show');

        };
        // $scope.getOrderList = function () {
        //     $(".loader").css("display", "block");
        //     $http.post($scope.hiposServerURL  + "/getOrderList").then(function (response) {
        //         var data = response.data.object;
        //         console.log(data);
        //         $scope.orderList = data;
        //
        //     }, function (error) {
        //         Notification.error({
        //             message: 'Something went wrong, please try again',
        //             positionX: 'center',
        //             delay: 2000
        //         });
        //     })
        //
        // };


        // $scope.getOrderList();

        $scope.getCountryList = function () {
            $http.post($scope.hiposServerURL  + "/getCountry").then(function (response) {
                var data = response.data.object;
                $scope.countryPojoList= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };

        $scope.getCountryList();


        $scope.getPaymentMethodList = function () {
            $(".loader").css("display", "block");
            $http.post($scope.hiposServerURL  + "/getPayMethodList").then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.paymentMethodList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };

        $scope.getPaymentMethodList();


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

        $scope.getstateList = function () {
            $http.post($scope.hiposServerURL  + "/stateList").then(function (response) {
                var data = response.data.object;
                $scope.stateList= data;
            },function (error) {
                Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
            })
        };

        $scope.getstateList();

        $scope.saveOrderList = function () {

            if ($scope.cmpnynameText == ''||angular.isUndefined($scope.cmpnynameText)) {
                Notification.error({message: ' Company Name cannot be empty', positionX: 'center', delay: 2000});
            }
            else if ($scope.emailText == ''||angular.isUndefined($scope.emailText)) {
                Notification.error({message: ' EmailId cannot be empty', positionX: 'center', delay: 2000});
            }
            else if ($scope.nameText == ''||angular.isUndefined($scope.nameText)) {
                Notification.error({message: ' Name cannot be empty', positionX: 'center', delay: 2000});
            }
            else if ($scope.phoneNoText == ''||angular.isUndefined($scope.phoneNoText)) {
                Notification.error({message: ' PhoneNo cannot be empty', positionX: 'center', delay: 2000});
            }
            else if ($scope.subscriptionNameId == ''||angular.isUndefined($scope.subscriptionNameId)) {
                Notification.error({message: ' subscriptionId cannot be empty', positionX: 'center', delay: 2000});
            }
            else if ($scope.userText== ''||angular.isUndefined($scope.userText)) {
                Notification.error({message: ' subscriptionId cannot be empty', positionX: 'center', delay: 2000});
            }
            else if ($scope.pwdText== ''||angular.isUndefined($scope.pwdText)) {
                Notification.error({message: ' subscriptionId cannot be empty', positionX: 'center', delay: 2000});
            }
            else {
                var saveOrderListDetails;
                saveOrderListDetails = {
                    SassOrdersId: $scope.SassOrdersId,
                    companyAddress: $scope.addressText,
                    companyName: $scope.cmpnynameText,
                    deliveryType: $scope.deliveryTypeText,
                    companyEmail: $scope.emailText,
                    customerName: $scope.nameText,
                    newsletter: $scope.newsLetterText,
                    packagesSASSId: $scope.pkgsassidText,
                    companyPhone: $scope.phoneNoText,
                    subscriptionId: $scope.subscriptionNameId.subscriptionName,
                    version: $scope.subscriptionNameId.version,
                    password: $scope.pwdText,
                    username: $scope.userText,
                    companyNo: $scope.companyno,
                    pan: $scope.Pan,
                    incorpDate: $scope.incorpdate,
                    faxno: $scope.faxno,
                    language: $scope.language,
                    website: $scope.website,
                    countryId: $scope.countryId,
                    currencyId: $scope.currencyId,
                    customerId: $rootScope.customerId,
                    stateId: $scope.stateId,
                    gstRegistered: $scope.gstregstered,
                    gstRegisteredDate: $scope.gstregstereddate

                };
                $http.post("/services/buynowOrderSave",angular.toJson(saveOrderListDetails)).then(function (response) {
                    var data = response.data;
                    if (data == "") {
                        Notification.success({message: 'Already exists', positionX: 'center', delay: 2000});
                        }
                    if (data.message == "Duplicate") {
                        Notification.warning({message: 'Email Already exists', positionX: 'center', delay: 2000});
                    }
                    else if(data.object.status=='Limit Exceeded'){
                        Notification.error({message:'Limit Exceeded For That Subscription',positionX:'center',delay:2000})
                    }
                    else {
                        $scope.removeOrderListDetails();
                        $scope.getpaginatedOrderList();
                        $("#add_new_orderlist_modal").modal('hide');
                        Notification.success({
                            message: 'Order Created  successfully',
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
        };


        $scope.getSubscriptionList = function () {
            $(".loader").css("display", "block");
            $http.post($scope.hiposServerURL  + "/getSubscriptionList").then(function (response) {
                var data = response.data.object;
                $scope.subscriptionList = data;
                }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };
        $scope.getSubscriptionList();

        // $scope.getPaginatedSubscriptionList = function (page) {
        //     switch (page) {
        //         case 'firstPage':
        //             $scope.firstPage = true;
        //             $scope.lastPage = false;
        //             $scope.isNext = false;
        //             $scope.isPrev = false;
        //             $scope.pageNo = 0;
        //             break;
        //         case 'lastPage':
        //             $scope.lastPage = true;
        //             $scope.firstPage = false;
        //             $scope.isNext = false;
        //             $scope.isPrev = false;
        //             $scope.pageNo = 0;
        //             break;
        //         case 'nextPage':
        //             $scope.isNext = true;
        //             $scope.isPrev = false;
        //             $scope.lastPage = false;
        //             $scope.firstPage = false;
        //             $scope.pageNo = $scope.pageNo + 1;
        //             break;
        //         case 'prevPage':
        //             $scope.isPrev = true;
        //             $scope.lastPage = false;
        //             $scope.firstPage = false;
        //             $scope.isNext = false;
        //             $scope.pageNo = $scope.pageNo - 1;
        //             break;
        //         default:
        //             $scope.firstPage = true;
        //             $scope.lastPage = false;
        //             $scope.isNext = false;
        //             $scope.isPrev = false;
        //             $scope.pageNo = 0;
        //     }
        //     var paginationDetails;
        //     paginationDetails = {
        //         firstPage: $scope.firstPage,
        //         lastPage: $scope.lastPage,
        //         pageNo: $scope.pageNo,
        //         prevPage: $scope.prevPage,
        //         prevPage: $scope.isPrev,
        //         nextPage: $scope.isNext
        //     }
        //     if (angular.isUndefined($scope.searchText)) {
        //         $scope.searchText = "";
        //     }
        //     $http.post($scope.hiposServerURL + '/getPaginatedSubscriptionList?&searchText=' + $scope.searchText, angular.toJson(paginationDetails)).then(function (response) {
        //         var data = response.data;
        //         $scope.subscriptionList = data.list;
        //         $scope.first = data.firstPage;
        //         $scope.last = data.lastPage;
        //         $scope.prev = data.prevPage;
        //         $scope.next = data.nextPage;
        //         $scope.pageNo = data.pageNo;
        //         $scope.listStatus = true;
        //
        //     }, function (error) {
        //         Notification.error({
        //             message: 'Something went wrong, please try again',
        //             positionX: 'center',
        //             delay: 2000
        //         });
        //     })
        // };
        // $scope.getPaginatedSubscriptionList();
        $scope.companyDetails = function (id) {
            $http.post("/services/getCompanyDetails?id=" + id).then(function (response) {
                var data = response.data;
                $scope.companyno = data.companyNo;
                $scope.addressText = data.companyAddress;
                $scope.gstregstered = data.companyGSTno;
                $scope.noofusers = data.noOfUsers;
                $scope.remainingusers = data.remainingusers;
                $scope.pwdText = data.password;
                $scope.userText = data.userName;
                $("#order_list_company_details").modal('show');
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            });

        }
        $scope.subscriptionDetails = function (id) {
            $http.post("/services/getSubscriptionDetails?id=" + id).then(function (response) {
                var data = response.data;
                $scope.subscriptionNameText = data.subscriptionName;
                $scope.validityText = data.validity;
                $scope.noofcompanies = data.companies;
                $scope.noofusers = data.users;
                $scope.status= data.validityStatus;
                $scope.validity = data.renewValidity;
                $scope.activatedDate = new Date(data.incorpDate);
                $scope.createdDate = new Date(data.createdDate);
                $scope.expireddate = new Date(data.expiryDate);
                $("#get_subscription_modal").modal('show');
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            });

        }
        $scope.licenceKeyDetails = function (id) {
            $http.post("/services/getCompanyDetails?id=" + id).then(function (response) {
                var data = response.data;
                $scope.licenceKey = data.licenceKey;
                $("#licenceKey_details").modal('show');
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            });

        }

        $scope.orderApproval=function (id) {
            $scope.orderId=id;
            $http.post("/services/getPaymentDetails?id=" + id).then(function (response) {
                var data = response.data[0];
                // $scope.balAmount = data.balanceAmount;
                $scope.totalAmount = data.totalAmount;
                $scope.actualPrice=data.actualPrice;
                if(data.paymentmethodType==null||data.paymentmethodType==''){
                    $scope.paymentmode = 'cash';
                }
                else {
                    $scope.paymentmode = data.paymentmethodType;
                }
                if(data.status==null||data.status==''){
                    $scope.status = 'approved';
                }
                else {
                    $scope.status = data.status;
                }
                $scope.transactionDate = new Date(data.transactionDate);
                $scope.getBalTotal();
                $("#order_list_payment_type").modal('show');
            })
        }


        $scope.savepayment = function () {
            var saveDetails;
            saveDetails = {
                paymenetId: $scope.paymenetId,
                totalAmount: $scope.totalAmount,
                transactionDate: $scope.transactionDate,
                actualPrice:$scope.actualPrice,
                balanceAmount: $scope.balAmount,
                paymentMode: $scope.paymentmode,
                sassOrders: $scope.orderId,
                status:$scope.status,
                customerId: $scope.customerId,

            };
            $http.post("/services/savepayment", angular.toJson(saveDetails)).then(function (response) {
                var data = response.data;
                $scope.getpaginatedOrderList();
                if (data == "") {
                    Notification.success({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                $("#order_list_payment_type").modal('hide');
                Notification.success({
                    message: 'Payment Saved  successfully',
                    positionX: 'center',
                    delay: 2000
                });

            });

        }

        $scope.balAmount ="";
        $scope.getBalTotal=function(){
            if($scope.actualPrice<$scope.totalAmount){
                $scope.totalAmount=0;
                Notification.error({
                    message: 'Amount Paid Should Not Be More Than Total Amount',
                    positionX: 'center',
                    delay: 2000
                });
            }
                $scope.balAmount = $scope.actualPrice - $scope.totalAmount;
        }
        $scope.getpaginatedOrderList = function (page) {
            switch (page) {
                case 'firstPage':
                    $scope.firstPage = true;
                    $scope.lastPage = false;
                    $scope.isNext = false;
                    $scope.isPrev = false;
                    $scope.pageNo = 0;
                    break;
                case 'lastPage':
                    $scope.lastPage = true;
                    $scope.firstPage = false;
                    $scope.isPrev = false;
                    $scope. isNext = false;
                    $scope.pageNo = 0;
                    break;
                case 'nextPage':
                    $scope.isNext = true;
                    $scope.isPrev = false;
                    $scope.lastPage = false;
                    $scope.firstPage = false;
                    $scope.pageNo = $scope.pageNo + 1;
                    break;
                case 'prevPage':
                    $scope.isPrev = true;
                    $scope.lastPage = false;
                    $scope.firstPage = false;
                    $scope.isNext = false;
                    $scope.pageNo = $scope.pageNo - 1;
                    break;
                default:
                    $scope.firstPage = true;
                    $scope.lastPage = false;
                    $scope.isPrev = false;
                    $scope.isNext = false;
                    $scope.pageNo = 0;
            }
            var paginationDetails;
            paginationDetails = {
                firstPage: $scope.firstPage,
                lastPage: $scope.lastPage,
                pageNo: $scope.pageNo,
                prevPage: $scope.isPrev,
                nextPage: $scope.isNext
            }
            if (angular.isUndefined($scope.searchText)) {
                $scope.searchText = "";
            }
            $http.post($scope.hiposServerURL + '/getPaginatedorderList?searchText=' + $scope.searchText, angular.toJson(paginationDetails)).then(function (response) {
                var data = response.data;
                console.log(data);
                $scope.orderList = data.list;
                $scope.first = data.firstPage;
                $scope.last = data.lastPage;
                $scope.prev = data.prevPage;
                $scope.next = data.nextPage;
                $scope.pageNo = data.pageNo;
                $scope.listStatus = true;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })
        };
        $scope.getpaginatedOrderList();


        $scope.renewsubscription = function (data) {
            $scope.sassOrdersId = data.sassOrdersId;
            $scope.subscriptionNameText = data.subscriptionName;
            $scope.validityText = data.renew.validity;
if(data.renew.renewalDate!=null) {
    $scope.renewaldate = new Date(data.renew.renewalDate);
}else {
    $scope.renewaldate = new Date();
}
            // $scope.companies = data.companies;
            $("#add_new_renew_modal").modal('show');
        }


        $scope.saverenew = function () {
            var saveDetails;
            saveDetails = {
                sassOrdersId:$scope.sassOrdersId,
                subscriptionName: $scope.subscriptionNameText,
                validity: $scope.validityText,
                renewDate:$scope.renewaldate
                // companies:$scope.companies
            }
            $http.post("/services/saveOrdersrenew" , angular.toJson(saveDetails)).then(function (response) {
                var data = response.data;
                if(data==""){
                    Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else {
                    $("#add_new_renew_modal").modal('hide');
                    $scope.getSubscriptionList();
                    Notification.success({message: 'Renew Created  successfully', positionX: 'center', delay: 2000});
                }
            },function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            });
        }


    });
