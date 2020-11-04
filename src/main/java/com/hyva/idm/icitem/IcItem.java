package com.hyva.idm.icitem;


import com.hyva.idm.entity.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IcItem extends BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long itemId;
    private String itemCode;
    private String itemName;
    private String ItemDesc;
    private Long taxId;
    private String outputTaxId;
    private double stock;
    private double discountAmountRpercent;
    private boolean isDiscountInPercent;
    private double salesPrice;
    private double purchasePrice;
    private String itemTypeName;
    private String itemCategoryName;
    private String brandName;
    private String itemStatus;
    private String inclusiveJSON;
    private String hsnCode;
    private double unitPrice;
    private double unitPriceIn;
    private Long itemCategoryId;
    private Long itemTypeId;
    private String UnitOfMeasurementId;
    private Long mscid;
    private String inputTaxId;
    private String qty;
    private Long brandId;
    private float cess;
    private Long inventoryMovementId;
    private String inventoryMovementName;
    private String barCode;
    private String fileName;
    private double discountAmt;
    private String hiConnectCompnyRegNo;
    private String itemSelectedCarts;

    public String getItemSelectedCarts() {
        return itemSelectedCarts;
    }

    public void setItemSelectedCarts(String itemSelectedCarts) {
        this.itemSelectedCarts = itemSelectedCarts;
    }

    public String getHiConnectCompnyRegNo() {
        return hiConnectCompnyRegNo;
    }

    public void setHiConnectCompnyRegNo(String hiConnectCompnyRegNo) {
        this.hiConnectCompnyRegNo = hiConnectCompnyRegNo;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return ItemDesc;
    }

    public void setItemDesc(String itemDesc) {
        ItemDesc = itemDesc;
    }

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }



    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getDiscountAmountRpercent() {
        return discountAmountRpercent;
    }

    public void setDiscountAmountRpercent(double discountAmountRpercent) {
        this.discountAmountRpercent = discountAmountRpercent;
    }

    public boolean isDiscountInPercent() {
        return isDiscountInPercent;
    }

    public void setDiscountInPercent(boolean discountInPercent) {
        isDiscountInPercent = discountInPercent;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    public String getItemCategoryName() {
        return itemCategoryName;
    }

    public void setItemCategoryName(String itemCategoryName) {
        this.itemCategoryName = itemCategoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getInclusiveJSON() {
        return inclusiveJSON;
    }

    public void setInclusiveJSON(String inclusiveJSON) {
        this.inclusiveJSON = inclusiveJSON;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getUnitPriceIn() {
        return unitPriceIn;
    }

    public void setUnitPriceIn(double unitPriceIn) {
        this.unitPriceIn = unitPriceIn;
    }

    public Long getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(Long itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public Long getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Long itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getOutputTaxId() {
        return outputTaxId;
    }

    public void setOutputTaxId(String outputTaxId) {
        this.outputTaxId = outputTaxId;
    }

    public String getUnitOfMeasurementId() {
        return UnitOfMeasurementId;
    }

    public void setUnitOfMeasurementId(String unitOfMeasurementId) {
        UnitOfMeasurementId = unitOfMeasurementId;
    }

    public String getInputTaxId() {
        return inputTaxId;
    }

    public void setInputTaxId(String inputTaxId) {
        this.inputTaxId = inputTaxId;
    }

    public Long getMscid() {
        return mscid;
    }

    public void setMscid(Long mscid) {
        this.mscid = mscid;
    }


    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public float getCess() {
        return cess;
    }

    public void setCess(float cess) {
        this.cess = cess;
    }

    public Long getInventoryMovementId() {
        return inventoryMovementId;
    }

    public void setInventoryMovementId(Long inventoryMovementId) {
        this.inventoryMovementId = inventoryMovementId;
    }

    public String getInventoryMovementName() {
        return inventoryMovementName;
    }

    public void setInventoryMovementName(String inventoryMovementName) {
        this.inventoryMovementName = inventoryMovementName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public double getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(double discountAmt) {
        this.discountAmt = discountAmt;
    }
}
