package com.lanrensoft.generator.auto.build;

import com.lanrensoft.generator.auto.model.DaoModel;
import com.lanrensoft.generator.auto.model.Table;
import com.lanrensoft.generator.auto.utils.BuildNameTool;
import com.lanrensoft.generator.auto.utils.BuildTool;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */
public class DaoXmlBuild implements IBuild {
    @Override
    public void build(List<Table> tables, String src,boolean isReplace) {
        for (Table table : tables) {
            String tableName = table.getTableName();
            DaoModel controllerModel = new DaoModel();
            controllerModel.setBeanName(BuildNameTool.getName(tableName));
                String fileSrc = src + BuildNameTool.getName(tableName) + "Dao.xml";
            BuildTool.writeFile(controllerModel,fileSrc,"consoleDaoXml.temp",isReplace);
        }
    }
    public void build(List<Table> tables, String src){
        this.build(tables,src,true);
    }
}
