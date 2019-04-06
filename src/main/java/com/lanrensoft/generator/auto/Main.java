package com.lanrensoft.generator.auto;


import com.lanrensoft.common.kit.PathKit;
import com.lanrensoft.generator.auto.build.BuildFactory;
import com.lanrensoft.generator.auto.model.Table;
import com.lanrensoft.generator.auto.utils.FileTool;
import com.lanrensoft.generator.auto.utils.GetTable;
import com.lanrensoft.generator.mybatis.util.GeneratorConfigXml;
import com.lanrensoft.generator.mybatis.util.GeneratorMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 张钦 on 2016/6/29.
 */
public class Main {

    public void build() throws SQLException, IOException {
        String generatorConfigPath = GeneratorConfigXml.generate();
        GeneratorMetadata.remove();
        GeneratorMetadata.generate(generatorConfigPath);
        System.out.println("开始生成");
        String src = "d:/autolaozhang/";
        System.out.println("生成位置:"+src);
        File file = new File(src);
        file.mkdirs();
        FileTool.deleteFile(file);
        file.mkdirs();
        BuildFactory buildFactory = new BuildFactory();
        List<Table> listTable = GetTable.tables();
        String workSpace = new File(PathKit.getWebRootPath()).getParent();
        String laoZhangService=workSpace+"/zhang.lao.service/src/main/java/zhang/lao/service/console/base/";
        String laoZhangDao=workSpace+"/zhang.lao.dao/src/main/java/zhang/lao/dao/base/";
        String laoZhangDaoXml=workSpace+"/zhang.lao.dao/src/main/resources/mybatis/mapper/base/";
        buildFactory.createController().build(listTable, src + "controler/");
        buildFactory.createForm().build(listTable, src + "html/");
        buildFactory.createGrid().build(listTable, src + "html/");
        buildFactory.createDao().build(listTable, laoZhangDao,false);
        buildFactory.createDaoXml().build(listTable, laoZhangDaoXml,false);
        buildFactory.createService().build(listTable, laoZhangService,false);
        buildFactory.createControllerTool().build(listTable, PathKit.getWebRootPath()+"/src/main/java/zhang/lao/build/mybatis/jdbc/base/tool/");
        System.out.println("生成成功");
        java.awt.Desktop.getDesktop().open(new File(src));
    }

    public static void main(String[] args) throws IOException, SQLException {
        new Main().build();
    }
}
