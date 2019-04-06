package com.lanrensoft.generator.auto.build;

import com.lanrensoft.generator.auto.build.service.GridBuildService;
import com.lanrensoft.generator.auto.model.GridModel;
import com.lanrensoft.generator.auto.model.Table;
import com.lanrensoft.generator.auto.model.TableColumn;
import com.lanrensoft.generator.auto.utils.BuildNameTool;
import com.lanrensoft.generator.auto.utils.BuildTool;

import java.io.File;
import java.util.List;

/**
 * Created by 张钦 on 2016/6/20.
 */
public class GridBuild implements IBuild {

    @Override
    public void build(List<Table> tables, String src,boolean isReplace) {
        for (Table table : tables) {
            String tableName = table.getTableName();
            GridModel gridModel = new GridModel();
            gridModel.setBaseUrl("/console/" + tableName + "/");
            TableColumn keyColumn = BuildTool.getIdColumn(table.getListColumn());
            gridModel.setTableTitle(table.getTableTitle());
            gridModel.setTableIdName(BuildNameTool.getCaseName(keyColumn.getColumnName()));
            gridModel.setTableName(BuildNameTool.getCaseName(tableName));
            gridModel.setTableQuery(GridBuildService.getQuery(table));
            gridModel.setTableTh(GridBuildService.getTableTh(table));
            gridModel.setTableQuerySet(GridBuildService.getQuerySet(table));
            gridModel.setTableFormatter(GridBuildService.getTableFormatter(table));
                String fileSrc = src + BuildNameTool.getCaseName(tableName) + File.separator + BuildNameTool.getCaseName(tableName) + "_table.html";
            BuildTool.writeFile(gridModel,fileSrc,"ConsoleGrid.temp",true);
            String fileSrc2 = src + BuildNameTool.getCaseName(tableName) + File.separator + BuildNameTool.getCaseName(tableName) + "Table.js";
            BuildTool.writeFile(gridModel,fileSrc2,"ConsoleGridJs.temp",isReplace);
        }
    }
    public void build(List<Table> tables, String src){
        this.build(tables,src,true);
    }

}
