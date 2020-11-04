package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.Property;
import com.hyva.idm.sass.sasspojo.PropertyPojo;
import org.apache.commons.lang3.StringUtils;

public class PropertyMapper {

    public static Property mapPojoToEntity(PropertyPojo propertyPojo){
        Property property= new Property();
        property.setId(propertyPojo.getId());
        property.setDescription(propertyPojo.getDescription());
        property.setFile(propertyPojo.getFile());
        property.setName(propertyPojo.getName());
        property.setDeveloperId(propertyPojo.getDeveloperId());
        return property;
    }
}
