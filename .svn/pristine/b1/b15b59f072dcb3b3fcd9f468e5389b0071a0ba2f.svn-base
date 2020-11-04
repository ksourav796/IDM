app.controller('menuBuildersCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification,$window) {
        $scope.hiposServerURL = "/pkt";


        // $scope.removeAction = function () {
        //     $scope.menuName = "";
        //     $scope.sequencenO = "";
        //     $scope.status = "";
        //     $scope.parentid = "";
        // };

        $scope.getApplicationList = function () {

            $http.post($scope.hiposServerURL + "/getApplicationLists").then(function (response) {
                var data = response.data.object;
                $scope.applicationtype = data;
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })
        };
        $scope.getApplicationList();

        $scope.getMenuBuilderList = function () {
            $http.post($scope.hiposServerURL + "/getMenuBuilderList").then(function (response) {
                var data = response.data.object;
                $scope.menuList = data;
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })
        };
        $scope.getMenuBuilderList();


        function proceedCompressedImage(compressedSrc) {
            $('#image-preview').attr('src', compressedSrc);
            $scope.fileToUpload = compressedSrc;
        }

        $scope.blankImgSrc = function () {
            $('.image-preview').attr('src', '');
            $('#imageLoad').val('');
        }
        $scope.pktImgae = function () {

            $("#add_new_Pkt_Image_modal").modal('show');

        };

        $scope.imageUpload = function (event) {
            var files = event.target.files;
            var file = files[0];
            var srcString;
            var imageCompressor = new ImageCompressor;
            var compressorSettings = {
                toWidth: 200,
                toHeight: 200,
                mimeType: 'image/png',
                mode: 'strict',
                quality: 1,
                grayScale: false,
                sepia: false,
                threshold: false,
                speed: 'low'
            };
            if (files && file) {
                var reader = new FileReader();
                reader.onload = function (readerEvt) {
                    binaryString = readerEvt.target.result;
                    $('.image-preview').attr('src', binaryString);
                };
                reader.readAsDataURL(file);
                reader.onloadend = function () {
                    srcString = $('.image-preview').attr("src");
                    imageCompressor.run(srcString, compressorSettings, proceedCompressedImage);
                };
            }
        };

        $scope.saveProperty = function () {
            {
                var saveProperty;
                saveProperty = {
                    logo: $scope.fileToUpload
                };
                // $scope.logo = saveProperty;
                $("#add_new_Pkt_Image_modal").modal('hide');

            }
        };

        $scope.addNewMenuBuilder = function () {
            $scope.status = "Active";
            $scope.menuName = "";
            $scope.keySubscription = null;
            $scope.sequencenO = "";
            $scope.parentid = null;
            $('#menu-title').text('Add MenuList');
            $("#add_new_MenuBuilder_modal").modal('show');

        };


//////////////////////JSONDATAFORMAT///////////////////////
        $scope.saveMenuBuilder = function () {
            $scope.result = [];
            angular.forEach($scope.menuBuilderList, function (val, key) {
                $scope.val = {};

                if (angular.isUndefined(val.keySubscription) || val.keySubscription === null) {
                    val.keySubscription = "";
                }

                $scope.keySubscription1 = val.keySubscription;
                if (angular.isUndefined(val.menuName) || val.menuName === null) {
                    val.menuName = "";
                }

                $scope.menuName = val.menuName;
                if (angular.isUndefined(val.sequencenO) || val.sequencenO === null) {
                    val.sequencenO = "";
                }

                $scope.sequenceno = val.sequenceno;
                if (angular.isUndefined(val.parentid) || val.parentid === null) {
                    val.parentid = "";
                }
                $scope.parentid = val.parentid;

                if (angular.isUndefined(val.headerValue) || val.headerValue === null) {
                    val.headerValue = "";
                }
                $scope.headerValue = val.headerValue;

                if (angular.isUndefined(val.footerValue) || val.footerValue === null) {
                    val.footerValue = "";
                }
                $scope.footerValue = val.footerValue;
                $scope.status = val.status;

                $scope.result.push({
                    keySubscription: $scope.keySubscription1,
                    menuName: $scope.menuName,
                    sequenceno: $scope.sequenceno,
                    status: $scope.status,
                    ParentId: $scope.parentid,
                })
            });
            $scope.menuBuilders = (angular.toJson($scope.result));
            var JsonData;
            JsonData = {
                builderValue: $scope.menuBuilders,
                applicationName: $scope.keySubscription1,
                headerValue: $scope.headerValue,
                footerValue: $scope.footerValue,
            };
            $http.post("/pkt/saveMenuBuilderData", JsonData).then(function (response) {
                var data = response.data;
                if (data == "") {
                    Notification.error({message: 'Already exists ', positionX: 'center', delay: 2000});
                }
                else {
                    $scope.getMenuBuilderList();
                    $("#add_new_MenuBuilder_modal").modal('hide');
                    Notification.success({
                        message: 'Saved  successfully',
                        positionX: 'center',
                        delay: 2000
                    });
                }
            });
            window.location.reload();

        };
      ///////* Edit Method*/////////

        $scope.editMenuList = function(data){
            $http.post("/pkt/editMenuBuilder?id="+data.pktBuilderId).then(function (response) {
                var data = response.data;
                $scope.menuBuilderList = (angular.fromJson(data.builderValue));
                $scope.subMenuBuilderList=[];
                angular.forEach($scope.menuBuilderList,function (val,key) {
                    val.subMenuBuilderList=angular.fromJson(val.ParentId);
                });
                $('#menu-title').text('Edit MenuList');
              $("#add_new_MenuBuilder_modal").modal('show');

            });
        }
/////////////////////////////////////////////////////
        $scope.saveSubMenuBuilder = function () {
            $scope.result1 = [];
            angular.forEach($scope.subMenuBuilderList, function (val, key) {
                $scope.val = {};


                if (angular.isUndefined(val.parentGroup) || val.parentGroup === null) {
                    val.parentGroup = "";
                }

                $scope.parentGroup = val.parentGroup;

                if (angular.isUndefined(val.parentvalue) || val.parentvalue === null) {
                    val.parentvalue = "";
                }

                $scope.parentvalue = val.parentvalue;


                if (angular.isUndefined(val.sequencenumber) || val.sequencenumber === null) {
                    val.sequencenumber = "";
                }

                $scope.sequencenumber = val.sequencenumber;

                $scope.result1.push({
                    ParentGroup: $scope.parentGroup,
                    ParentValue: $scope.parentvalue,
                    sequencenumber: $scope.sequencenumber
                });
            });
            angular.forEach($scope.menuBuilderList, function (val, key) {
                if ($scope.index == key) {
                    val.parentid = (angular.toJson($scope.result1));
                }
            });
            $("#add_new_MenuBuilder_modal1").modal('hide');
        };
////////////////////////////////////////////////////////////////////////////////

        // $scope.saveHeaderValue = function () {
        //     $scope.header = {};
        //     angular.forEach($scope.headerValueList, function (val, key) {
        //         $scope.val = {};
        //
        //         if (angular.isUndefined(val.heading) || val.heading === null) {
        //             val.heading = " ";
        //         }
        //         $scope.heading = val.heading;
        //
        //         // if (angular.isUndefined(val.logo) || val.logo === null) {
        //         //     val.logo = " ";
        //         // }
        //         // $scope.logo = val.logo;
        //
        //
        //         if (angular.isUndefined(val.logouturl) || val.logouturl === null) {
        //             val.logouturl = " ";
        //         }
        //         $scope.logouturl = val.logouturl;
        //
        //         if (angular.isUndefined(val.logvalue) || val.logvalue === null) {
        //             val.logvalue = " ";
        //         }
        //         $scope.logvalue = val.logvalue;
        //         $scope.header = {
        //             heading: $scope.heading,
        //             logo: $scope.fileToUpload,
        //             logouturl: $scope.logouturl,
        //             logvalue: $scope.logvalue,
        //         };
        //     })
        //     // angular.forEach($scope.menuBuilderList, function (val, key) {
        //     //     if ($scope.index == key) {
        //     //         $scope.headerValue = (angular.toJson($scope.header));
        //     //     }
        //     // });
        //     $scope.headerValue = (angular.toJson($scope.header));
        //     var JsonData;
        //     JsonData = {
        //
        //         headerValue:$scope.headerValue,
        //         applicationName: $scope.applicationName,
        //         pktBuilderId: $scope.pktBuilderId
        //     };
        //     $http.post("/pkt/saveHeaderValues", JsonData).then(function (response) {
        //         var data = response.data;
        //         if (data.message == "success") {
        //             Notification.success({
        //                 message: 'Saved  successfully',
        //                 positionX: 'center',
        //                 delay: 2000
        //             });
        //         }
        //     });
        //     $("#add_new_HeaderValue_modal1").modal('hide');
        //
        //
        // };



        $scope.saveHeaderValue = function () {

            $scope.header = {
                heading: $scope.heading,
                logo: $scope.fileToUpload,
                logouturl: $scope.logouturl,
                logvalue: $scope.logvalue,
            }
            $scope.headerValue = (angular.toJson($scope.header));
                var JsonData;
                JsonData = {

                    headerValue:$scope.headerValue,
                    applicationName: $scope.applicationName,
                    pktBuilderId: $scope.pktBuilderId
                };
            $http.post("/pkt/saveHeaderValues", JsonData).then(function (response) {
                        var data = response.data;
                        if (data.message == "success") {
                            Notification.success({
                                message: 'Saved  successfully',
                                positionX: 'center',
                                delay: 2000
                            });
                        }
                    });
                    $("#add_new_HeaderValue_modal1").modal('hide');
        };
//////////////////////////////
        $scope.saveFooterValue = function () {
            $scope.parentfooter = [];
            angular.forEach($scope.footerValueList, function (val, key) {

                if (angular.isUndefined(val.companyname) || val.companyname === null) {
                    val.companyname = " ";
                }
                $scope.companyname = val.companyname;

                if (angular.isUndefined(val.footerno) || val.footerno === null) {
                    val.footerno = " ";
                }
                $scope.footerno = val.footerno;


                if (angular.isUndefined(val.url) || val.url === null) {
                    val.url = " ";
                }
                $scope.url = val.url;

                if (angular.isUndefined(val.footParentValue) || val.footParentValue === null) {
                    val.footParentValue = " ";
                }
                $scope.footParentValue = val.footParentValue;

                // if (angular.isUndefined(val.footer) || val.footer === null) {
                //     val.footer = " ";
                // }
                // $scope.footer = val.footer;

                if (angular.isUndefined(val.value) || val.value === null) {
                    val.value = " ";
                }
                $scope.value = val.value;

                $scope.parentfooter.push({
                    companyname: $scope.companyname,
                    footParentValue: $scope.footParentValue,
                    // footer: $scope.footer,
                    value: $scope.value,
                    url: $scope.url,
                    footerno: $scope.footerno,
                });
            });
            $("#add_new_FooterValue_modal1").modal('hide');
            // $("#add_new_pkt_Footer_modal").modal('show');
        }

            //
            // angular.forEach($scope.menuBuilderList, function (val, key) {
            //     if ($scope.index == key) {
            //         val.footerValue = (angular.toJson($scope.parentfooter));
            //     }
            // });

            $scope.savefooter = function(){
            $scope.footerval = (angular.toJson($scope.parentfooter));
            var footer={
            footer:$scope.footer,
                footerValue:$scope.footerval
            };
            var JsonData;
            JsonData = {
                footerValue:angular.toJson(footer),
                applicationName: $scope.applicationName,
                pktBuilderId: $scope.pktBuilderId
            };
            $http.post("/pkt/saveFooterValues", JsonData).then(function (response) {
                var data = response.data;
                if (data.message == "success") {
                    Notification.success({
                        message: 'Saved  successfully',
                        positionX: 'center',
                        delay: 2000
                    });
                }
            });
            $("#add_new_pkt_Footer_modal").modal('hide');

        };
////////////////////////////////////////////////////////

        $scope.saveSubFooterValue = function () {
            $scope.subFooter = [];
            angular.forEach($scope.subFooterValueList, function (val, key) {
                $scope.val = {};

                if (angular.isUndefined(val.subcompanyname) || val.subcompanyname === null) {
                    val.subcompanyname = " ";
                }
                $scope.subcompanyname = val.subcompanyname;


                if (angular.isUndefined(val.subfooter) || val.subfooter === null) {
                    val.subfooter = " ";
                }
                $scope.subfooter = val.subfooter;

                if (angular.isUndefined(val.suburl) || val.suburl === null) {
                    val.suburl = " ";
                }
                $scope.suburl = val.suburl;


                if (angular.isUndefined(val.subvalue) || val.subvalue === null) {
                    val.subvalue = " ";
                }
                $scope.subvalue = val.subvalue;


                $scope.subFooter.push({
                    subcompanyname: $scope.subcompanyname,
                    subfooter: $scope.subfooter,
                    suburl: $scope.suburl,
                    subvalue: $scope.subvalue
                })


            });

            angular.forEach($scope.footerValueList, function (val, key) {
                if ($scope.index == key) {
                    val.value = (angular.toJson($scope.subFooter));
                }
            });

            $("#add_new_SubFooterValue_modal").modal('hide');

        };


        $scope.getSubmenuBuilderList = function (index, operation) {
            $scope.subMenuBuilderList = [];
            $scope.submenu = operation.menuName;
            $scope.subMenuBuilderList.push({
                parentGroup: operation.menuName
            });
            $scope.index = index;
            $('#cust-notif1').text("");
            if(operation.subMenuBuilderList.length>0){
                // angular.forEach(operation.subMenuBuilderList,function (val,key) {
                //     operation.parentGroup = val.ParentGroup,
                //         operation.parentvalue = val.ParentValue,
                //         operation.sequencenumber=val.sequencenumber
                //
                // })
                $scope.subMenuBuilderList=operation.subMenuBuilderList;
            }
            $("#add_new_MenuBuilder_modal1").modal('show');
        };


        $scope.getHeaderValuesList = function (operation) {
            $http.post("/pkt/editheadervalue?id="+operation.pktBuilderId).then(function (response) {
                var data = response.data;
                if(data.headerValue!="") {
                    $scope.heading1 = angular.fromJson(data.headerValue);
                    $scope.heading = $scope.heading1.heading;
                    $scope.logvalue = $scope.heading1.logvalue;
                }else {
                    $scope.applicationName = operation.applicationName;
                    $scope.pktBuilderId = operation.pktBuilderId;
                }
                    $('#cust-notif1').text("");
                    $("#add_new_HeaderValue_modal1").modal('show');
            });
        };


        $scope.getFooterValueList = function (operation) {
            $http.post("/pkt/editFooterValue?id="+operation.pktBuilderId).then(function (response) {
                var data = response.data;
                if(data.footerValue!="") {
                    $scope.footerValueList1 = angular.fromJson(data.footerValue);
                    $scope.footer = $scope.footerValueList1.footer;
                    $scope.footerValueList = angular.fromJson($scope.footerValueList1.footerValue);
                }else {
                    $scope.applicationName = operation.applicationName;
                    $scope.pktBuilderId = operation.pktBuilderId;
                }
                    $("#add_new_pkt_Footer_modal").modal('show');
                });
        };

        $scope.menubuilderfooterlist = function(){
            $("#add_new_FooterValue_modal1").modal('show');
            // $("#add_new_pkt_Footer_modal").modal('hide');
        };


        $scope.getSubFooterValue = function (index, footervalue) {
            $scope.subFooterValueList = [];
            $scope.subfooter = footervalue.footParentValue;
            $scope.subcompanyname = footervalue.companyname;
            $scope.subFooterValueList.push({
                subfooter: footervalue.footParentValue,
                subcompanyname: footervalue.companyname
            });
            $scope.index = index;
            $('#cust-notif1').text("");
            $("#add_new_SubFooterValue_modal").modal('show');

        };


        $scope.removefuncOperation = function () {
            var newDataList = [];
            $scope.selectedAll = false;
            angular.forEach($scope.menuBuilderList, function (selected) {
                if (!selected.selected) {
                    newDataList.push(selected);
                }
            });
            $scope.menuBuilderList = newDataList;
        };


        $scope.menuBuilderList = [];
        $scope.addMeneBuilderOperation = function (data) {
            angular.forEach(data, function (data) {
                $scope.keySubscription = data.keySubscription;
                $scope.status = data.status;
            });
            $scope.subMenuBuilderList.push({
                keySubscription: data.keySubscription
            });

            if ($scope.menuBuilderList == "") {
                $scope.menuBuilderList = [];
            }
            $scope.menuBuilderList.push({
                keySubscription: $scope.keySubscription,
                status: $scope.status
            });
        };

        $scope.removeaddnew = function(){
            $scope.menuBuilderList.pop({
            })
        };


        $scope.removefuncOperation = function () {
            var newDataList = [];
            $scope.selectedAll = false;
            angular.forEach($scope.subMenuBuilderList, function (selected) {
                if (!selected.selected) {
                    newDataList.push(selected);
                }
            });
            $scope.subMenuBuilderList = newDataList;
        };


        $scope.subMenuBuilderList = [];
        $scope.addsubMenuBuilderOperation = function () {
            if ($scope.subMenuBuilderList == "") {
                $scope.subMenuBuilderList = [];
            }
            $scope.subMenuBuilderList.push({
                parentGroup: $scope.submenu
            });
        };


        $scope.headerValueList = [];
        $scope.addHeaderValueOperation = function () {
            if ($scope.headerValueList == "") {
                $scope.headerValueList = [];
            }
            $scope.headerValueList.push({});

        };

        $scope.footerValueList = [];
        $scope.addFooterValueOperation = function () {
            if ($scope.footerValueList == "") {
                $scope.footerValueList = [];

            }
            $scope.footerValueList.push({
                companyname: $scope.applicationName

            });
        };

        $scope.remove = function(){
            $scope.footerValueList.pop({})
        }

        $scope.subFooterValueList = [];
        $scope.addSubFooterValueOperation = function () {
            if ($scope.subFooterValueList == "") {
                $scope.subFooterValueList = [];
            }
            $scope.subFooterValueList.push({
                subfooter: $scope.subfooter,
                subcompanyname: $scope.subcompanyname
            });
        }
        $scope.getPktPermisssionListPKts = function (opeartion) {
            $scope.keySubscription=opeartion.keySubscription;
            angular.forEach($scope.menuBuilderList,function (val,key) {
                val.keySubscription =  $scope.keySubscription;

            })
            $http.post($scope.hiposServerURL + "/getPktPermisssionList?subscription=" + $scope.keySubscription).then(function (response) {
                var data = response.data.object;
                opeartion.tableNameListOnPkts = data;
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })
        };

    });
