package com.hyva.idm.sass.sasspojo;

import lombok.Data;

public class TablePojo {
   private String table;
   private String fromcolumn;
   private String comparecolumn;
   private String columnName;

   public String getTable() {
      return table;
   }

   public void setTable(String table) {
      this.table = table;
   }

   public String getFromcolumn() {
      return fromcolumn;
   }

   public void setFromcolumn(String fromcolumn) {
      this.fromcolumn = fromcolumn;
   }

   public String getComparecolumn() {
      return comparecolumn;
   }

   public void setComparecolumn(String comparecolumn) {
      this.comparecolumn = comparecolumn;
   }

   public String getColumnName() {
      return columnName;
   }

   public void setColumnName(String columnName) {
      this.columnName = columnName;
   }
}
