package com.lanrensoft.generator.auto.build.service;

import com.lanrensoft.generator.auto.model.Table;
import com.lanrensoft.generator.auto.model.TableColumn;
import com.lanrensoft.generator.auto.utils.BuildNameTool;

/**
 * Created by 张钦 on 2016/7/21.
 */
public class ControllerBuildService {
    public static String getCriteria(Table table) {
        StringBuffer java = new StringBuffer();
        String tableCaseName = BuildNameTool.getCaseName(table.getTableName());
        for (TableColumn column : table.getListColumn()) {
            String columnName = BuildNameTool.getName(column.getColumnName());
            String myBatisColumnName = BuildNameTool.getMyBatisColumnName(column.getColumnName());
            if (!column.isCanQuery()||column.isKey()) {
                continue;
            }
            java.append("       if(" + tableCaseName + ".get" + myBatisColumnName + "()!=null){\r\n");
            java.append("           criteria.and" + columnName + "EqualTo(" + tableCaseName + ".get" + myBatisColumnName + "());\r\n");
            java.append("          }\r\n");
        }
        return java.toString();
    }

    public static String getSql(Table table) {
        StringBuffer java = new StringBuffer();
        String tableCaseName = BuildNameTool.getCaseName(table.getTableName());
        System.out.println(table.getTableName());
        for (TableColumn column : table.getListColumn()) {
            String columnName = BuildNameTool.getName(column.getColumnName());
            if (!column.isCanQuery()||column.isKey()) {
                continue;
            }
            java.append("       if(" + tableCaseName + ".get" + columnName + "()!=null){\r\n");
            java.append("           sql.append(\" and \").append(alias).append(\"."+column.getColumnName()+"\").append(\" = '\").append(" + tableCaseName + ".get" + columnName + "()).append(\" ' \");\r\n");
            java.append("          }\r\n");
        }
        return java.toString();
    }
}
