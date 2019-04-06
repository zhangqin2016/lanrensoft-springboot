package com.lanrensoft.generator.auto.build;

/**
 * Created by 张钦 on 2016/6/29.
 */
public class BuildFactory {

    public IBuild createForm() {
        return new FormBuild();
    }
    public IBuild createControllerTool() {
        return new ControllerToolBuild();
    }
    public IBuild createController() {
        return new ControllerBuild();
    }

    public IBuild createGrid() {
        return new GridBuild();
    }

    public IBuild createDao() {
        return new DaoBuild();
    }
    public IBuild createDaoXml() {
        return new DaoXmlBuild();
    }
    public IBuild createService() {
        return new ServiceBuild();
    }

}
