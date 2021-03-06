package com.hyva.idm.pkt.pktRelations;

import com.hyva.idm.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * krishna
 */
@Entity
@Data
public class PktPermissions extends BaseEntity<String> implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long pktPermissionId;
    private String keyName;
    private String keyValue;
    private String keyPlaceHolder;
    private String keyVisibility;
    private String keyValidation;
    private String keyPriority;
    private String keyAction;
    private String keyReference;
    private String keyGroup;
    private String keySubscription;
    private String keyTiming;
    private String status;
    private String permission;
    private String descriptor;
    private String roundOff;
    private String sync;
    private String columnPosition;
    private String operator;
    private String columnName;
    @Column(name="operation" ,columnDefinition = "LONGTEXT")
    private String operation;
    private String tableName;
    private String inputType;
    private String valueee;
    @Column(name="childKey" ,columnDefinition = "LONGTEXT")
    private String childKey;

    @Column(name="searchKey" ,columnDefinition = "LONGTEXT")
    private String searchKey;
    @Column(name="dropdownKey" ,columnDefinition = "LONGTEXT")
    private String dropdownKey;
    @Column(name="calcKey" ,columnDefinition = "LONGTEXT")
    private String calcKey;
    private String menuKey;
    @Column(name="createKeys" ,columnDefinition = "LONGTEXT")
    private String createKeys;
    @Column(name="updateKey" ,columnDefinition = "LONGTEXT")
    private String updateKey;
    @Column(name="conditionKey" ,columnDefinition = "LONGTEXT")
    private String conditionKey;
    @Column(name="plusKey" ,columnDefinition = "LONGTEXT")
    private String plusKey;

    private String top_pos;
    private String width_pos;
    private String left_pos;
    private String height_pos;
    private String position_pos;
    private String subMenuKey;
    private String dragid;
    private String Alignment;
    private String Max_Width;
    private String Max_Height;
    private String Min_Width;
    private String Font;
    private String Font_Size;
    private String Weight;
    private String Letter_Spacing;
    private String Font_Colour;
    private String Line_Height;
    private String Decoration;
    private String Box_Shadow;
    private String X_Position;
    private String Y_Position;
    private String Colour;
    private String BackGround_Colour;
    private String Border_Width;
    private String Border_Style;
    private String Border_Colour;
    private String Size;



    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public PktPermissions() {
    }

    public Long getPktPermissionId() {
        return pktPermissionId;
    }

    public void setPktPermissionId(Long pktPermissionId) {
        this.pktPermissionId = pktPermissionId;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getKeyPlaceHolder() {
        return keyPlaceHolder;
    }

    public void setKeyPlaceHolder(String keyPlaceHolder) {
        this.keyPlaceHolder = keyPlaceHolder;
    }

    public String getKeyVisibility() {
        return keyVisibility;
    }

    public void setKeyVisibility(String keyVisibility) {
        this.keyVisibility = keyVisibility;
    }

    public String getKeyValidation() {
        return keyValidation;
    }

    public void setKeyValidation(String keyValidation) {
        this.keyValidation = keyValidation;
    }

    public String getKeyPriority() {
        return keyPriority;
    }

    public void setKeyPriority(String keyPriority) {
        this.keyPriority = keyPriority;
    }

    public String getKeyAction() {
        return keyAction;
    }

    public void setKeyAction(String keyAction) {
        this.keyAction = keyAction;
    }

    public String getKeyReference() {
        return keyReference;
    }

    public void setKeyReference(String keyReference) {
        this.keyReference = keyReference;
    }

    public String getKeyGroup() {
        return keyGroup;
    }

    public void setKeyGroup(String keyGroup) {
        this.keyGroup = keyGroup;
    }

    public String getKeySubscription() {
        return keySubscription;
    }

    public void setKeySubscription(String keySubscription) {
        this.keySubscription = keySubscription;
    }

    public String getKeyTiming() {
        return keyTiming;
    }

    public void setKeyTiming(String keyTiming) {
        this.keyTiming = keyTiming;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getRoundOff() {
        return roundOff;
    }

    public void setRoundOff(String roundOff) {
        this.roundOff = roundOff;
    }

    public String getSync() {
        return sync;
    }

    public void setSync(String sync) {
        this.sync = sync;
    }

    public String getColumnPosition() {
        return columnPosition;
    }

    public void setColumnPosition(String columnPosition) {
        this.columnPosition = columnPosition;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getValueee() {
        return valueee;
    }

    public void setValueee(String valueee) {
        this.valueee = valueee;
    }

    public String getChildKey() {
        return childKey;
    }

    public void setChildKey(String childKey) {
        this.childKey = childKey;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getDropdownKey() {
        return dropdownKey;
    }

    public void setDropdownKey(String dropdownKey) {
        this.dropdownKey = dropdownKey;
    }

    public String getCalcKey() {
        return calcKey;
    }

    public void setCalcKey(String calcKey) {
        this.calcKey = calcKey;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getCreateKeys() {
        return createKeys;
    }

    public void setCreateKeys(String createKeys) {
        this.createKeys = createKeys;
    }

    public String getUpdateKey() {
        return updateKey;
    }

    public void setUpdateKey(String updateKey) {
        this.updateKey = updateKey;
    }

    public String getConditionKey() {
        return conditionKey;
    }

    public void setConditionKey(String conditionKey) {
        this.conditionKey = conditionKey;
    }

    public String getPlusKey() {
        return plusKey;
    }

    public void setPlusKey(String plusKey) {
        this.plusKey = plusKey;
    }

    public String getTop_pos() {
        return top_pos;
    }

    public void setTop_pos(String top_pos) {
        this.top_pos = top_pos;
    }

    public String getWidth_pos() {
        return width_pos;
    }

    public void setWidth_pos(String width_pos) {
        this.width_pos = width_pos;
    }

    public String getLeft_pos() {
        return left_pos;
    }

    public void setLeft_pos(String left_pos) {
        this.left_pos = left_pos;
    }

    public String getHeight_pos() {
        return height_pos;
    }

    public void setHeight_pos(String height_pos) {
        this.height_pos = height_pos;
    }

    public String getPosition_pos() {
        return position_pos;
    }

    public void setPosition_pos(String position_pos) {
        this.position_pos = position_pos;
    }

    public String getSubMenuKey() {
        return subMenuKey;
    }

    public void setSubMenuKey(String subMenuKey) {
        this.subMenuKey = subMenuKey;
    }

    public String getDragid() {
        return dragid;
    }

    public void setDragid(String dragid) {
        this.dragid = dragid;
    }

    public String getAlignment() {
        return Alignment;
    }

    public void setAlignment(String alignment) {
        Alignment = alignment;
    }

    public String getMax_Width() {
        return Max_Width;
    }

    public void setMax_Width(String max_Width) {
        Max_Width = max_Width;
    }

    public String getMax_Height() {
        return Max_Height;
    }

    public void setMax_Height(String max_Height) {
        Max_Height = max_Height;
    }

    public String getMin_Width() {
        return Min_Width;
    }

    public void setMin_Width(String min_Width) {
        Min_Width = min_Width;
    }

    public String getFont() {
        return Font;
    }

    public void setFont(String font) {
        Font = font;
    }

    public String getFont_Size() {
        return Font_Size;
    }

    public void setFont_Size(String font_Size) {
        Font_Size = font_Size;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getLetter_Spacing() {
        return Letter_Spacing;
    }

    public void setLetter_Spacing(String letter_Spacing) {
        Letter_Spacing = letter_Spacing;
    }

    public String getFont_Colour() {
        return Font_Colour;
    }

    public void setFont_Colour(String font_Colour) {
        Font_Colour = font_Colour;
    }

    public String getLine_Height() {
        return Line_Height;
    }

    public void setLine_Height(String line_Height) {
        Line_Height = line_Height;
    }

    public String getDecoration() {
        return Decoration;
    }

    public void setDecoration(String decoration) {
        Decoration = decoration;
    }

    public String getBox_Shadow() {
        return Box_Shadow;
    }

    public void setBox_Shadow(String box_Shadow) {
        Box_Shadow = box_Shadow;
    }

    public String getX_Position() {
        return X_Position;
    }

    public void setX_Position(String x_Position) {
        X_Position = x_Position;
    }

    public String getY_Position() {
        return Y_Position;
    }

    public void setY_Position(String y_Position) {
        Y_Position = y_Position;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        Colour = colour;
    }

    public String getBackGround_Colour() {
        return BackGround_Colour;
    }

    public void setBackGround_Colour(String backGround_Colour) {
        BackGround_Colour = backGround_Colour;
    }

    public String getBorder_Width() {
        return Border_Width;
    }

    public void setBorder_Width(String border_Width) {
        Border_Width = border_Width;
    }

    public String getBorder_Style() {
        return Border_Style;
    }

    public void setBorder_Style(String border_Style) {
        Border_Style = border_Style;
    }

    public String getBorder_Colour() {
        return Border_Colour;
    }

    public void setBorder_Colour(String border_Colour) {
        Border_Colour = border_Colour;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }
}
