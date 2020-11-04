app.controller('itemCtrl',
    function ($scope, $rootScope, $http, $location, $filter, Notification) {
        $scope.hiposServerURL = "/services";
        $scope.word = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
        $scope.customerId = 1;
        $scope.userRights = [];
        $scope.operation = 'Create';
        $scope.customer = 1;
        $scope.today = new Date();


        $scope.removeCustomerDetails = function () {
            $scope.itemCodeText="";
            $scope.itemNameText = "";
            $scope.itemDescText = "";
            $scope.stockText = "";
            $scope.discountAmountRpercentText = "";
            $scope.DiscountInPercentText = "";
            $scope.salesPriceText = "";
            $scope.purchasePriceText = "";
            $scope.itemTypeNameText = "";
            $scope.itemCategoryNameText = "";
            $scope.brandNameText = "";
            $scope.inclusiveJSONText = "";
            $scope.hsnCodeText = "";
            $scope.unitPriceText = "";
            $scope.unitPriceInText = "";
            $scope.qtyText = "";
            $scope.cessText = "";
            $scope.inventoryMovementNameText = "";
            $scope.barCodeText = "";
            $scope.fileNameText = "";
            $scope.discountAmtText = "";

        };
        $scope.edititem=function(data){
            $scope.itemId=data.itemId;
             $scope.itemCodeText=data.itemCode;
                 $scope.itemNameText=data.itemName;
                $scope.itemDescText=data.itemDesc;
                $scope.stockText=data.stock;
                $scope.discountAmountRpercentText=data.discountAmountRpercent;
                $scope.DiscountInPercentText=data.isDiscountInPercent;
                $scope.salesPriceText=data.salesPrice;
                $scope.purchasePriceText=data.purchasePrice;
                $scope.itemTypeNameText=data.itemTypeName;
                $scope.itemCategoryNameText=data.itemCategoryName;
                $scope.brandNameText=data.brandName;
                $scope.status=data.itemStatus;
                $scope.inclusiveJSONText=data.inclusiveJSON;
                $scope.hsnCodeText=data.hsnCode;
                $scope.unitPriceText=data.unitPrice;
                $scope.unitPriceInText=data.unitPriceIn;
                $scope.qtyText=data.qty;
                $scope.cessText=data.cess;
                $scope.inventoryMovementNameText=data.inventoryMovementName;
                $scope.barCodeText=data.barCode;
                $scope.fileNameText=data.fileName;
                $scope.discountAmtText=data.discountAmt;

            $('#Item-title').text("Edit Item");
            $("#add_new_Item_modal").modal('show');
        }

        $scope.addNewItem = function () {
            $scope.custNameText = "";
            $scope.customerEmailText = "";
            $scope.customerContactText = "";
            $scope.customerAddressText = "";
            $scope.creditLimitText = "";
            $scope.creditTermText = "";
            $scope.fromRegNo = "";
            $scope.gstText = "";
            $scope.accNoText = "";
            $scope.bankNameText = "";
            $scope.IFSCText = "";
            $scope.bankBranchText = "";
            $scope.personInchargeText = "";
            $scope.panNumberText = "";
            $scope.websiteText = "";
            $scope.custStatusText = "Active";
            $http.post("/services/getCountry").then(function (response) {
                var data = response.data.object;
                $scope.countryPojoList=data;
            },function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            });
            $('#Item-title').text("Add Item");
            $("#add_new_Item_modal").modal('show');

        };

        $scope.getIcItemList = function () {
            $(".loader").css("display", "block");
            $http.post($scope.hiposServerURL  + "/getItemList").then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.ictemList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };

        $scope.getIcItemList();

        $scope.saveItem=function () {
                var saveItemDetails;
                saveItemDetails = {
                    itemId:$scope.itemId,
                    itemCode: $scope.itemCodeText,
                    itemName: $scope.itemNameText,
                    itemDesc:$scope.itemDescText,
                    stock:$scope.stockText,
                    discountAmountRpercent:$scope.discountAmountRpercentText,
                    isDiscountInPercent:$scope.DiscountInPercentText,
                    salesPrice:$scope.salesPriceText,
                    purchasePrice:$scope.purchasePriceText,
                    itemTypeName:$scope.itemTypeNameText,
                    itemCategoryName:$scope.itemCategoryNameText,
                    brandName:$scope.brandNameText,
                    itemStatus:$scope.status,
                    inclusiveJSON:$scope.inclusiveJSONText,
                    hsnCode:$scope.hsnCodeText,
                    unitPrice:$scope.unitPriceText,
                    unitPriceIn:$scope.unitPriceInText,
                    qty:$scope.qtyText,
                    cess:$scope.cessText,
                    inventoryMovementName:$scope.inventoryMovementNameText,
                    barCode:$scope.barCodeText,
                    fileName:$scope.fileNameText,
                    discountAmt:$scope.discountAmtText


                };


                $http.post("/services/saveNewItem",angular.toJson(saveItemDetails)).then(function (response) {
                    var data = response.data;
                    if(data==""){
                        Notification.error({message: 'Email Already exists', positionX: 'center', delay: 2000});
                    }
                    else if(angular.isUndefined($scope.itemCodeText) || $scope.itemCodeText == '') {
                        Notification.warning({message: 'itemCode can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.itemNameText) || $scope.itemNameText == '') {
                        Notification.warning({message: 'itemName can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.itemDescText) || $scope.itemDescText == '') {
                        Notification.warning({message: 'itemDescription can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.stockText) || $scope.stockText == '') {
                        Notification.warning({message: 'stock can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.discountAmountRpercentText) || $scope.discountAmountRpercentText == '') {
                        Notification.warning({message: 'discountAmount can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.salesPriceText) || $scope.salesPriceText == '') {
                        Notification.warning({message: 'SalesPrice can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.purchasePriceText) || $scope.purchasePriceText == '') {
                        Notification.warning({message: 'PurchasePrice can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.itemTypeNameText) || $scope.itemTypeNameText == '') {
                        Notification.warning({message: 'ItemTypeName can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.brandNameText) || $scope.brandNameText == '') {
                        Notification.warning({message: 'BrandName can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.hsnCodeText) || $scope.hsnCodeText == '') {
                        Notification.warning({message: 'HSN Code can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.unitPriceText) || $scope.unitPriceText == '') {
                        Notification.warning({message: 'Unit Price can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.qtyText) || $scope.qtyText == '') {
                        Notification.warning({message: 'Quantity can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.inventoryMovementNameText) || $scope.inventoryMovementNameText == '') {
                        Notification.warning({message: 'InventoryName can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.barCodeText) || $scope.barCodeText == '') {
                        Notification.warning({message: 'Barcode can not be Empty', positionX: 'center', delay: 2000});}
                    else if(angular.isUndefined($scope.fileNameText) || $scope.fileNameText == '') {
                        Notification.warning({message: 'FileName can not be Empty', positionX: 'center', delay: 2000});}
                    else {
                        $("#add_new_Item_modal").modal('hide');
                        Notification.success({message: 'Item Created  successfully', positionX: 'center', delay: 2000});
                        // $scope.removeCustomerDetails();
                        $scope.getIcItemList();
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
