package com.lanrensoft.generator.auto.utils;/**
 * Created by zhangqin on 2017/5/12.
 */


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.lanrensoft.common.kit.PropKit;
import com.lanrensoft.generator.auto.model.Table;
import com.lanrensoft.generator.auto.model.TableColumn;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取数据结构工厂类
 *
 * @author
 * @create 2017-05-12 9:17
 **/
public class GetTableMysql extends  GetTableAbs {
    @Override
    public List<Table> getTable() {
        String columnSql = "SELECT *  FROM information_schema.`COLUMNS` where TABLE_NAME = ? and TABLE_SCHEMA =?";
        String tableSql = " select * from information_schema.tables where table_schema=? and table_type='base table'";
        List<Table> listTable = new ArrayList<Table>();
        Object[] param = {GetTable.prop.get("jdbc.database")};
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(tableSql, param);
        for (Map<String, Object> map : maps) {
            Table table = new Table();
            String tableName = String.valueOf(map.get("TABLE_NAME"));
            String tableDes = String.valueOf(map.get("TABLE_COMMENT"));
            table.setTableName(tableName);
            table.setTableTitle(tableDes);
            Object[] param2 = {tableName,GetTable.prop.get("jdbc.database")};
            List<Map<String, Object>> maps2 = jdbcTemplate.queryForList(columnSql, param2);
            List<TableColumn> tableColumns = Lists.newArrayList();
            for (Map<String, Object> stringObjectMap : maps2) {

                TableColumn tableColumn = new TableColumn();
                tableColumn.setNull(String.valueOf(stringObjectMap.get("IS_NULLABLE")).equalsIgnoreCase("yes"));
                tableColumn.setColumnName(String.valueOf(stringObjectMap.get("COLUMN_NAME")));
                if(StringUtils.isNotBlank(String.valueOf(stringObjectMap.get("COLUMN_KEY")))){
                    tableColumn.setIsKey(true);
                    table.setKey(tableColumn.getColumnName());
                }else{
                    tableColumn.setIsKey(false);
                }
                tableColumn.setTypeName(String.valueOf(stringObjectMap.get("DATA_TYPE")));
                tableColumn.setJavaTypeName(TableColumnTool.getJavaType(tableColumn));

                Integer length=0;
                if( stringObjectMap.get("CHARACTER_MAXIMUM_LENGTH")!=null||stringObjectMap.get("NUMERIC_PRECISION")!=null) {
                    length = stringObjectMap.get("CHARACTER_MAXIMUM_LENGTH") == null ? Integer.valueOf(String.valueOf(stringObjectMap.get("NUMERIC_PRECISION"))) : Integer.valueOf(String.valueOf(stringObjectMap.get("CHARACTER_MAXIMUM_LENGTH")));
                }
                tableColumn.setLength(length);
                tableColumn.setRemarks(String.valueOf(stringObjectMap.get("COLUMN_COMMENT")));
                tableColumns.add(tableColumn);
            }
            table.setListColumn(tableColumns);
            listTable.add(table);

        }
        return listTable;
    }

    public static void main(String[] args) {
        GetTableFactory getTableFactory = new GetTableMysql();
        System.out.println(JSON.toJSONString(getTableFactory.getTable()));
    }
}
