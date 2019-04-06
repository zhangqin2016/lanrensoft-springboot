package com.lanrensoft.generator.auto.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张钦 on 2016/6/16.
 */
public class GridModel extends BaseBuildModel {
    private String symbol = "%";
    private String tableName;
    private String tableTitle;
    private String tableQuery;
    private String tableTh;
    private String baseUrl;
    private String tableIdName;
    private String tableQuerySet;
    private String tableFormatter;

    public String getTableTitle() {
        return tableTitle;
    }

    public void setTableTitle(String tableTitle) {
        this.tableTitle = tableTitle;
    }

    public String getTableFormatter() {
        return tableFormatter;
    }

    public void setTableFormatter(String tableFormatter) {
        this.tableFormatter = tableFormatter;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    private String ctxPath = "${ctxPath}";

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

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableQuery() {
        return tableQuery;
    }

    public void setTableQuery(String tableQuery) {
        this.tableQuery = tableQuery;
    }

    public String getTableTh() {
        return tableTh;
    }

    public void setTableTh(String tableTh) {
        this.tableTh = tableTh;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getTableIdName() {
        return tableIdName;
    }

    public void setTableIdName(String tableIdName) {
        this.tableIdName = tableIdName;
    }

    public String getTableQuerySet() {
        return tableQuerySet;
    }

    public void setTableQuerySet(String tableQuerySet) {
        this.tableQuerySet = tableQuerySet;
    }

    public String getCtxPath() {
        return ctxPath;
    }

    public void setCtxPath(String ctxPath) {
        this.ctxPath = ctxPath;
    }
}
