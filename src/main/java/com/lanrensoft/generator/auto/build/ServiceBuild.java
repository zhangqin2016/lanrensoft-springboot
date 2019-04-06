package com.lanrensoft.generator.auto.build;

import com.lanrensoft.generator.auto.AutoConfig;
import com.lanrensoft.generator.auto.model.ServiceModel;
import com.lanrensoft.generator.auto.model.Table;
import com.lanrensoft.generator.auto.model.TableColumn;
import com.lanrensoft.generator.auto.utils.BuildNameTool;
import com.lanrensoft.generator.auto.utils.BuildTool;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */
public class ServiceBuild implements IBuild {
    @Override
    public void build(List<Table> tables, String src,boolean isReplace) {


        for (Table table : tables) {

            String tableName = table.getTableName();
            ServiceModel serviceModel = new ServiceModel();
            serviceModel.setBasePackage(AutoConfig.basePage);
            serviceModel.setCaseBeanDao(BuildNameTool.getCaseName(tableName)+"Dao");
            serviceModel.setBeanName(BuildNameTool.getName(tableName));
            serviceModel.setBeanDao(BuildNameTool.getName(tableName) + "Dao");
            TableColumn keyColumn = BuildTool.getIdColumn(table.getListColumn());
            serviceModel.setIdType(keyColumn.getJavaTypeName());
            serviceModel.setIdName(BuildNameTool.getName(keyColumn.getColumnName()));
            serviceModel.setCaseBeanName(BuildNameTool.getCaseName(tableName));
            serviceModel.setBaseUrl("/console/" + tableName + "/");
                String fileSrc = src + BuildNameTool.getName(tableName) + "Service.java";
            BuildTool.writeFile(serviceModel,fileSrc,"consoleService.temp",isReplace);
        }
    }

    public void build(List<Table> tables, String src){
        this.build(tables,src,true);
    }
}
