package com.lanrensoft.generator.mybatis.util;


import com.google.common.collect.Lists;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.List;

public class GeneratorMetadata {
    public static void generate(String generatorConfigPath) {
        try {
            List<String> warnings = Lists.newArrayList();
            boolean overwrite = true;
            File configFile = new File(generatorConfigPath);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            configFile.deleteOnExit();
            System.out.println(">>>>>>>>>所有文件重新生成完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void remove() {
        FilesPath filesPath = new FilesPath();
        File mapperPath = new File(filesPath.getMapperPath());
        if (mapperPath.isDirectory()) {
            File[] mapperFiles = mapperPath.listFiles();
            for (File file : mapperFiles) {
                file.delete();
            }
            System.out.println(">>>>>>>>>mapper接口已清空    (" + mapperPath + ")");
        } else {
            System.out.println("<<<<<<<<<mapper接口路径不存在  (" + mapperPath + ")");
        }
        File daoImplPath = new File(filesPath.getDaoImplPath());
        if (daoImplPath.isDirectory()) {
            File[] daoImplFiles = daoImplPath.listFiles();
            for (File file : daoImplFiles) {
                file.delete();
            }
            System.out.println(">>>>>>>>>xml已清空 (" + daoImplPath + ")");
        } else {
            System.out.println("<<<<<<<<<xml路径不存在   (" + daoImplPath + ")");
        }
        File modelPoPath = new File(filesPath.getModelPoPath());
        if (modelPoPath.isDirectory()) {
            File[] modelPoFiles = modelPoPath.listFiles();
            for (File file : modelPoFiles) {
                file.delete();
            }
            System.out.println(">>>>>>>>>model已清空   (" + modelPoPath + ")");
        } else {
            System.out.println("<<<<<<<<<model路径不存在 (" + modelPoPath + ")");
        }
    }
}
