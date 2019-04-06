package com.lanrensoft.generator.auto.utils;

import org.beetl.core.Template;
import com.lanrensoft.generator.auto.build.enu.FieldType;
import com.lanrensoft.generator.auto.model.BaseBuildModel;
import com.lanrensoft.generator.auto.model.TableColumn;
import com.lanrensoft.generator.auto.template.BuildTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by 张钦 on 2016/6/27.
 */
public class BuildTool {
    public static FieldType[] notBuildQueryField ={FieldType.IMAGE,FieldType.FILE,FieldType.HTML,FieldType.TEXTAREA,FieldType.HTML};
    public static String[] noc={"uuid","create_time","update_time","update_user","create_user","da_id","app_uuid","company_id"};
    /**
     * 获取id列
     * @param list
     * @return
     */
    public static TableColumn getIdColumn(List<TableColumn> list){
        for (TableColumn tableColumn : list) {
            if (tableColumn.isKey())
                return  tableColumn;
        }
        return null;
    }

    public static boolean canSetQuery(String title){
        for (FieldType s : notBuildQueryField) {
            if(title.indexOf(s.getType())!=-1){
                return  false;
            }
        }
        return true;
    }

     public static void writeFile(BaseBuildModel formModel, String fileSrc, String templateName, boolean isReplace){
        Template template = BuildTemplate.getTemplate(templateName);
        template = BuildTemplate.bind(formModel, template);
        try {
            File f = new File(fileSrc);
            if(isReplace==true||(!f.exists()&&isReplace==false)) {
                if (!f.getParentFile().exists()) {
                    f.getParentFile().mkdirs();
                }
                f.createNewFile();
                FileTool.write(fileSrc, template.render());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
