package com.lanrensoft.generator.auto.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.lanrensoft.generator.auto.model.Table;
import com.lanrensoft.generator.auto.model.TableColumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取数据结构工厂类
 *
 * @author
 * @create 2017-05-12 9:17
 **/
public class GetTableOracle extends  GetTableAbs {
    @Override
    public List<Table> getTable() {
        /*
         ;
*/
        String columnSql = "select a.*,b.COMMENTS  from user_tab_columns a ,user_col_comments b where a.COLUMN_NAME=b.COLUMN_NAME  and a.Table_Name=? and b.table_name=?";
        String tableSql = " select a.*,b.COMMENTS from user_tables a,user_tab_comments b WHERE a.TABLE_NAME=b.TABLE_NAME";
        List<Table> listTable = new ArrayList<Table>();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(tableSql);
        for (Map<String, Object> map : maps) {
            Table table = new Table();
            String tableName = String.valueOf(map.get("TABLE_NAME"));
            String tableDes = String.valueOf(map.get("COMMENTS"));
            table.setTableName(tableName);
            table.setTableTitle(tableDes);
            Object[] param2 = {tableName,tableName};
            List<Map<String, Object>> maps2 = jdbcTemplate.queryForList(columnSql, param2);
            List<TableColumn> tableColumns = Lists.newArrayList();
            for (Map<String, Object> stringObjectMap : maps2) {

                TableColumn tableColumn = new TableColumn();
                tableColumn.setNull(String.valueOf(stringObjectMap.get("NULLABLE")).equalsIgnoreCase("y"));
                tableColumn.setTypeName(String.valueOf(stringObjectMap.get("DATA_TYPE")));
                tableColumn.setColumnName(String.valueOf(stringObjectMap.get("COLUMN_NAME")));
                tableColumn.setJavaTypeName(TableColumnTool.getJavaType(tableColumn));

                Integer length=0;
                if( stringObjectMap.get("CHAR_LENGTH")!=null||stringObjectMap.get("DATA_PRECISION")!=null) {
                    length = stringObjectMap.get("CHAR_LENGTH") == null ? Integer.valueOf(String.valueOf(stringObjectMap.get("DATA_PRECISION"))) : Integer.valueOf(String.valueOf(stringObjectMap.get("CHAR_LENGTH")));
                }
                tableColumn.setLength(length);
                tableColumn.setRemarks(String.valueOf(stringObjectMap.get("COMMENTS")));
                int i = Integer.valueOf(jdbcTemplate.queryForMap("select count(a.column_name) C from user_cons_columns a, user_constraints b where a.constraint_name = b.constraint_name and b.constraint_type = 'P' and a.table_name = ? and a.column_name = ?",tableName.toUpperCase(),tableColumn.getColumnName().toUpperCase()).get("C").toString());
                tableColumn.setIsKey(i>0);
                tableColumns.add(tableColumn);
            }
            table.setListColumn(tableColumns);
            listTable.add(table);

        }
        return listTable;
    }

    public static void main(String[] args) {
        GetTableFactory getTableFactory = new GetTableOracle();
        System.out.println(JSON.toJSONString(getTableFactory.getTable()));
    }
}
