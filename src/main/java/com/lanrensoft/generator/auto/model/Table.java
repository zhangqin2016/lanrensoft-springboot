package com.lanrensoft.generator.auto.model;

import java.util.List;

public class Table {
    private String tableTitle;
    private String tableName;
    private String key;
    private List<TableColumn> listColumn;

    public String getTableName() {
        return tableName.toLowerCase();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<TableColumn> getListColumn() {
        return listColumn;
    }

    public void setListColumn(List<TableColumn> listColumn) {
        this.listColumn = listColumn;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTableTitle() {
        return tableTitle;
    }

    public void setTableTitle(String tableTitle) {
        this.tableTitle = tableTitle;
    }
}
