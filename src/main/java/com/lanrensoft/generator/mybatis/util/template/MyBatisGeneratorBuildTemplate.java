package com.lanrensoft.generator.mybatis.util.template;


import com.lanrensoft.common.kit.PathKit;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;

import java.io.File;
import java.io.IOException;

/**
 * Created by 张钦 on 2016/6/16.
 */
public class MyBatisGeneratorBuildTemplate {

    static {
        String root = PathKit.getRootClassPath() + File.separator + "mybatis-generator";
        FileResourceLoader resourceLoader = new FileResourceLoader(root, "utf-8");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gt = new GroupTemplate(resourceLoader, cfg);
    }

    private static final GroupTemplate gt;

    public static Template getTemplate(String name) {
        return gt.getTemplate("/" + name);
    }


}
