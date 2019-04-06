package com.lanrensoft.generator.auto.build.service;

import com.google.common.collect.Lists;
import org.beetl.core.Template;
import com.lanrensoft.generator.auto.build.enu.FieldType;
import com.lanrensoft.generator.auto.model.FormImageModel;
import com.lanrensoft.generator.auto.model.HtmlBuildFieldModel;
import com.lanrensoft.generator.auto.model.Table;
import com.lanrensoft.generator.auto.model.TableColumn;
import com.lanrensoft.generator.auto.template.BuildTemplate;
import com.lanrensoft.generator.auto.utils.BuildNameTool;

import java.util.List;

/**
 * Created by 张钦 on 2016/7/21.
 */
public class FormBuildService {
    public static String getFormCommonField(Table table) {
        StringBuffer html = new StringBuffer();
        String tableCaseName = BuildNameTool.getCaseName(table.getTableName());
        String key = BuildNameTool.getCaseName(table.getKey());
        html.append("<input type='hidden' name='" + key + "' id='" + key + "' value='${" + tableCaseName + "." + key + "!}'>");
        html.append("<input type='hidden' name='common_token' id='common_token' value='${common_token!}'>");
        return html.toString();
    }

    public static String getFormObjectSet(Table table) {
        StringBuffer html = new StringBuffer();
        String key = BuildNameTool.getCaseName(table.getKey());
        for (TableColumn column : table.getListColumn()) {
            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());

            if(!column.isCanAdd()){
                continue;
            }
            if(column.getRemarks().indexOf(FieldType.RADIO.getType())!=-1){
                html.append("formObject."+columnCaseName+"=($('input[name=\""+columnCaseName+"\"]:checked').val()==''?null:$('input[name=\""+columnCaseName+"\"]:checked').val()); \n ");
            } else if(column.getRemarks().indexOf(FieldType.HTML.getType())!=-1){
                html.append("formObject." + columnCaseName + "="+columnCaseName+"Edit.getData(); \n ");
            }else {
                html.append("formObject." + columnCaseName + "=$('#" + columnCaseName + "').val()==''?null:$('#" + columnCaseName + "').val(); \n ");
            }
        }
        html.append("formObject." + key + "=$('#" + key+"').val()==''?null:$('#" + key+"').val(); \n ");
        System.out.println(html);
        return html.toString();
    }

    public static HtmlBuildFieldModel getFormField(Table table) {

        String case_table_name = BuildNameTool.getCaseName(table.getTableName());
        StringBuffer html = new StringBuffer();
        StringBuffer js = new StringBuffer();
        List<TableColumn> imageFileColumns = Lists.newArrayList();
        for (TableColumn column : table.getListColumn()) {
            String fieldName = column.getColumnName();
            String columnCaseName = BuildNameTool.getCaseName(column.getColumnName());
            String columnTilte = column.getRemarks();
            if(!column.isCanAdd()){
                continue;
            }
            if (columnTilte.indexOf(FieldType.IMAGE.getType()) != -1||columnTilte.indexOf(FieldType.FILE.getType()) != -1) {
                imageFileColumns.add(column);
            }  else if (columnTilte.indexOf(FieldType.RADIO.getType()) != -1) {
                StringBuffer htmlRadio = new StringBuffer();
                int t = columnTilte.indexOf(FieldType.RADIO.getType());
                String showLabel = columnTilte.substring(0, t);
                String showValue = columnTilte.substring(t + FieldType.RADIO.getType().length(), columnTilte.length());
                htmlRadio.append("<div class=\"form-group\" >\n ");
                htmlRadio.append("<label class=\"col-sm-2 col-xs-2 control-label\">" + showLabel + "</label>\n ");
                htmlRadio.append("<div class=\"col-sm-6 col-xs-6\">\n ");
                String[] str = showValue.split("\\|");
                String autoName = case_table_name + "_" + columnCaseName;
                String value = "";
                htmlRadio.append("<div class=\"radio\">\n ");
                for (String string : str) {
                    String[] str2 = string.split(":");
                    if (value.equals("")) {
                        value = str2[0];
                    }
                    String checked = "";
                    if (value.equals(str2[0])) {
                        checked = "checked='checked'";
                    }
                    if(str2.length==1) {
                        htmlRadio.append("<label><input " + checked + " auto_name='" + autoName + "' type=\"radio\"  name=\"" + columnCaseName + "\" value=\"" + str2[0] + "\"/>" + str2[0] + "</label>\n ");
                    }else{
                        htmlRadio.append("<label><input " + checked + " auto_name='" + autoName + "' type=\"radio\"  name=\"" + columnCaseName + "\" value=\"" + str2[0] + "\"/>" + str2[1] + "</label>\n ");

                    }
                    }
                htmlRadio.append(" \n ");
                htmlRadio.append("</div>\n ");
                htmlRadio.append("</div>\n ");
                htmlRadio.append(" </div>\n ");
                js.append("   \n   $('input[auto_name=\"" + autoName + "\"]').each(function(){\n ");
                js.append("   \n   if('${" + case_table_name + "." + columnCaseName + "!}'==this.value){ \n ");
                js.append("            $(this).attr('checked','checked');\n ");
                js.append("           }\n ");
                js.append("          });\n ");
                html.append(htmlRadio);
            } else if (columnTilte.indexOf(FieldType.SELECT.getType()) != -1) {
                StringBuffer htmlSelect = new StringBuffer();
                int t = columnTilte.indexOf(FieldType.SELECT.getType());
                String showLabel = columnTilte.substring(0, t);
                String showValue = columnTilte.substring(t + FieldType.SELECT.getType().length(), columnTilte.length());
                htmlSelect.append("<div class=\"form-group\">\n ");
                htmlSelect.append("<label class=\"control-label col-sm-2 col-xs-2\">" + showLabel + "</label>\n ");
                htmlSelect.append("<div class=\"col-sm-6 col-xs-6\">\n ");
                htmlSelect.append("	<select class=\"form-control\" id=\"" + columnCaseName + "\"\n ");
                htmlSelect.append("		name=\"" + columnCaseName + "\" "+column.getValidate()+">\n ");
                String[] str = showValue.split("\\|");
                String value = "";
                for (String string : str) {
                    String[] str2 = string.split(":");
                    if (value.equals("")) {
                        value = str2[0];
                    }
                    String selected = "";
                    if (value.equals(str2[0])) {
                        selected = "selected='selected'";
                    }
                    if(str2.length==1){
                        htmlSelect.append("	<option " + selected + " value=\"" + str2[0] + "\">" + str2[0] + "</option>\n ");
                    }else {
                        htmlSelect.append("	<option " + selected + " value=\"" + str2[0] + "\">" + str2[1] + "</option>\n ");
                    }
                }
                htmlSelect.append("</select>\n ");
                htmlSelect.append("</div>\n ");
                htmlSelect.append("</div>\n ");
                js.append("\n	$(\"#" + columnCaseName + "\").val(\"${" + case_table_name + "." + columnCaseName + "!}\");\n ");
                js.append("	if('${" + case_table_name + "." + columnCaseName + "!}'==''){\n ");
                js.append("	    $(\"#" + columnCaseName + "\").val('" + value + "');\n ");
                js.append("	}\n ");
                html.append(htmlSelect);
            } else if (columnTilte.indexOf(FieldType.DIC.getType()) != -1) {
                StringBuffer htmlSelect = new StringBuffer();
                int t = columnTilte.indexOf(FieldType.DIC.getType());
                String showLabel = columnTilte.substring(0, t);
                String dicCode = columnTilte.substring(t).replace(FieldType.DIC.getType(),"").replace(" ","");
                htmlSelect.append("<div class=\"form-group\">\n ");
                htmlSelect.append("<label class=\"control-label col-sm-2 col-xs-2\">" + showLabel + "</label>\n ");
                htmlSelect.append("<div class=\"col-sm-6 col-xs-6\">\n ");
                htmlSelect.append("	<select class=\"form-control\" id=\"" + columnCaseName + "\"\n ");
                htmlSelect.append("		name=\"" + columnCaseName + "\" "+column.getValidate()+">\n ");
                htmlSelect.append("</select>\n ");
                htmlSelect.append("</div>\n ");
                htmlSelect.append("</div>\n ");
                  js.append("   componentSelectInit(      \n ");
                  js.append("           {                        \n ");
                  js.append("                   ctxPath:'',       \n ");
                   js.append("          tableName:\"sys_dictionary\",        \n ");
                   js.append("          showValueField:\"name\",             \n ");
                   js.append("          valueField:\"value\",                 \n ");
                   js.append("selectId:\"" + columnCaseName + "\"  ,      \n ");
                   js.append("          where:\" where code ='"+dicCode+"' \"     \n ");
                    js.append("                             }              \n ");
                    js.append("                             ,function(){   \n ");
                    js.append("  $('#"+columnCaseName+"').val(\"${" + case_table_name + "." + columnCaseName + "!}\");           \n ");
                    js.append(" });                         \n ");
                html.append(htmlSelect);
            }else if (columnTilte.indexOf(FieldType.DATE.getType()) != -1) {

                html.append("<div class=\"form-group\" >\n ");
                html.append("<label class=\"col-sm-2 col-xs-2 control-label\">" +  columnTilte.substring(0,columnTilte.indexOf(FieldType.DATE.getType())) + "</label>\n ");
                html.append("<div class=\"col-sm-6 col-xs-6\">\n ");
                String focus = "";
                if (columnTilte.indexOf(FieldType.DATE.getType())!=-1) {

                    String f =  "yyyy-MM-dd HH:mm:ss";
                    if(columnTilte.indexOf("_f_")!=-1){
                        f = columnTilte.substring(columnTilte.indexOf("_f_")).replace("_f_","");
                    }
                    js.append("  laydate.render({\n" +
                            "    elem: '#"+columnCaseName+"',\n" +
                            "    type: 'datetime'\n" +
                            "    ,format: '"+f+"'\n" +
                            "  });");
                    html.append("<input  type=\"text\" " + focus + " name=\"" + columnCaseName + "\" id=\"" + columnCaseName + "\" class=\"form-control\" " + column.getValidate() + " value='${" + case_table_name + "." + columnCaseName + "!,\""+f+"\"}' >\n ");

                }else{
                    html.append("<input  type=\"text\" " + focus + " name=\"" + columnCaseName + "\" id=\"" + columnCaseName + "\" class=\"form-control\" " + column.getValidate() + " value='${" + case_table_name + "." + columnCaseName + "!}' >\n ");

                }
                html.append("</div>\n ");
                html.append(" </div>\n ");
            } else if (columnTilte.indexOf(FieldType.TEXTAREA.getType()) != -1) {

                html.append("<div class=\"form-group\" >\n ");
                html.append("<label class=\"col-sm-2 col-xs-2 control-label\">" +  columnTilte.substring(0,columnTilte.indexOf(FieldType.TEXTAREA.getType())) + "</label>\n ");
                html.append("<div class=\"col-sm-6 col-xs-6\">\n ");
                html.append("  <textarea name=\"" + columnCaseName + "\" id=\""+columnCaseName+"\" placeholder=\"请输入内容\" " + column.getValidate() + " class=\"layui-textarea\">${" + case_table_name + "." + columnCaseName + "!}</textarea>");
                html.append("</div>\n ");
                html.append(" </div>\n ");
            }else if (columnTilte.indexOf(FieldType.HTML.getType()) != -1) {

                html.append("<div class=\"form-group\" >\n ");
                html.append("<label class=\"col-sm-2 col-xs-2 control-label\">" +  columnTilte.substring(0,columnTilte.indexOf(FieldType.HTML.getType())) + "</label>\n ");
                html.append("<div class=\"col-sm-6 col-xs-6\">\n ");
                html.append("  <textarea name=\"" + columnCaseName + "\" id=\""+columnCaseName+"\" placeholder=\"请输入内容\" " + column.getValidate() + " class=\"layui-textarea\">${" + case_table_name + "." + columnCaseName + "!}</textarea>");
                html.append("</div>\n ");
                html.append(" </div>\n ");
                js.append("var "+columnCaseName+"Edit = CKEDITOR.replace( '"+columnCaseName+"' );");
            }  else {
                html.append("<div class=\"form-group\" >\n ");
                html.append("<label class=\"col-sm-2 col-xs-2 control-label\">" + columnTilte + "</label>\n ");
                html.append("<div class=\"col-sm-6 col-xs-6\">\n ");
                html.append("<input  type=\"text\"  name=\"" + columnCaseName + "\" id=\"" + columnCaseName + "\" class=\"form-control\" " + column.getValidate() + " value='${" + case_table_name + "." + columnCaseName + "!}' >\n ");
                html.append("</div>\n ");
                html.append(" </div>\n ");
            }
        }
        for (TableColumn imageFileColumn : imageFileColumns) {
            String columnCaseName = BuildNameTool.getCaseName(imageFileColumn.getColumnName());
            String columnTilte = imageFileColumn.getRemarks();
            if (columnTilte.indexOf(FieldType.IMAGE.getType()) != -1) {
                FormImageModel formImageModel = new FormImageModel();
                formImageModel.setCoulumnCaseName(columnCaseName);
                formImageModel.setCoulumnTitle(columnTilte.replace(FieldType.IMAGE.getType(), ""));
                formImageModel.setFormValue("${" + case_table_name + "." + columnCaseName + "!}");
                Template template = BuildTemplate.getTemplate("consoleFormImage.temp");
                template = BuildTemplate.bind(formImageModel, template);
                html.append(template.render());
                js.append("consoleUploadAliImg('"+columnCaseName+"','');\n\n");
            } else if (columnTilte.indexOf(FieldType.FILE.getType()) != -1) {
                FormImageModel formImageModel = new FormImageModel();
                formImageModel.setCoulumnCaseName(columnCaseName);
                formImageModel.setCoulumnTitle(columnTilte.replace(FieldType.FILE.getType(), ""));
                formImageModel.setFormValue("${" + case_table_name + "." + columnCaseName + "!}");
                Template template = BuildTemplate.getTemplate("consoleFormFile.temp");
                template = BuildTemplate.bind(formImageModel, template);
                html.append(template.render());
                js.append(" consoleUploadAliFile('"+columnCaseName+"','');\n\n");
            }
        }
        return new HtmlBuildFieldModel(js.toString(),html.toString());
    }
}
