package com.lanrensoft.generator.auto.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张钦 on 2016/6/28.
 */
public class FormModel extends BaseBuildModel {
    private String tableTitle;
    private String symbol = "%";
    private String tableName;
    private String formObjectSet;
    private String ctxPath = "${ctxPath}";
    private String baseUrl;
    private String formField;
    private String formFieldJs;
    private String formCommonField;

    public String getFormFieldJs() {
        return formFieldJs;
    }

    public void setFormFieldJs(String formFieldJs) {
        this.formFieldJs = formFieldJs;
    }

    public String getTableTitle() {
        return tableTitle;
    }

    public void setTableTitle(String tableTitle) {
        this.tableTitle = tableTitle;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFormObjectSet() {
        return formObjectSet;
    }

    public void setFormObjectSet(String formObjectSet) {
        this.formObjectSet = formObjectSet;
    }

    public String getCtxPath() {
        return ctxPath;
    }

    public void setCtxPath(String ctxPath) {
        this.ctxPath = ctxPath;
    }

    public String getFormField() {
        return formField;
    }

    public String getFormCommonField() {
        return formCommonField;
    }

    public void setFormCommonField(String formCommonField) {
        this.formCommonField = formCommonField;
    }

    public void setFormField(String formField) {
        this.formField = formField;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if (obj != null) {
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
