package com.lanrensoft.generator.auto.build;

import com.google.common.collect.Lists;
import com.lanrensoft.generator.auto.AutoConfig;
import com.lanrensoft.generator.auto.build.service.ControllerBuildService;
import com.lanrensoft.generator.auto.model.ControllerQueryModel;
import com.lanrensoft.generator.auto.model.ControllerQueryToolModel;
import com.lanrensoft.generator.auto.model.Table;
import com.lanrensoft.generator.auto.utils.BuildNameTool;
import com.lanrensoft.generator.auto.utils.BuildTool;

import java.util.List;

/**
 * Created by 张钦 on 2016/6/16.
 */
public class ControllerToolBuild implements IBuild {

    @Override
    public void build(List<Table> tables, String src,boolean isReplace) {
        List<ControllerQueryModel> controllerQueryModelList = Lists.newArrayList();
        for (Table table : tables) {
            String tableName = table.getTableName();
            ControllerQueryModel controllerQueryModel = new ControllerQueryModel();
            controllerQueryModel.setBasePackage(AutoConfig.basePage);
            controllerQueryModel.setTableCaseName(BuildNameTool.getCaseName(tableName));
            controllerQueryModel.setTableName(BuildNameTool.getName(tableName));
            controllerQueryModel.setWhere(ControllerBuildService.getCriteria(table));
            controllerQueryModel.setWhereSql(ControllerBuildService.getSql(table));
            controllerQueryModelList.add(controllerQueryModel);
        }
                ControllerQueryToolModel controllerQueryToolModel = new ControllerQueryToolModel();
                controllerQueryToolModel.setBasePackage( AutoConfig.basePage);
                controllerQueryToolModel.setCriterias(controllerQueryModelList);
                String fileSrc2 = src +"ControllerQueryTool.java";
                BuildTool.writeFile(controllerQueryToolModel,fileSrc2,"ControllerQuery.temp",isReplace);
    }
    public void build(List<Table> tables, String src){
        this.build(tables,src,true);
    }
}
