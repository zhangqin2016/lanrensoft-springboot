package com.lanrensoft.generator.auto.model;

import com.lanrensoft.generator.auto.build.enu.FieldType;
import com.lanrensoft.generator.auto.utils.BuildNameTool;
import com.lanrensoft.generator.auto.utils.BuildTool;

import java.util.Arrays;

public class TableColumn {

    private String columnName;
    private String typeName;
    private String javaTypeName;
    private String remarks;
    private boolean isKey;
    private boolean isNull;
    private boolean canQuery;
    private int length;
    private int xiaoshu;
    private boolean canAdd;
    public boolean isCanAdd() {
        if ( isKey() || Arrays.asList(BuildTool.noc).contains(columnName)) {
         return false;
        }
        return true;
    }

    public void setCanAdd(boolean canAdd) {
        this.canAdd = canAdd;
    }


    public String getCaseColumnName(){
        String columnCaseName = BuildNameTool.getCaseName(columnName);
        return columnCaseName;
    }
    public String getShowTitle(){
        String s = remarks;
        if (s.indexOf(FieldType.RADIO.getType()) != -1) {
            int t = s.indexOf(FieldType.RADIO.getType());
            s = s.substring(0, t);
        } else if (s.indexOf(FieldType.SELECT.getType()) != -1) {
            int t = s.indexOf(FieldType.SELECT.getType());
            s = s.substring(0, t);
        } else if (s.indexOf(FieldType.IMAGE.getType()) != -1) {
            s = s.replace(FieldType.IMAGE.getType(), "");
        } else if (s.indexOf(FieldType.FILE.getType()) != -1) {
            s = s.replace(FieldType.FILE.getType(), "");
        }else if (s.indexOf(FieldType.DATE.getType()) != -1) {
            s = s.substring(0,s.indexOf(FieldType.DATE.getType()));
        }else if (s.indexOf(FieldType.DIC.getType()) != -1) {
            StringBuffer htmlSelect = new StringBuffer();
            int t = s.indexOf(FieldType.DIC.getType());
            s = s.substring(0,t);
        }else if (s.indexOf(FieldType.HTML.getType()) != -1) {
            int t = s.indexOf(FieldType.HTML.getType());
            s = s.substring(0,t);
        }
        else if (s.indexOf(FieldType.TEXTAREA.getType()) != -1) {
            int t = s.indexOf(FieldType.TEXTAREA.getType());
            s = s.substring(0,t);
        }
        return s;
    }
    public String getValidate(){
        String checketlength = "";
        String type = "";
        if(!isNull){
            type+="required";
        }
        if(typeName.equals("int") || typeName.equals("decimal") || typeName.equals("smallint")){
            type+=" number";
        }else     if(javaTypeName.toLowerCase().indexOf("string")!=-1){
            checketlength = "maxlength='"+length+"'";
        }
        return "check-type=\""+type+"\""+" "+checketlength;
    }
    public boolean isCanQuery() {
        if (isKey() || Arrays.asList(BuildTool.noc).contains(getColumnName())) {
               return false;
        }
        if(!BuildTool.canSetQuery(remarks)){
            return false;
        }
        if(typeName.equals("text")||typeName.equals("clob")||typeName.equals("blob")){
            return false;
        }else{
            return true;
        }
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

    public void setCanQuery(boolean canQuery) {
        this.canQuery = canQuery;
    }

    public int getXiaoshu() {
        return xiaoshu;
    }

    public void setXiaoshu(int xiaoshu) {
        this.xiaoshu = xiaoshu;
    }

    public String getColumnName() {
        return columnName.toLowerCase();
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isKey() {
        return isKey;
    }

    public void setIsKey(boolean isKey) {
        this.isKey = isKey;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((columnName == null) ? 0 : columnName.hashCode());
        result = prime * result + (isKey ? 1231 : 1237);
        result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
        result = prime * result
                + ((typeName == null) ? 0 : typeName.hashCode());
        return result;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TableColumn other = (TableColumn) obj;
        if (columnName == null) {
            if (other.columnName != null)
                return false;
        } else if (!columnName.equals(other.columnName))
            return false;
        return true;

    }


    public void setKey(boolean isKey) {
        this.isKey = isKey;
    }

    public String getJavaTypeName() {
        return javaTypeName;
    }

    public void setJavaTypeName(String javaTypeName) {
        this.javaTypeName = javaTypeName;
    }
}
