app.controller('customernotifCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";
        $scope.hiposServerURLS = "/zomatoService";
        $scope.addcustnotif = function () {
            $("#add_new_cust_notif_modal").modal('show');
        };

        $scope.getcustnotifList = function () {
            $http.post($scope.hiposServerURL + "/customernotifyList?typedoc=" + "").then(function (response) {
                var data = response.data.object;
                $scope.typedoclist = data;
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })
        };


        $scope.pickedup = function (type, data) {
            $scope.type = "pickup";
            $scope.orderid = data.orderId;
            $scope.custNotiId = data.custNotiId;

            $("#add_new_picked_modal").modal('show');
        }


        $scope.asiandeliver = function (type, data) {
            $scope.type = "deliver";
            $scope.orderid = data.orderId;
            $scope.custNotiId = data.custNotiId;
            $("#add_new_picked_modal").modal('show');
        }

        $scope.reject = function (data) {

            $scope.rejectionmessage = null;
            $scope.orderid = data.orderId;
            $scope.custNotiId = data.custNotiId;
            $("#add_new_reject_modal").modal('show');
        };
        $scope.confirm = function (data) {
            $scope.orderid = data.orderId;
            $scope.custNotiId = data.custNotiId;
            $("#add_new_confirm_modal").modal('show');
        };
        $scope.ready = function (data) {
            $scope.orderid = data.orderId;
            $scope.custNotiId = data.custNotiId;
            $("#add_new_ready_modal").modal('show');
        }


        $scope.saveconfirm = function () {
            var details;
            details = {
                custNotiId: $scope.custNotiId,
                orderId: $scope.orderid,
                externalOrderId: $scope.externalid,
                deliveryTime: $scope.deliverytime,
                prepareTime: $scope.preptime

            };
            $http.post("/zomatoService/saveconfirm", angular.toJson(details)).then(function (response) {
                var data = response.data;
                if (data == "") {
                    Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else {
                    // $scope.view();
                    $("#add_new_confirm_modal").modal('hide');
                    Notification.success({
                        message: 'Confirmed',
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
        $scope.saveready = function () {
            var details;
            details = {
                custNotiId: $scope.custNotiId,
                orderId: $scope.orderid,
                customerArrivalTime: $scope.custarrivaltime,
                prepareTime: $scope.prepareTime

            };
            $http.post("/zomatoService/saveready", angular.toJson(details)).then(function (response) {
                var data = response.data;
                if (data == "") {
                    Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else {
                    // $scope.view();
                    $("#add_new_ready_modal").modal('hide');
                    Notification.success({
                        message: 'Your Item is Ready',
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
        $scope.saveasiandelivery = function () {
            var details;
            details = {
                custNotiId: $scope.custNotiId,
                orderId: $scope.orderid,
                riderName: $scope.ridername,
                riderPhoneNo: $scope.phonenumber

            };
            $http.post("/zomatoService/saveasiandelivery", angular.toJson(details)).then(function (response) {
                var data = response.data;
                if (data == "") {
                    Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else {
                    // $scope.view();
                    $("#add_new_picked_modal").modal('hide');
                    Notification.success({
                        message: 'Confirmed',
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
        $scope.savepickedup = function () {
            var details;
            details = {
                custNotiId: $scope.custNotiId,
                orderId: $scope.orderid,
                riderName: $scope.ridername,
                riderPhoneNo: $scope.phonenumber

            };
            $http.post("/zomatoService/savepickedup", angular.toJson(details)).then(function (response) {
                var data = response.data;
                if (data == "") {
                    Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else {
                    // $scope.view();
                    $("#add_new_picked_modal").modal('hide');
                    Notification.success({
                        message: 'Picked Up SuccessFully',
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
        $scope.restaurantName = null;
        $scope.viewAllDetails = function (notification) {
            $scope.notification = notification;
            $("#viewalldetails").modal('show');
        }
        $scope.StatusUpdate = function (notification) {
            $scope.orderDetails = notification;
            $("#viewStatusChange").modal('show');
        }
        $scope.getpaginatednotificationList = function (page) {
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
                    $scope.isNext = false;
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
            if (angular.isUndefined($scope.restaurantName)||$scope.restaurantName==null) {
                $scope.restaurantName = "";
            }

            $http.post($scope.hiposServerURL + '/getpaginatednotificationList?searchText=' + $scope.searchText + '&restaurantName=' + $scope.restaurantName, angular.toJson(paginationDetails)).then(function (response) {
                var data = response.data;
                console.log(data);
                $scope.notificationList = data.list;
                angular.forEach($scope.notificationList, function (val, key) {
                    var object = JSON.parse(val.objectdata);
                    val.customerName = object.order.customer_details.name;
                    val.location = object.order.customer_details.delivery_area;
                    val.amount = object.order.net_amount;
                    val.paymentStatus = object.order.payment_status;
                    val.phone = object.order.customer_details.phone_number;
                    val.orderId = object.order.order_id;
                    val.email = object.order.customer_details.email;
                    val.pincode = object.order.customer_details.pincode;
                    val.address = object.order.customer_details.address;
                    val.city = object.order.customer_details.city;
                    val.country = object.order.customer_details.country;
                    val.itemdetails = object.order.order_items;
                    val.total = object.order.net_amount;
                    val.amountPaid = object.order.amount_paid;
                    val.balance = object.order.amount_balance;
                    val.cashcollect = object.order.cash_to_be_collected;
                    val.paymentmode = object.order.payment_mode;
                    // val.restaurantName=object.order.restaurant_name;
                    val.charges = object.order.charges;
                    val.subTotal = object.order.order_subtotal;
                    val.totalTaxes = object.order.order_level_total_taxes;
                    val.totalCharges = object.order.order_level_total_charges;
                    val.itemCharge=object.order.item_level_total_charges;
                    val.itemTaxes=object.order.item_level_total_taxes;
                    val.discount = object.order.discount;
                    if (object.order.createdTime != null) {
                        val.createdTime = new Date(object.order.createdTime);
                    }
                    if (object.order.deliveryTime != null) {
                        val.deliveryTime = new Date(object.order.deliveryTime);
                    }
                })
                if (angular.isUndefined($scope.restaurantName)||$scope.restaurantName=="") {
                    $scope.restaurantName = null;
                }
                $scope.first = data.firstPage;
                $scope.last = data.lastPage;
                $scope.prev = data.prevPage;
                $scope.next = data.nextPage;
                $scope.pageNo = data.pageNo;
                $scope.listStatus = true;
                if (data == "") {
                    Notification.error({message: 'Search Not Found', positionX: 'center', delay: 2000});
                }
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })
        };
        $scope.getpaginatednotificationList();
        $scope.getCartCustomerList = function (val) {
            $http.post("/hiConnectService" + "/getRestaurantNamesList").then(function (response) {
                var data = response.data;
                $scope.restaurantList = data;
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };

        $scope.getCartCustomerList();
        $scope.savedeliverd = function () {
            var details;
            details = {
                custNotiId: $scope.custNotiId,
                orderId: $scope.orderid

            };
            $http.post("/zomatoService/savedeliverd", angular.toJson(details)).then(function (response) {
                var data = response.data;
                if (data == "") {
                    Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else {
                    Notification.success({
                        message: 'Delivered SuccessFully',
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
        $scope.savereject = function () {
            var details;
            details = {
                custNotiId: $scope.custNotiId,
                orderId: $scope.orderid,
                rejectionMessageId: $scope.rejectionmessage,
                vendorRejectionMessage: $scope.vendormessage
            };
            $http.post("/zomatoService/savereject", angular.toJson(details)).then(function (response) {
                var data = response.data;
                if (data == "") {
                    Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else {
                    // $scope.view();
                    $("#add_new_reject_modal").modal('hide');
                    Notification.success({
                        message: 'Rejected SuccessFully',
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