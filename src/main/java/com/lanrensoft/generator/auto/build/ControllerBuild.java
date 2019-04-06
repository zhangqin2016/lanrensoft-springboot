package com.lanrensoft.generator.auto.build;

import com.google.common.collect.Lists;
import com.lanrensoft.common.utils.date.DateStyle;
import com.lanrensoft.common.utils.date.DateUtil;
import com.lanrensoft.generator.auto.AutoConfig;
import com.lanrensoft.generator.auto.build.service.ControllerBuildService;
import com.lanrensoft.generator.auto.model.ControllerModel;
import com.lanrensoft.generator.auto.model.ControllerQueryModel;
import com.lanrensoft.generator.auto.model.Table;
import com.lanrensoft.generator.auto.model.TableColumn;
import com.lanrensoft.generator.auto.utils.BuildNameTool;
import com.lanrensoft.generator.auto.utils.BuildTool;

import java.util.Date;
import java.util.List;

/**
 * Created by 张钦 on 2016/6/16.
 */
public class ControllerBuild implements IBuild {

    @Override
    public void build(List<Table> tables, String src,boolean isReplace) {
        List<ControllerQueryModel> controllerQueryModelList = Lists.newArrayList();

        for (Table table : tables) {
            System.out.println("建造controller:{}"+table.getTableName());
            String tableName = table.getTableName();
            ControllerModel controllerModel = new ControllerModel();
            controllerModel.setDescription(table.getTableTitle());
            controllerModel.setCreateTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_CN));
            controllerModel.setAuthor("ZhangQin");
            controllerModel.setBasePackage(AutoConfig.basePage);
            controllerModel.setCaseBeanService(BuildNameTool.getCaseName(tableName)+"Service");
            controllerModel.setBeanName(BuildNameTool.getName(tableName));
            controllerModel.setBeanService(BuildNameTool.getName(tableName) + "Service");
            TableColumn keyColumn = BuildTool.getIdColumn(table.getListColumn());
            controllerModel.setIdType(keyColumn.getJavaTypeName());
            controllerModel.setIdName(BuildNameTool.getName(keyColumn.getColumnName()));
            controllerModel.setCaseBeanName(BuildNameTool.getCaseName(tableName));
            controllerModel.setBaseUrl("/console/" + tableName + "/");
            ControllerQueryModel controllerQueryModel = new ControllerQueryModel();
            controllerQueryModel.setBasePackage(AutoConfig.basePage);
            controllerQueryModel.setTableCaseName(BuildNameTool.getCaseName(tableName));
            controllerQueryModel.setTableName(BuildNameTool.getName(tableName));
            controllerQueryModel.setWhere(ControllerBuildService.getCriteria(table));
            controllerQueryModel.setWhereSql(ControllerBuildService.getSql(table));
            controllerQueryModelList.add(controllerQueryModel);
            String fileSrc = src + BuildNameTool.getName(tableName) + "Controller.java";
            BuildTool.writeFile(controllerModel,fileSrc,"consoleController.temp",isReplace);
        }
    }

    public void build(List<Table> tables, String src){
        this.build(tables,src,true);
    }
}
