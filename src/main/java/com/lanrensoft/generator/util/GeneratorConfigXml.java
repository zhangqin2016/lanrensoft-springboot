package com.lanrensoft.generator.util;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lanrensoft.common.kit.PathKit;
import com.lanrensoft.common.kit.Prop;
import org.apache.commons.io.FileUtils;
import org.beetl.core.Template;
import com.lanrensoft.common.kit.PropKit;
import com.lanrensoft.generator.jdbc.WeJdbcTemplate;
import com.lanrensoft.generator.model.Table;
import com.lanrensoft.generator.util.template.MyBatisGeneratorBuildTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GeneratorConfigXml {
    public static final Prop cfgMap = PropKit.use("mybatis-generator" + File.separator + "cfg.properties");
    public static String generate() {

        Prop jdbcMap = cfgMap;
        cfgMap.AddProp(jdbcMap);
        FilesPath filesPath = new FilesPath();
        String targetProject = filesPath.getProjectPath().replace("\\", "/");
        List<Table> tableList = Lists.newArrayList();
        String table_schema = cfgMap.get("jdbc.database");
        List<Map<String, Object>> tableNameList = WeJdbcTemplate.getAllTableFromDb(table_schema);
        for (Map<String, Object> map : tableNameList) {
            tableList.add(new Table(map.get("table_name").toString()));
        }
        String localDriveDir =  PathKit.getRootClassPath() + File.separator +"mybatis-generator"+File.separator+cfgMap.get("jdbc.type");
        String localDrivePath = localDriveDir + File.separator + new File(localDriveDir).listFiles()[0].getName();

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("location", localDrivePath);
        dataMap.put("driverClass", cfgMap.get("jdbc.driver"));
        dataMap.put("connectionUrl", cfgMap.get("jdbc.url").replace("&","&amp;"));
        dataMap.put("userId", cfgMap.get("jdbc.username"));
        dataMap.put("password", cfgMap.get("jdbc.password"));
        dataMap.put("modelTargetPackage", cfgMap.get("modelPoPath"));
        dataMap.put("sqlMapTargetPackage", cfgMap.get("mapperPath"));
        dataMap.put("javaClientTargetPackage", cfgMap.get("daoImplPath"));
        dataMap.put("targetProject", targetProject);
        dataMap.put("tablesList", tableList);

        String generatorConfigPath = "generatorConfig.xml";
//        String generatorConfigPath=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + File.separator + "generatorConfig.xml";
        String outPath =  PathKit.getRootClassPath() + File.separator + generatorConfigPath;
        try {
            Template template = MyBatisGeneratorBuildTemplate.getTemplate("generatorConfigTemplate.temp");
            template.binding(dataMap);
            FileUtils.writeStringToFile(new File(outPath), template.render(),"utf-8");
            System.out.println("generatorConfig.xml 文件生成完毕");
            return outPath.replace(File.separatorChar, '/');
        } catch (IOException e) {
            System.out.println("generatorConfig.xml 文件生成失败");
            e.printStackTrace();
            return outPath.replace(File.separatorChar, '/');
        }
    }
}
