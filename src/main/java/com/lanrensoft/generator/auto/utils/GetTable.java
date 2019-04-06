package com.lanrensoft.generator.auto.utils;

import com.lanrensoft.common.kit.PathKit;
import com.lanrensoft.common.kit.Prop;
import com.lanrensoft.common.kit.PropKit;
import com.lanrensoft.generator.auto.model.Table;

import java.io.File;
import java.sql.SQLException;
import java.util.List;


public class GetTable {
   public static final Prop prop = PropKit.use(new File(PathKit.getRootClassPath()+File.separator+"mybatis-generator"+File.separator+"cfg.properties"));

    public static List<Table> tables() throws SQLException {

        if(prop.get("jdbc.type").equals("oracle")){
            GetTableFactory getTableFactory = new GetTableOracle();
            return getTableFactory.getTable();
        }else {
            GetTableFactory getTableFactory = new GetTableMysql();
            return getTableFactory.getTable();
        }
    }
}
