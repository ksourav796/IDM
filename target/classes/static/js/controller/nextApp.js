app.controller('nextappsCtrl', function ($scope, $rootScope, $http, $location, $filter, Notification,$timeout) {

    $scope.SassControlPanelService = "/services";

    $rootScope.getSubscriptionListByDeveloperId();

    $scope.addNewProperty = function (name) {


        $http.post($scope.hiposServerURL  + "/editProperty?name="+name).then(function (response) {
            var data = response.data;
            $scope.propertytype= data;
            angular.forEach($scope.propertytype ,function (data) {
                $scope.description=data.description;
                $scope.fileName=data.file;
                $scope.id=data.id;
                $scope.fileToUpload=null;
            })
            $scope.subscriptionName=name;
            $scope.devCode=$rootScope.developerId;

            // $scope.id=null;
            $("#add_new_Property_modal").modal('show');
        });

    };

    $scope.hiposServerURL = "/services";


    $scope.removeProperties = function () {
        $scope.file="";
        $scope.description="";
        $scope.id="";
    };

    $scope.getPropertyList = function () {

        $http.post($scope.hiposServerURL  + "/getPropertyList?name="+name).then(function (response) {
            var data = response.data.object;
            $scope.propertytype= data;
        }
        ,function (error) {
            Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
        })
    };
    $scope.getPropertyList();
    $scope.editProperty=function(data){
        $scope.id=data.id;
        $scope.file=data.file;
        $scope.description=data.description;
        $('#cust-notif').text("Edit");
        $("#add_new_Property_modal").modal('show');
    }


    $scope.uploadFile = function () {
        var file = $scope.myFile;
        var uploadUrl = "/fileUpload";
        var fd = new FormData();
        fd.append('file', file);
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(function () {
        })
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

    function proceedCompressedImage(compressedSrc) {
        $('#image-preview').attr('src', compressedSrc);
        $scope.fileToUpload = compressedSrc;
    }
    $scope.blankImgSrc = function () {
        $('.image-preview').attr('src', '');
        $('#imageLoad').val('');
    }



    $scope.saveProperty = function () {
        // if ($scope.tableName === '') {
        //     Notification.warning({
        //         message: 'TableName  can not be empty',
        //         positionX: 'center',
        //         delay: 2000
        //     });
        // }
        // else if($scope.fieldName === ''){
        //     Notification.warning({
        //         message: 'FieldName  can not be empty',
        //         positionX: 'center',
        //         delay: 2000
        //
        //
        //     });
        // }
        // else
        {
            var saveProperty;
            saveProperty = {
                id: $scope.id,
                file: $scope.fileToUpload,
                description: $scope.description,
                name: $scope.subscriptionName,
                developerId: $scope.devCode,
                // status: $scope.status

            };
            $http.post("/services/saveProperty", saveProperty).then(function (response) {
                var data = response.data;
                if (data == "") {
                    Notification.error({message: 'Already exists', positionX: 'center', delay: 2000});
                }
                else {
                    // $scope.removeProperties();
                    $scope.getPropertyList();
                    $("#add_new_Property_modal").modal('hide');
                    Notification.success({
                        message: 'Property Created  successfully',
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
    }
});