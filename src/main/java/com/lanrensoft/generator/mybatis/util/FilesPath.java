package com.lanrensoft.generator.mybatis.util;


import com.lanrensoft.common.kit.Prop;
import com.lanrensoft.common.kit.PropKit;
import com.lanrensoft.generator.auto.utils.GetTable;

import java.io.File;

/**
 * Created by zhangqin on 2016/11/23.
 */
public class FilesPath {
    private String classPath;
    private String projectPath;
    private String mapperPath;
    private String daoImplPath;
    private String modelPoPath;
    private String resourcesPath;

    {
        init();
    }

    private void init() {
        Prop cfgMap = GetTable.prop;
        if (classPath == null || "".equals(classPath.trim())) {
            classPath = getClass().getResource("/").getFile().toString();
            classPath = classPath.substring(1, classPath.lastIndexOf('/'));
            classPath = classPath.substring(0, classPath.lastIndexOf('/')).replace('/', File.separatorChar);
        }
        if (projectPath == null || "".equals(projectPath.trim())) {
            projectPath = classPath.substring(0, classPath.lastIndexOf('\\'));
        }
        if (mapperPath == null || "".equals(mapperPath.trim())) {
            mapperPath = projectPath + File.separator + "src" + File.separator + "main" + File.separator
                    + "resources" + File.separator + cfgMap.get("mapperPath").replace('.', File.separatorChar);
        }
        if (daoImplPath == null || "".equals(daoImplPath.trim())) {
            daoImplPath = projectPath + File.separator + "src" + File.separator + "main" + File.separator
                    + "java" + File.separator + cfgMap.get("daoImplPath").replace('.', File.separatorChar);
        }
        if (modelPoPath == null || "".equals(modelPoPath.trim())) {
            modelPoPath = projectPath + File.separator + "src" + File.separator + "main" + File.separator
                    + "java" + File.separator + cfgMap.get("modelPoPath").replace('.', File.separatorChar);
        }
        if (resourcesPath == null || "".equals(resourcesPath.trim())) {
            resourcesPath = projectPath + File.separator + "src" + File.separator + "main" + File.separator
                    + "resources";
        }
    }

    public String getResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(String resourcesPath) {
        this.resourcesPath = resourcesPath;
    }

    public String getMapperPath() {
        return mapperPath;
    }

    public String getDaoImplPath() {
        return daoImplPath;
    }

    public String getModelPoPath() {
        return modelPoPath;
    }

    public String getProjectPath() {
        return projectPath;
    }


    @Override
    public String toString() {
        return "FilesPath{" +
                "classPath='" + classPath + '\'' +
                ", projectPath='" + projectPath + '\'' +
                ", mapperPath='" + mapperPath + '\'' +
                ", daoImplPath='" + daoImplPath + '\'' +
                ", modelPoPath='" + modelPoPath + '\'' +
                '}';
    }

    public static void main(String[] args) {
        FilesPath filesPath = new FilesPath();
        System.out.println(filesPath.toString());
    }
}
