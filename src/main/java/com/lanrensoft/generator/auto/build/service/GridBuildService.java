package com.lanrensoft.generator.auto.build.service;

import com.lanrensoft.generator.auto.build.enu.FieldType;
import com.lanrensoft.generator.auto.model.Table;
import com.lanrensoft.generator.auto.model.TableColumn;
import com.lanrensoft.generator.auto.utils.BuildNameTool;
import com.lanrensoft.generator.auto.utils.BuildTool;

import java.util.Arrays;

/**
 * Created by 张钦 on 2016/7/21.
 */
public class GridBuildService {

    public static  String getTableFormatter(Table table) {
        StringBuffer html = new StringBuffer();
        for (TableColumn column : table.getListColumn()) {
            String columnTilte = column.getRemarks();
            String fmv = BuildNameTool.getCaseName(table.getTableName())+column.getColumnName()+"Formatter";
            if (column.getRemarks().indexOf(FieldType.IMAGE.getType()) != -1) {
                html.append("       function " + fmv + "(value) \r\n");
                html.append("       { \r\n");
                html.append("         return '<a href=\"'+value+'\" target=\"_blank\" > <img style=\"height:50px;\" src=\"'+value+'\" alt=\"缩略图\"> </a>';\r\n");
                html.append("       }\r\n");
            } else if (column.getRemarks().indexOf(FieldType.SELECT.getType()) != -1 || column.getRemarks().indexOf(FieldType.RADIO.getType()) != -1) {
                int t = columnTilte.indexOf(FieldType.RADIO.getType());
                int length = t == -1 ? FieldType.SELECT.getType().length() : FieldType.RADIO.getType().length();
                t = t == -1 ? columnTilte.indexOf(FieldType.SELECT.getType()) : t;
                String showValue = columnTilte.substring(t + length, columnTilte.length());
                String[] str = showValue.split("\\|");
                html.append(" function "+fmv+"(value) \r\n");
                html.append("   { \r\n");
                html.append("       var showValue=''; \r\n");
                html.append("       switch(value+''){\r\n");
                for (String string : str) {
                    String[] str2 = string.split(":");
                    String value = str2[0];
                    String show = str2[0];
                    if (str2.length == 2) {
                        show = str2[1];
                    }
                    html.append("       case '" + value + "': \r\n");
                    html.append("       showValue = '" + show + "';\r\n");
                    html.append("       break;\r\n");
                }
                html.append("       }\r\n");
                html.append("    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    \r\n");
                html.append("       return '<span class=\"label label-warning\">'+showValue+'</span>';\r\n");
                html.append("   }else{\r\n");
                html.append("       return '<span class=\"label label-info\">'+showValue+'</span>';\r\n");
                html.append("   }\r\n");
                html.append("   }\r\n");
            }else if (columnTilte.indexOf(FieldType.DIC.getType()) != -1) {
                String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());
                int t = columnTilte.indexOf(FieldType.DIC.getType());
                String showLabel = columnTilte.substring(0, t);
                String dicCode = columnTilte.substring(t).replace(FieldType.DIC.getType(),"").replace(" ","");
                html.append("  \n ");
                html.append("   componentSelectInit(      \n ");
                html.append("           {                        \n ");
                html.append("                   ctxPath:'',       \n ");
                html.append("          tableName:\"sys_dictionary\",        \n ");
                html.append("          showValueField:\"name\",             \n ");
                html.append("          valueField:\"value\",                 \n ");
                html.append("   selectId:\"" + columnCaseName + "\"  ,      \n ");
                html.append("          where:\" where code ='"+dicCode+"' \"     \n ");
                html.append("                             }              \n ");
                html.append("                             ,function(){   \n ");
                html.append(" });                         \n ");
            }
        }
        return html.toString();
    }

    public static String getTableTh(Table table) {
        StringBuffer html = new StringBuffer();

        for (TableColumn column : table.getListColumn()) {

            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());
            if (Arrays.asList(BuildTool.noc).contains(column.getColumnName())||column.getRemarks().indexOf(FieldType.HTML.getType()) != -1||column.getRemarks().indexOf(FieldType.TEXTAREA.getType()) != -1 ) {
                continue;
            }
            if(column.getRemarks().indexOf(FieldType.DATE.getType())!=-1){
                html.append(" <th data-field='" + columnCaseName + "' data-sortable='true' data-formatter='dateTimeFormat'>" + column.getShowTitle() + "</th>\r\n ");
            }else
            if (column.getColumnName().equals(table.getKey())) {
                html.append(" <th data-field='" + columnCaseName + "' data-visible='false'>ID</th>\r\n ");
            } else if (column.getRemarks().indexOf(FieldType.IMAGE.getType()) != -1 || column.getRemarks().indexOf(FieldType.SELECT.getType()) != -1 || column.getRemarks().indexOf(FieldType.RADIO.getType()) != -1) {
                html.append(" <th data-field='" + columnCaseName + "' data-sortable='true' data-formatter='" + BuildNameTool.getCaseName(table.getTableName())+column.getColumnName() + "Formatter'>" + column.getShowTitle() + "</th>\r\n ");
            } else {
                html.append(" <th data-sortable='true' data-field='" + columnCaseName + "'>" + column.getShowTitle() + "</th>\r\n ");
            }
        }
        html.append(" <th data-field='" + BuildNameTool.getCaseName(table.getKey()) + "' data-formatter='" + BuildNameTool.getCaseName(table.getTableName()) + "TableOperate'>操作</th>\r\n ");
        return html.toString();
    }

    public static String getQuerySet(Table table) {
        StringBuffer html = new StringBuffer();
        for (TableColumn column : table.getListColumn()) {
    if(column.isCanQuery()){
      String columnCaseName = column.getCaseColumnName();
        html.append("    objQuery." + columnCaseName + "=$('#" + columnCaseName + "').val()==''?null:$('#" + columnCaseName + "').val(); \r\n ");
    }
        }
        return html.toString();
    }

    public static String getDianDianDian(String src) {
        src = src == null ? "" : src;
        if (src.length() < 5) {
            return src;
        } else {
            src = src.substring(0, 4) + "...";
        }
        return src;
    }

    public static String getQuery(Table table) {
        String tableCaseName = BuildNameTool.getCaseName(table.getTableName());
        StringBuffer html = new StringBuffer();
        for (TableColumn column : table.getListColumn()) {
            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());
            String columnTilte = column.getRemarks();
          if(!column.isCanQuery()){
              continue;
          }
            html.append("<div class='form-group col-md-4 col-xs-6 zq-query'>\r\n ");
            if (columnTilte.indexOf(FieldType.RADIO.getType()) != -1 || columnTilte.indexOf(FieldType.SELECT.getType()) != -1) {
                int t = columnTilte.indexOf(FieldType.RADIO.getType());
                int length = t == -1 ? FieldType.SELECT.getType().length() : FieldType.RADIO.getType().length();
                t = t == -1 ? columnTilte.indexOf(FieldType.SELECT.getType()) : t;
                String showLabel = columnTilte.substring(0, t);
                String showValue = columnTilte.substring(t + length, columnTilte.length());
                String[] str = showValue.split("\\|");
                html.append("<label title='" + showLabel + "' >" + getDianDianDian(showLabel) + "：</label>\r\n ");
                html.append("<select class=\"form-control\" id=\"" + columnCaseName + "\" name=\""+ columnCaseName + "\">\r\n ");
                html.append("<option  value=\"\">请选择...</option>\r\n ");
                for (String string : str) {
                    String[] str2 = string.split(":");
                    if(str2.length==1){
                        html.append("	<option  value=\"" + str2[0] + "\">" + str2[0] + "</option>\r\n ");
                    }else {
                        html.append("	<option  value=\"" + str2[0] + "\">" + str2[1] + "</option>\r\n ");
                    }
                }
                html.append("</select>\r\n ");
            } else if (columnTilte.indexOf(FieldType.DIC.getType()) != -1) {
                StringBuffer htmlSelect = new StringBuffer();
                int t = columnTilte.indexOf(FieldType.DIC.getType());
                String showLabel = columnTilte.substring(0, t);
                htmlSelect.append("<label class=\"control-label col-sm-2 col-xs-2\">" + showLabel + "</label>\n ");
                htmlSelect.append("	<select class=\"form-control\" id=\"" + columnCaseName + "\"\n ");
                htmlSelect.append("		name=\"" + columnCaseName + "\" "+column.getValidate()+">\n ");
                htmlSelect.append("</select>\n ");
                html.append(htmlSelect);
            }else {
                String focus = "";
                html.append("<label title='" + column.getRemarks() + "'  >" + getDianDianDian(column.getRemarks()) + "：</label>\r\n ");
                if (column.getTypeName().equals("datetime")) {
                    focus = "onFocus=\"WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})\"";
                }
                html.append("<input " + focus + " onkeyup='"+tableCaseName+"ConsoleGrid.enterToQuery(event);' type='text' class='form-control' id='" + columnCaseName + "' name='" + columnCaseName + "' placeholder=''>\r\n ");
            }
            html.append("</div>\r\n ");
        }
        return html.toString();
    }
}
